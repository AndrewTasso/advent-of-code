package dev.tasso.adventofcode._2022.day02

import dev.tasso.adventofcode.Solution

class Day02 : Solution<Int> {

    private val outcomeValueMap = mapOf("loss" to 0, "draw" to 3, "win" to 6)
    private val shapeValueMap = mapOf("rock" to 1, "paper" to 2, "scissors" to 3)

    override fun part1(input: List<String>): Int {

        return input.sumOf {

            val opponentMove = decodeMove(it[0])
            val yourMove = decodeMove(it[2])

            val outcome = getOutcome(opponentMove, yourMove)

            val outcomeValue = outcomeValueMap[outcome]!!
            val shapeValue = shapeValueMap[yourMove]!!

            shapeValue + outcomeValue

        }

    }

    override fun part2(input: List<String>): Int {

        return input.sumOf {

            val opponentMove = decodeMove(it[0])
            val expectedOutcome = decodeOutcome(it[2])
            val yourMove = getExpectedMove(opponentMove, expectedOutcome)

            val outcomeValue = outcomeValueMap[expectedOutcome]!!
            val shapeValue = shapeValueMap[yourMove]!!

            shapeValue + outcomeValue

        }

    }

    private fun decodeMove(input: Char): String {

        return when (input) {
            'A', 'X' -> "rock"
            'B', 'Y' -> "paper"
            'C', 'Z' -> "scissors"
            else -> throw IllegalArgumentException("Unexpected move encoding ($input)")
        }
    }

    private fun decodeOutcome(input: Char): String {

        return when (input) {
            'X' -> "loss"
            'Y' -> "draw"
            'Z' -> "win"
            else -> throw IllegalArgumentException("Unexpected outcome encoding ($input)")
        }
    }

    private fun getOutcome(opponentMove: String, yourMove: String) : String {

        return when (opponentMove to yourMove) {
            "rock" to "paper",    "paper" to "scissors", "scissors" to "rock"     -> "win"
            "rock" to "rock",     "paper" to "paper",    "scissors" to "scissors" -> "draw"
            "rock" to "scissors", "paper" to "rock",     "scissors" to "paper"    -> "loss"
            else -> throw IllegalArgumentException("Unexpected input ($opponentMove, $yourMove)")
        }
    }

    private fun getExpectedMove(opponentMove: String, expectedOutcome: String) : String {

        return when (opponentMove to expectedOutcome) {
            "rock" to "loss", "paper" to "win",  "scissors" to "draw" -> "scissors"
            "rock" to "draw", "paper" to "loss", "scissors" to "win"  -> "rock"
            "rock" to "win",  "paper" to "draw", "scissors" to "loss" -> "paper"
            else -> throw IllegalArgumentException("Unexpected input ($opponentMove, $expectedOutcome)")
        }
    }

}