package dev.tasso.adventofcode

import kotlin.reflect.full.primaryConstructor

class SolutionFactory {

    companion object {
        fun getSolution(year: String, day: String) : Solution<*> {

            val clazz = Class.forName("dev.tasso.adventofcode._$year.day$day.Day${day}").kotlin
            val instance = clazz.primaryConstructor?.call()

            if(instance is Solution<*>) {
                return instance
            } else {
                throw IllegalStateException("Valid Solution could not be created")
            }
        }

        }

}