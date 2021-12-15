package dev.tasso.adventofcode._2021.day14

import dev.tasso.adventofcode.Solution

class Day14 : Solution<Int> {

    override fun part1(input: List<String>): Int {

        var polymerPairMap = input[0].windowed(2)
                                     .groupingBy { it }
                                     .eachCount()
                                     .toMutableMap()

        val pairInsertionMap = input.subList(2, input.size)
                                    .map { it.split(" -> ") }
                                    .associate { Pair(it[0], it[1]) }

        for(i in 1..10) {

            val tempMap = mutableMapOf<String, Int>()

            polymerPairMap.forEach { (originalPair, pairTotal) ->

                val insertPolymer = pairInsertionMap[originalPair]
                val firstNewPair = originalPair[0] + insertPolymer!!
                val secondNewPair = insertPolymer!! + originalPair[1]

                tempMap[firstNewPair] = tempMap.getOrElse(firstNewPair){0} + pairTotal
                tempMap[secondNewPair] = tempMap.getOrElse(secondNewPair){0} + pairTotal

            }

            polymerPairMap = tempMap.toMutableMap()

        }

        val polymerToCountMap =
            listOf('B', 'C', 'H', 'N')
                .associateWith { polymer -> polymerPairMap.filter { it.key.startsWith(polymer) }.map{it.value}.sum() }
                .toMutableMap()

        //After the mapping, we can't easily tell what the last character is. Since we're expanding pairs, the last
        //character of the input is the last character of our resultant String
        //be tacked onto the totals later
        polymerToCountMap[input[0].last()] = polymerToCountMap[input[0].last()]!! + 1

        return polymerToCountMap.maxOf { it.value } - polymerToCountMap.minOf { it.value }

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }

}