package dev.tasso.adventofcode._2021.day03

import dev.tasso.adventofcode._2021.readInput

fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 12)

    val input = readInput("Day03")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")

}

fun part1(input: List<String>): Int {

    var gammaString = ""
    var epsilonString = ""

    for(i in 0 until input[0].length) {

        val (zeros, ones) = input.map{c -> c[i]}.partition {c -> c == '0' }
        gammaString += if (zeros.size > ones.size) "0" else "1"
        epsilonString += if (zeros.size < ones.size) "0" else "1"
    }

    val gamma = Integer.parseInt(gammaString, 2)
    val epsilon = Integer.parseInt(epsilonString, 2)

    println("$gammaString $gamma")
    println("$epsilonString $epsilon")

    return  gamma * epsilon

}

fun part2(input: List<String>): Int {

    return input.size
}

