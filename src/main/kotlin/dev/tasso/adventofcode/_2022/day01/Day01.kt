package dev.tasso.adventofcode._2022.day01

import dev.tasso.adventofcode.Solution

class Day01 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.asSequence()
             .chunkedOnEmpty()
             .map{ subList -> subList.sumOf { it.toInt() } }
             .max()

    override fun part2(input: List<String>): Int =
        input.asSequence()
             .chunkedOnEmpty()
             .map{ subList -> subList.sumOf { it.toInt() } }
             .sortedDescending()
             .take(3)
             .sum()

    /**
     * Splits a sequence of values which are delineated by an empty string, into subsequences (discarding empty strings)
     */
    private fun Sequence<String>.chunkedOnEmpty(): Sequence<List<String>> = sequence {

        val subList = mutableListOf<String>()

        for (element in this@chunkedOnEmpty) {
            if (element.isNotEmpty()) {
                subList += element
            }else {
                yield(subList)
                subList.clear()
            }
        }

        if (subList.isNotEmpty()) yield(subList)
    }

}