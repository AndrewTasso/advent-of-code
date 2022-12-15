package dev.tasso.adventofcode._2022.day10

import dev.tasso.adventofcode.Solution

class Day10 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.asSequence()
             .map { inputLine -> inputLine.split(" ") }
             .map{ splitLine ->
                 Instruction(splitLine[0], if (splitLine.size == 2) splitLine[1].toInt() else 0) }
             //Break each multi cycle instruction down to single cycle actions
             .fold(emptyList<Int>()) { perCycleIncreases, instruction ->
                 perCycleIncreases.plus( if(instruction.name == "addx") listOf(0, instruction.value) else listOf(0)) }
             .fold(listOf(1)) { perCycleValues, increase ->
                 perCycleValues.plus(perCycleValues.last() + increase) }
             .withIndex()
             .filter{ (cycleIndex, _) -> (cycleIndex + 1) % 40 == 20 }
             .sumOf { (cycleIndex, cycleValue) -> (cycleIndex + 1) * cycleValue }

    override fun part2(input: List<String>): Int {
       input.asSequence()
            .map { inputLine -> inputLine.split(" ") }
            .map{ splitLine ->
                Instruction(splitLine[0], if (splitLine.size == 2) splitLine[1].toInt() else 0) }
            //Break each multi cycle instruction down to single cycle actions
            .fold(emptyList<Int>()) { perCycleIncreases, instruction ->
                perCycleIncreases.plus( if(instruction.name == "addx") listOf(0, instruction.value) else listOf(0)) }
            .fold(listOf(1)) { perCycleValues, increase ->
                perCycleValues.plus(perCycleValues.last() + increase) }
            //We had one too many cycles defined, drop the last
            .dropLast(1)
            .withIndex()
            .map { (cycleIndex, cycleValue) ->
                if(getPixelRange(cycleValue).contains(cycleIndex % 40)) '#' else '.' }
            .chunked(40)
            .joinToString(separator = System.lineSeparator()) { it.joinToString(separator = "") }
            .let{ crtImage -> println(crtImage) }

        return 1
    }

    private data class Instruction(val name: String, val value: Int = 0)

    private fun getPixelRange(pixelPosition: Int) : ClosedRange<Int> = (pixelPosition - 1 .. pixelPosition + 1)

}
