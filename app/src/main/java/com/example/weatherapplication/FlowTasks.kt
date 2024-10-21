package com.example.weatherapplication
//
//import kotlinx.coroutines.*
//import kotlinx.coroutines.flow.*
//import kotlin.random.Random
//
//fun main() = runBlocking {
//
//
//
//        val flow = flowOf("value1", "value2", "value3")
//
//        flow.transform { value ->
//            emit("${value}.1")
//            emit("${value}.2")
//            emit("${value}.3")
//        }.collect { emittedValue ->
//            println(emittedValue)
//        }
//
//
//
//
//
//
//
//
//    println("Task 1: Emit integers from 1 to 10 with 500ms delay")
//    flow {
//        for (i in 1..10) {
//            emit(i)
//            delay(500)
//        }
//    }.collect { value ->
//        println("Emitted: $value")
//    }
//
//
//
//
//    println("\nTask 2: Emit numbers and square each using map")
//    flow {
//        for (i in 1..10) {
//            emit(i)
//        }
//    }.map { value ->
//        value * value
//    }.collect { transformedValue ->
//        println("Squared value: $transformedValue")
//    }
//
//
//
//
//    println("\nTask 3: Flow that throws an exception after emitting the first 3 values and handles it using catch")
//    flow {
//        emit(1)
//        emit(2)
//        emit(3)
//        throw RuntimeException("error")
//    }.catch { e ->
//        println("Exception: ${e.message}")
//    }.collect { value ->
//        println("Emitted: $value")
//    }
//
//
//
//
//
//    println("\nTask 4: Flow that emits odd and even numbers and zips them together")
//    val oddFlow = flow {
//        for (i in 1..10 step 2) {
//            emit(i)
//        }
//    }
//
//    val evenFlow = flow {
//        for (i in 2..10 step 2) {
//            emit(i)
//        }
//    }
//
//    oddFlow.zip(evenFlow) { odd, even ->
//        odd to even
//    }.collect { pair ->
//        println("Odd: ${pair.first}, Even: ${pair.second}")
//    }
//
//
//
//
//
//
//    println("\nTask 5: Flow that emits random numbers and filters only even numbers")
//    flow {
//        repeat(10) {
//            emit(Random.nextInt(1, 100))
//        }
//    }.filter { value ->
//        value % 2 == 0
//    }.collect { evenValue ->
//        println("Even number: $evenValue")
//    }
//}
//
//
//
//
