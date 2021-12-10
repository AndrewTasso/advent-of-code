package dev.tasso.adventofcode._2021.day10

import dev.tasso.adventofcode.Solution
import java.math.BigInteger
import java.util.*

class Day10 : Solution<BigInteger> {
    override fun part1(input: List<String>): BigInteger {

        val parsedInput = input.map { line -> line.toCharArray() }
        val syntaxErrorScoreMap = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)

        var totalScore = 0

        for(line in parsedInput) {

            val firstCorruptedPosition = getFirstCorruptedPosition(line)
            val score: Int = if (firstCorruptedPosition >= 0) syntaxErrorScoreMap[line[firstCorruptedPosition]]!! else 0

            totalScore += score

        }

        return BigInteger.valueOf(totalScore.toLong())

    }

    override fun part2(input: List<String>): BigInteger {

        val incompleteLines =
            input.map { line -> line.toCharArray() }.filter {line -> getFirstCorruptedPosition(line) == -1  }
        val syntaxErrorScoreMap : Map<Char, Long> = mapOf(')' to 1, ']' to 2, '}' to 3, '>' to 4)

        val scores = incompleteLines.map {
            getCompletingCharacters(it).fold(BigInteger.valueOf(0)) { acc, c ->
                acc * BigInteger.valueOf(5) + BigInteger.valueOf(syntaxErrorScoreMap[c]!!)
            }

        }.sorted()

        return scores[scores.size / 2]

    }
}

fun getFirstCorruptedPosition(line : CharArray): Int {

    val closingCharMap = mapOf(')' to '(', ']' to '[', '}' to '{', '>' to '<')
    val stack = Stack<Char>()
    var firstInvalid = -1

    line.forEachIndexed{ i, character ->

        if (setOf('(', '[', '{', '<').contains(character))
            stack.push(character)
        else {
            if (closingCharMap.keys.contains(character)) {
                if(stack.peek() == closingCharMap[character])
                    stack.pop()
                else if (firstInvalid < 0 )
                    firstInvalid = i

            }
        }

    }

    return firstInvalid

}

fun getCompletingCharacters(line : CharArray) : List<Char> {

    val openingToClosingCharMap = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')

    val stack = Stack<Char>()

    line.forEach{ character ->

        //Assume that the lines are not malformed and will always be balanced up until the missing characters
        if (setOf('(', '[', '{', '<').contains(character))
            stack.push(character)
        else {
            stack.pop()
        }

    }

    return stack.reversed().map { openingToClosingCharMap[it]!! }

}
