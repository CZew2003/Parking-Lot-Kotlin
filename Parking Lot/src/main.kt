fun main() {
    processInput()
}

fun processInput() {
    var sentence = readLine()!!.split(" ")
    var parkHasBeenCreate = false
    var park: MutableList<Car> = mutableListOf()
    while (sentence[0] != "exit") {
        when (sentence[0]) {
            "create" -> {
                park = createPark(sentence[1].toInt())
                parkHasBeenCreate = true
            }
            "park" -> parkTheCar(sentence[1], sentence[2], parkHasBeenCreate, park)
            "leave" -> carIsLeaving(sentence[1].toInt(), parkHasBeenCreate, park)
            "status" -> showParkStatus(park, parkHasBeenCreate)
            "reg_by_color" -> searchNumbersByColor(sentence[1], park, parkHasBeenCreate)
            "spot_by_color" -> searchSpotsByColor(sentence[1], park, parkHasBeenCreate)
            "spot_by_reg" -> searchSpotsByNumber(sentence[1], park, parkHasBeenCreate)
            else -> println("Unknown command")
        }
        sentence = readLine()!!.split(" ")
    }
}

fun createPark(spots: Int): MutableList<Car> {
    println("Created a parking lot with $spots spots.")
    return MutableList(spots) {Car("", "", -1)}
}

fun parkTheCar(plate: String, color: String, parkIsCreated: Boolean, park: MutableList<Car>) {
    if (!parkIsCreated) {
        println("Sorry, a parking lot has not been created.")
        return
    }

    var spot = 0
    while (park[spot].color != "") {
        spot ++
        if (spot == park.size) {
            println("Sorry, the parking lot is full.")
            return
        }
    }
    println("$color car parked in spot ${spot + 1}.")
    park[spot] = Car(plate, color, spot + 1)
}

fun carIsLeaving(spot: Int, parkIsCreated: Boolean, park: MutableList<Car>) {
    if (!parkIsCreated) {
        println("Sorry, a parking lot has not been created.")
        return
    }

    if(park[spot - 1].color == "") {
        println("There is no car in spot $spot.")
        return
    }
    println("Spot $spot is free.")
    park[spot - 1] = Car("", "", -1)
}

fun showParkStatus(park: MutableList<Car>, parkIsCreated: Boolean) {
    if (!parkIsCreated) {
        println("Sorry, a parking lot has not been created.")
        return
    }

    var i = 0
    var counter = 0
    while (i < park.size) {
        if (park[i].color != "") {
            println("${i + 1} ${park[i].number} ${park[i].color}")
            counter++
        }
        i++
    }
    if(counter == 0) println("Parking lot is empty.")
}

fun searchNumbersByColor(color: String, park: MutableList<Car>, parkIsCreated: Boolean) {
    if (!parkIsCreated) {
        println("Sorry, a parking lot has not been created.")
        return
    }

    val cars = park.filter { it.color.toUpperCase().contains(color.toUpperCase()) }
    if(cars.isEmpty()) {
        println("No cars with color $color were found.")
        return
    }
    val numbers = mutableListOf<String>()
    cars.forEach {
        numbers.add(it.number)
    }
    println(numbers.joinToString(", "))
}

fun searchSpotsByColor(color: String, park: MutableList<Car>, parkIsCreated: Boolean) {
    if (!parkIsCreated) {
        println("Sorry, a parking lot has not been created.")
        return
    }

    val cars = park.filter { it.color.toUpperCase().contains(color.toUpperCase()) }
    if(cars.isEmpty()) {
        println("No cars with color $color were found.")
        return
    }
    val spots = mutableListOf<Int>()
    cars.forEach {
        spots.add(it.spot)
    }
    println(spots.joinToString(", "))
}

fun searchSpotsByNumber(number: String, park: MutableList<Car>, parkIsCreated: Boolean) {
    if (!parkIsCreated) {
        println("Sorry, a parking lot has not been created.")
        return
    }

    val cars = park.filter { it.number.contains(number) }
    if(cars.isEmpty()) {
        println("No cars with registration number $number were found.")
        return
    }
    val spots = mutableListOf<Int>()
    cars.forEach {
        spots.add(it.spot)
    }
    println(spots.joinToString(", "))
}

class Car(_number: String, _color: String, _spot: Int) {
    val number = _number
    val color = _color
    val spot = _spot
}