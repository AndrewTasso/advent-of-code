package dev.tasso.adventofcode._2022.day05

import dev.tasso.adventofcode.Solution
import java.util.ArrayDeque

class Day05 : Solution<String> {

    override fun part1(input: List<String>): String {

        val stacks = buildStacks(input.subList(0, input.indexOf("")))

        val rearrangements = input.subList(input.indexOf("") + 1, input.size)
                                  .map{ it.replaceFirst("move ", "").split(" from ", " to ") }
                                  .map{ it.map{ value -> value.toInt()} }

        rearrangements.forEach {
            for(i in 1..it[0]) {
                stacks[it[2]-1].push(stacks[it[1]-1].pop())
            }
        }

        return stacks.joinToString(separator = "") { it.pop().toString()}

    }

    override fun part2(input: List<String>): String  {

        val stacks = buildStacks(input.subList(0, input.indexOf("")))

        val rearrangements = input.subList(input.indexOf("") + 1, input.size)
            .map{ it.replaceFirst("move ", "").split(" from ", " to ") }
            .map{ it.map{ value -> value.toInt()} }

        rearrangements.forEach {
            val tempStack = ArrayDeque<Char>()

            for(i in 1..it[0]) {
                tempStack.push(stacks[it[1]-1].pop())
            }
            for(i in 1..tempStack.size) {
                stacks[it[2]-1].push(tempStack.pop())
            }
        }

        return stacks.joinToString(separator = "") { it.pop().toString()}

    }

    private fun buildStacks(rawInput: List<String>): List<ArrayDeque<Char>> {

        //The last line of the raw input contains the number of stacks. Clear out white space, then parse the rightmost
        //number to determine the total number of stacks
        val numberOfStacks = rawInput.last().trim().replace("\\s+".toRegex(), ",").split(",").last().toInt()

        val stacks = rawInput.dropLast(1)// Toss the line containing the stack IDs
                             .map{ List(numberOfStacks){ index -> it[(index * 4) + 1] } } //Extract crate IDs
                             //Create stacks and populate with crate IDs
                             .fold(List(numberOfStacks){ mutableListOf<Char>() }){ acc, e ->

                                 acc.forEachIndexed{
                                         index, element -> if(e[index] != ' ') { element.add(e[index]) }
                                 }

                                 acc

                             }.map{ ArrayDeque(it) }

        return stacks
    }
}