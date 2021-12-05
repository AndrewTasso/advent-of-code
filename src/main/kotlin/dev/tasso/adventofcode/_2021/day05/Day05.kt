package dev.tasso.adventofcode._2021.day05

import dev.tasso.adventofcode._2021.readInput
import java.lang.Integer.max

fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
//    check(part2(testInput) == 10)

    val input = readInput("Day05")
    println("Part 1: ${part1(input)}")
//    println("Part 2: ${part2(input)}")

}

fun part1(input: List<String>): Int {

    val ventLines = input.map { it.split(" -> ").map{it.split(",").map { it.toInt() }}}
                         .map { Line(Coordinate(it.first().first(), it.first().last()), Coordinate(it.last().first(), it.last().last())) }

    val floorWidth = ventLines.maxOf { max(it.startCoordinate.x, it.endCoordinate.x) + 1  }
    val floorHeight = ventLines.maxOf { max(it.startCoordinate.y, it.endCoordinate.y) + 1  }

    val oceanFloor = OceanFloor(floorWidth, floorHeight)

    ventLines.forEach { oceanFloor.addVent(it) }

    return oceanFloor.getNumOverlappingPoints()

}

fun part2(input: List<String>): Int {

    return input.size
}


