package dev.tasso.adventofcode._2021.day01

import dev.tasso.adventofcode._2021.readInput

fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(testInput)
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")

}

fun part1(input: List<String>): Int =
    input.map{ it.toInt() }
         .windowed(2)
         .count{ it[1] > it[0] }

fun part2(input: List<String>): Int =
    input.map{ it.toInt() }
         .windowed(3)
         .map{ it.sum() }
         .windowed(2)
         .count{ it[1] > it[0] }
