package dev.tasso.adventofcode._2021.day14

import dev.tasso.adventofcode.Solution
import java.math.BigInteger

class Day14 : Solution<BigInteger> {

    override fun part1(input: List<String>): BigInteger {

        return runPolymerization(input, 10)

    }

    override fun part2(input: List<String>): BigInteger {

        return runPolymerization(input, 40)

    }


}

fun runPolymerization(input: List<String>, numIterations: Int) : BigInteger {

    var polymerPairMap = input[0].windowed(2)
                                 .groupingBy { it }
                                 .eachCount()
                                 .map{Pair(it.key, it.value.toBigInteger())}
                                 .toMap()
                                 .toMutableMap()

    val pairInsertionMap = input.subList(2, input.size)
                                .map { it.split(" -> ") }
                                .associate { Pair(it[0], it[1]) }

    for(i in 1..numIterations) {

        val tempMap = mutableMapOf<String, BigInteger>()

        polymerPairMap.forEach { (originalPair, pairTotal) ->

            val insertPolymer = pairInsertionMap[originalPair]
            val firstNewPair = originalPair[0] + insertPolymer!!
            val secondNewPair = insertPolymer + originalPair[1]

            tempMap[firstNewPair] = tempMap.getOrElse(firstNewPair){BigInteger.valueOf(0)} + pairTotal
            tempMap[secondNewPair] = tempMap.getOrElse(secondNewPair){BigInteger.valueOf(0)} + pairTotal

        }

        polymerPairMap = tempMap.toMutableMap()

    }

    val polymerToCountMap =  pairInsertionMap.map { it.value }
            .associateWith { polymer -> polymerPairMap.filter { it.key.startsWith(polymer) }.map{it.value}.sum() }
            .toMutableMap()

    //After the mapping, we can't easily tell what the last character is. Since we're expanding pairs, the last
    //character of the input is the last character of our resultant String
    //be tacked onto the totals later
    polymerToCountMap[input[0].last().toString()] =
        polymerToCountMap[input[0].last().toString()]!! + BigInteger.valueOf(1)

    return polymerToCountMap.maxOf { it.value } - polymerToCountMap.minOf { it.value }

}

fun Iterable<BigInteger>.sum(): BigInteger {
    var sum: BigInteger = BigInteger.ZERO
    for (element in this) {
        sum += element
    }
    return sum
}