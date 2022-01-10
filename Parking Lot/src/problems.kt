//fun main() {
//    processInput()
//}
//
//fun processInput() {
//    var sentence = readLine()!!.split(" ")
//    var parkHasBeenCreate = false
//    var park: MutableList<Car> = mutableListOf()
//    while (sentence[0] != "exit") {
//        when (sentence[0]) {
//            "create" -> {
//                park = createPark(sentence[1].toInt())
//                parkHasBeenCreate = true
//            }
//            "park" -> parkTheCar(sentence[1], sentence[2], parkHasBeenCreate, park)
//            "leave" -> carIsLeaving(sentence[1].toInt(), parkHasBeenCreate, park)
//            "status" -> showParkStatus(park, parkHasBeenCreate)
//            else -> println("Unknown command")
//        }
//        sentence = readLine()!!.split(" ")
//    }
//}
//
//fun createPark(spots: Int): MutableList<Car> {
//    println("Created a parking lot with $spots spots.")
//    return MutableList<Car>(spots) {Car("", "")}
//}
//
//fun parkTheCar(plate: String, color: String, parkIsCreated: Boolean, park: MutableList<Car>) {
//    if (!parkIsCreated) {
//        println("Sorry, a parking lot has not been created.")
//        return
//    }
//
//    var spot = 0
//    while (park[spot].color != "") {
//        spot ++
//        if (spot == park.size) {
//            println("Sorry, the parking lot is full.")
//            return
//        }
//    }
//    println("$color car parked in spot ${spot + 1}.")
//    park[spot] = Car(plate, color)
//}
//
//fun carIsLeaving(spot: Int, parkIsCreated: Boolean, park: MutableList<Car>) {
//    if (!parkIsCreated) {
//        println("Sorry, a parking lot has not been created.")
//        return
//    }
//
//    if(park[spot - 1].color == "") {
//        println("There is no car in spot $spot.")
//        return
//    }
//    println("Spot $spot is free.")
//    park[spot - 1] = Car("", "")
//}
//
//fun showParkStatus(park: MutableList<Car>, parkIsCreated: Boolean) {
//    if (!parkIsCreated) {
//        println("Sorry, a parking lot has not been created.")
//        return
//    }
//
//    var i = 0
//    var counter = 0
//    while (i < park.size) {
//        if (park[i].color != "") {
//            println("${i + 1} ${park[i].number} ${park[i].color}")
//            counter++
//        }
//        i++
//    }
//    if(counter == 0) println("Parking lot is empty.")
//}
//
//class Car(_number: String, _color: String) {
//    val number = _number
//    val color = _color
//}
//
