package dev.tasso.adventofcode._2021.day02

import dev.tasso.adventofcode.Solution
import kotlin.math.absoluteValue

class Day02 : Solution<Int> {

    override fun part1(input: List<String>): Int {

        // Split the input into lists of horizontal and vertical movements
        val (horizontalMovements, verticalMovements) = input.partition { it.startsWith("forward") }

        // We can only go forward, so strip the direction text, and sum all the values to get the total
        val horizontalTotal = horizontalMovements.map { it.removePrefix("forward ") }
            .sumOf { it.toInt() }
        // Up is positive, down is negative. Strip the direction text if we're going up, or replace with a negative sign.
        // Then, sum all the values to get the total
        val verticalTotal = verticalMovements.map { it.removePrefix("up ") }
            .map { it.replace("down ", "-") }
            .sumOf { it.toInt() }

        return horizontalTotal * verticalTotal.absoluteValue
    }

    override fun part2(input: List<String>): Int {

        var horizontalPosition = 0
        var verticalPosition = 0
        var aim = 0

        for(command in input) {

            if(command.startsWith("forward ")) {

                val forwardDistance = command.removePrefix("forward ").toInt()
                horizontalPosition += forwardDistance
                verticalPosition += forwardDistance * aim

            } else if (command.startsWith("up ") || command.startsWith("down ")){

                val verticalDistance = command.removePrefix("up ").replace("down ", "-").toInt()
                aim += verticalDistance

            }

        }

        return horizontalPosition * verticalPosition.absoluteValue
    }
}
