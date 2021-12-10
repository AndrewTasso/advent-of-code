package dev.tasso.adventofcode._2021.day10

import dev.tasso.adventofcode.Solution
import java.util.*

class Day10 : Solution<Int> {
    override fun part1(input: List<String>): Int {

        val parsedInput = input.map { line -> line.toCharArray() }
        val syntaxErrorScoreMap = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)

        var totalScore = 0

        for(line in parsedInput) {

            val firstCorruptedPosition = getFirstCorruptedPosition(line)
            val score: Int = if (firstCorruptedPosition >= 0) syntaxErrorScoreMap[line[firstCorruptedPosition]]!! else 0

            totalScore += score

        }

        return totalScore

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
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