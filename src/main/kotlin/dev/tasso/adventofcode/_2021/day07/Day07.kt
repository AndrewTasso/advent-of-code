package dev.tasso.adventofcode._2021.day07

import dev.tasso.adventofcode.Solution
import kotlin.math.abs

class Day07 : Solution<Int> {

    override fun part1(input: List<String>): Int {

        val positions = input[0].split(",").map { it.toInt() }
        val lowestPosition = positions.minOrNull()!!
        val highestPosition = positions.maxOrNull()!!

        return (lowestPosition..highestPosition).minOf { currPosition -> positions.sumOf { abs(currPosition - it) } }

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }

}