package dev.tasso.adventofcode._2021.day06

import dev.tasso.adventofcode._2021.readInput
import java.math.BigInteger

fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
//    check(part1(testInput) == BigInteger.valueOf(5394))
    check(part2(testInput) == BigInteger.valueOf(26984457539))

    val input = readInput("Day06")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")

}

fun part1(input: List<String>): BigInteger {

    return(simulatePopulation(input, 80))

}

fun part2(input: List<String>): BigInteger {

    return(simulatePopulation(input, 256))

}

fun simulatePopulation(populationInput: List<String>, numberOfDays : Int) : BigInteger{

    val population = IntRange(0, 8).map{ BigInteger.valueOf(0)}.toTypedArray()

    populationInput[0].split(",").map{ it.toInt() }.forEach{ population[it] += BigInteger.valueOf(1) }

    for(day in 1 .. numberOfDays ) {

        val numBred = population[0]

        for(position in 0 .. population.size - 2) {
            population[position] = population[position+1]
            if(position == 6) {
                population[6] += numBred
            }
        }

        population[population.size - 1] = numBred

    }

    return population.toList().sum()

}

fun Iterable<BigInteger>.sum(): BigInteger {
    var sum: BigInteger = BigInteger.ZERO
    for (element in this) {
        sum += element
    }
    return sum
}



