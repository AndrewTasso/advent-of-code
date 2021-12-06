package dev.tasso.adventofcode

import java.io.File

fun main(args: Array<String>) {

    val year = args[0]
    val day = args[1]
    val part = args[2]
    val inputPath = args[3]

    val solution = SolutionFactory.getSolution(year = year, day = day)

    val lines = File(inputPath).readLines()

    val result = if(part == "1") {
        solution.part1(lines)
    } else {
        solution.part2(lines)
    }

    println("AOC $year, Day $day, Part $part: $result")

}

