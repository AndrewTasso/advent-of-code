package dev.tasso.adventofcode2021.day02

import dev.tasso.adventofcode2021.readInput
import kotlin.math.absoluteValue


fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    //TODO solve this
    check(part2(testInput) == 6)

    val input = readInput("Day02")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")

}

fun part1(input: List<String>): Int {

    // Split the input into lists of horizontal and vertical movements
    val (horizontalMovements, verticalMovements) = input.partition { it.startsWith("forward") }

    // We can only go forward, so strip the direction text, and sum all the values to get the total
    val horizontalTotal = horizontalMovements.map { it.removePrefix("forward ") }
                                             .sumOf { it.toInt() }
    // Up is positive, down is negative. Strip the direction text if we're going up, or replace with a  negative sign.
    // Then, sum all the values to get the total
    val verticalTotal = verticalMovements.map { it.removePrefix("up ") }
                                         .map { it.replace("down ", "-") }
                                         .sumOf { it.toInt() }

    return horizontalTotal * verticalTotal.absoluteValue
}

fun part2(input: List<String>): Int = input.size
