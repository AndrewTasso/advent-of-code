package dev.tasso.adventofcode._2021.day07

import dev.tasso.adventofcode.Solution
import kotlin.math.abs

class Day07 : Solution<Int> {

    override fun part1(input: List<String>): Int {

        val positions = input[0].split(",").map { it.toInt() }

        return (positions.minOrNull()!!..positions.maxOrNull()!!).minOf {
            currPosition -> positions.sumOf { abs(currPosition - it) }
        }

    }

    override fun part2(input: List<String>): Int {

        val positions = input[0].split(",").map{ it.toInt() }

        return (positions.minOrNull()!!..positions.maxOrNull()!!).toList().map{ currPosition ->
            positions.map{ (1..abs(currPosition - it)).fold(0){ acc, i -> acc + i}}.sum()
        }.minOrNull()!!

    }

}