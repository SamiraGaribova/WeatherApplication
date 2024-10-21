package com.example.weatherapplication
//
//data class Car(
//    var model: String = "",
//    var year: Int = 0,
//    var price: Double = 0.00)
//
//
//fun main() {
//
//    var carModel:String?= "Mercedes"
//    carModel?.let {
//        println("not null $it")
//    }
//
//
//
//    val car = Car("BMW", 2020, 50000.00)
//    with(car) {
//        println(model)
//        println(year)
//        println(price)
//    }
//
//
//
//
//    val endirim = 15000.00.run {
//        this-500.00
//    }
//    println("Endirimli qiymet: $endirim")
//
//
//
//
//
//    val ikinciCar = Car().apply {
//        model = "Jeep"
//        year = 2015
//        price = 30000.00
//    }
//    println("Model: ${ikinciCar.model}, year: ${ikinciCar.year}, price: $${ikinciCar.price}")
//
//
//
//
//
//
//
//
//
//        val car2 = Car("Kia", 2022, 40000.00).also {
//
//            println("Car details: $it")
//        }.apply {
//            price-=500.00
//        }
//        println("new car details: $car2")
//    }