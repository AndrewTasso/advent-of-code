package dev.tasso.adventofcode._2015.day02

import dev.tasso.adventofcode.Solution

class Day02 : Solution<Int> {

    override fun part1(input: List<String>): Int {

        val dimensions = input.map { dimension -> dimension.split("x").map { it.toInt() } }

        return dimensions.sumOf { dimension ->
            getSurfaceArea(dimension[0], dimension[1], dimension[2]) + getSlack(dimension[0], dimension[1], dimension[2])
        }

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }
}

fun getSurfaceArea(length : Int, width : Int, height : Int) =
    2 * length * width + 2 * width * height + 2 * height * length

fun getSlack(length : Int, width : Int, height : Int) =
    listOf(length * width, width * height, height * length).minOrNull()!!
