package dev.tasso.adventofcode._2022.day04

import dev.tasso.adventofcode.Solution

class Day04 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.asSequence()
             .map{ it.split("-", ",").map { sectionNum -> sectionNum.toInt() } }
             .map{ Pair((it[0]..it[1]).toSet(), (it[2]..it[3]).toSet()) }
             .map{ it.first.containsAll(it.second) || it.second.containsAll(it.first) }
             .count { it }

    override fun part2(input: List<String>): Int =
        input.asSequence()
             .map{ it.split("-", ",").map { sectionNum -> sectionNum.toInt() } }
             .map{ Pair((it[0]..it[1]).toSet(), (it[2]..it[3]).toSet()) }
             .map{ it.first.intersect(it.second)}
             .count{ it.isNotEmpty() }

}