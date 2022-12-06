package dev.tasso.adventofcode._2022.day03

import dev.tasso.adventofcode.Solution

class Day03 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.map { Pair(it.toCharArray(0, it.length / 2), it.toCharArray(it.length / 2)) }
             .map { it.first.intersect(it.second.toSet())}
             .map{ it.single() }
             .sumOf { if (it.isUpperCase()) it.code - 38 else it.code - 96 }

    override fun part2(input: List<String>): Int =
        input.chunked(3)
             .map { it[0].toSet().intersect(it[1].toSet()).intersect(it[2].toSet()) }
             .map { it.single() }
             .sumOf { if (it.isUpperCase()) it.code - 38 else it.code - 96 }

}