package dev.tasso.adventofcode._2021.day05

import dev.tasso.adventofcode.Solution
import java.lang.Integer.max

class Day05 : Solution<Int> {

    override fun part1(input: List<String>): Int {

        val ventLines = input.map { it.split(" -> ").map{it.split(",").map { it.toInt() }}}
            .map { Line(Coordinate(it.first().first(), it.first().last()), Coordinate(it.last().first(), it.last().last())) }

        val floorWidth = ventLines.maxOf { max(it.startCoordinate.x, it.endCoordinate.x) + 1  }
        val floorHeight = ventLines.maxOf { max(it.startCoordinate.y, it.endCoordinate.y) + 1  }

        val oceanFloor = StraightLineOceanFloor(floorWidth, floorHeight)

        ventLines.forEach { oceanFloor.addVent(it) }

        return oceanFloor.getNumOverlappingPoints()

    }

    override fun part2(input: List<String>): Int {

        val ventLines = input.map { it.split(" -> ").map{it.split(",").map { it.toInt() }}}
            .map { Line(Coordinate(it.first().first(), it.first().last()), Coordinate(it.last().first(), it.last().last())) }

        val floorWidth = ventLines.maxOf { max(it.startCoordinate.x, it.endCoordinate.x) + 1  }
        val floorHeight = ventLines.maxOf { max(it.startCoordinate.y, it.endCoordinate.y) + 1  }

        val oceanFloor = DiagonalLineOceanFloor(floorWidth, floorHeight)

        ventLines.forEach { oceanFloor.addVent(it) }

        return oceanFloor.getNumOverlappingPoints()
    }

}
