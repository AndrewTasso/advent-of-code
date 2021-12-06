package dev.tasso.adventofcode._2021.day06

import dev.tasso.adventofcode._2021.readInput

fun main() {

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day06_test")
//    check(part1(testInput) == 5394)
//    println(part2(testInput) == 1)

    val input = readInput("Day06")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")

}

fun part1(input: List<String>): Int {

    val population = IntRange(0, 8).map{0}.toIntArray()

    input[0].split(",").map{ it.toInt() }.forEach{ population[it] += 1 }

    val numberOfDays = 80

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

    return population.sum()

}

fun part2(input: List<String>): Int {

    return input.size
}


