package dev.tasso.adventofcode._2022.day09

import dev.tasso.adventofcode.Solution
import kotlin.math.abs

class Day09 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.map { inputLine -> inputLine.split(" ") }
             //Break each larger step of multiple moves in a specific direction into moves of only a single space each
             .flatMap { splitLine -> List(splitLine[1].toInt()) { splitLine[0].first() }}
             // Provide a list to hold the positions the rope will travel, starting with both the head and tail at 0,0
             .fold( listOf(Rope(List(2){ Coords() })) ) { positions : List<Rope>, moveDirection : Char ->
                 positions.plus(positions.last().movedTo(moveDirection))
             }.distinctBy { position -> position.knotCoords.last()}
            .count()
    override fun part2(input: List<String>): Int =
        input.map { inputLine -> inputLine.split(" ") }
             //Break each larger step of multiple moves in a specific direction into moves of only a single space each
             .flatMap { splitLine -> List(splitLine[1].toInt()) { splitLine[0].first() }}
             // Provide a list to hold the positions the rope will travel, starting with both the head and tail at 0,0
             .fold( listOf(Rope(List(10){ Coords() })) ) { positions : List<Rope>, moveDirection : Char ->
                 positions.plus(positions.last().movedTo(moveDirection))
             }.distinctBy { position -> position.knotCoords.last()}
             .count()

    private data class Coords(val x: Int = 0, val y: Int = 0)

    private data class Rope(val knotCoords: List<Coords>)

    private fun Rope.movedTo(direction : Char) : Rope {

        val headCoords = this.knotCoords.first()

        fun getNewHeadCoords(moveDirection: Char) : Coords =
            when(moveDirection) {
                'U' -> Coords(headCoords.x, headCoords.y + 1)
                'D' -> Coords(headCoords.x, headCoords.y - 1)
                'R' -> Coords(headCoords.x + 1, headCoords.y)
                'L' -> Coords(headCoords.x - 1, headCoords.y)
                else -> throw IllegalArgumentException("Unexpected direction encountered ($moveDirection)")
            }

        fun getNewKnotCoords(nextKnotCoords : Coords, prevKnotCoords : Coords) : Coords =
            if(abs(prevKnotCoords.x - nextKnotCoords.x) >= 2 && abs(prevKnotCoords.y - nextKnotCoords.y) >= 2) {
                Coords((nextKnotCoords.x + prevKnotCoords.x) / 2, (nextKnotCoords.y + prevKnotCoords.y) / 2)
            } else if(abs(prevKnotCoords.x - nextKnotCoords.x) >= 2) {
                if(prevKnotCoords.y == nextKnotCoords.y) {
                    Coords((nextKnotCoords.x + prevKnotCoords.x) / 2, prevKnotCoords.y)
                } else { //if diagonal, bring the tail in line with the new position of the head
                    Coords((nextKnotCoords.x + prevKnotCoords.x) / 2, nextKnotCoords.y)
                }
            } else if(abs(prevKnotCoords.y - nextKnotCoords.y) >= 2) {
                if(prevKnotCoords.y == nextKnotCoords.y) {
                    Coords(prevKnotCoords.x, (nextKnotCoords.y + prevKnotCoords.y) / 2)
                } else { //if diagonal, bring the tail in line with the new position of the head
                    Coords(nextKnotCoords.x, (nextKnotCoords.y + prevKnotCoords.y) / 2)
                }
            } else {
                prevKnotCoords
            }

        return this.knotCoords.drop(1) //Drop old head knot since the new list starts with the new head knot
                              //Start the new rope with the new head coords and drag the remaining knots along for the ride
                              .fold(listOf(getNewHeadCoords(direction))) { newKnotCoords, currOldKnotCoord ->
                                  newKnotCoords.plus(getNewKnotCoords(newKnotCoords.last(), currOldKnotCoord))
                              }.let { Rope(it) }

    }
}
