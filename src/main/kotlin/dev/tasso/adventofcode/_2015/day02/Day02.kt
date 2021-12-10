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

        val dimensions = input.map { dimension -> dimension.split("x").map { it.toInt() } }

        return dimensions.sumOf{ dimension ->

            getWrapLength(dimension[0], dimension[1], dimension[2]) + getVolume(dimension[0], dimension[1], dimension[2])

        }

    }
}

fun getSurfaceArea(length : Int, width : Int, height : Int) =
    2 * length * width + 2 * width * height + 2 * height * length

fun getSlack(length : Int, width : Int, height : Int) =
    listOf(length * width, width * height, height * length).minOrNull()!!

fun getWrapLength(length : Int, width : Int, height : Int) =
    listOf(length, width, height).sorted().take(2).sumOf { shortSide -> shortSide * 2 }

fun getVolume(length : Int, width : Int, height : Int) = length * width * height

