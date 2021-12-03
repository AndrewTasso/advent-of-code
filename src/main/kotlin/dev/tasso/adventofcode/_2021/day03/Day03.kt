package dev.tasso.adventofcode._2021.day03

import dev.tasso.adventofcode._2021.readInput

fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

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

    return  gamma * epsilon

}

fun part2(input: List<String>): Int {

    var oxygenGeneratorValues = input.toList()
    var co2ScrubberValues = input.toList()

    for(i in 0 until oxygenGeneratorValues[0].length) {

        oxygenGeneratorValues = if (oxygenGeneratorValues.count { s -> s[i] == '1' } >= oxygenGeneratorValues.count { s -> s[i] == '0' }) {

            oxygenGeneratorValues.filter { s -> s[i] == '1' }

        } else {

            oxygenGeneratorValues.filter { s -> s[i] == '0' }

        }

        if (oxygenGeneratorValues.size == 1) break

    }

    for(i in 0 until co2ScrubberValues[0].length) {

        co2ScrubberValues = if (co2ScrubberValues.count { s -> s[i] == '0' } <= co2ScrubberValues.count { s -> s[i] == '1' }) {

            co2ScrubberValues.filter { s -> s[i] == '0' }

        } else {

            co2ScrubberValues.filter { s -> s[i] == '1' }

        }

        if (co2ScrubberValues.size == 1) break

    }

    val oxygenGeneratorRating = Integer.parseInt(oxygenGeneratorValues[0], 2)
    val co2ScrubberRating = Integer.parseInt(co2ScrubberValues[0], 2)

    return oxygenGeneratorRating * co2ScrubberRating
}


