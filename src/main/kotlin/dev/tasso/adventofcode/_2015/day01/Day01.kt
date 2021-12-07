package dev.tasso.adventofcode._2015.day01

import dev.tasso.adventofcode.Solution

class Day01 : Solution<Int> {

    override fun part1(input: List<String>): Int {
        return input[0].toCharArray().fold(0){ acc, c -> if (c == '(') acc + 1 else acc - 1 }
    }

    override fun part2(input: List<String>): Int {

        var currFloor = 0
        var basementEntryIndex = -1

        val chars = input[0].toCharArray()

        for(i in chars.indices) {

            if (chars[i] == '(') currFloor += 1 else currFloor -= 1

            if (currFloor == -1) {
                basementEntryIndex = i
                break
            }
        }

        return basementEntryIndex + 1
    }

}