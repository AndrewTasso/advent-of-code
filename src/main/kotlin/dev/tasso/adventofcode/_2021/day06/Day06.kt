package dev.tasso.adventofcode._2021.day06

import dev.tasso.adventofcode.Solution
import java.math.BigInteger

class Day06 : Solution<BigInteger> {

    override fun part1(input: List<String>): BigInteger {

        return(simulatePopulation(input, 80))

    }

    override fun part2(input: List<String>): BigInteger {

        return(simulatePopulation(input, 256))

    }

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



