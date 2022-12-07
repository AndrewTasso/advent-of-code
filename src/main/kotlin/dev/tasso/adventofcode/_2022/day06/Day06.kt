package dev.tasso.adventofcode._2022.day06

import dev.tasso.adventofcode.Solution

class Day06 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.first()
             .windowed(4)
             .withIndex()
             .first { it.value.all(hashSetOf<Char>()::add) }
             .index + 4

    override fun part2(input: List<String>): Int  =
        input.first()
            .windowed(14)
            .withIndex()
            .first { it.value.all(hashSetOf<Char>()::add) }
            .index + 14

}