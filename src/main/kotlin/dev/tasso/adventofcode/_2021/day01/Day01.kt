package dev.tasso.adventofcode._2021.day01

import dev.tasso.adventofcode.Solution

class Day01 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.map{ it.toInt() }
             .windowed(2)
             .count{ it[1] > it[0] }

    override fun part2(input: List<String>): Int =
        input.map{ it.toInt() }
             .windowed(3)
             .map{ it.sum() }
             .windowed(2)
             .count{ it[1] > it[0] }

}
