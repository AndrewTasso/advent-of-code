package dev.tasso.adventofcode._2021.day08

import dev.tasso.adventofcode.Solution

class Day08 : Solution<Int> {
    override fun part1(input: List<String>): Int {

       return input.map { entry -> entry.split("|")[1].trim().split(" ")}
            .sumOf { it.count { listOf(2,3,4,7).contains(it.length) } }

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }
}