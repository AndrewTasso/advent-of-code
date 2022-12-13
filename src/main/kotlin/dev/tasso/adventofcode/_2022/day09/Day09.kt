package dev.tasso.adventofcode._2022.day09

import dev.tasso.adventofcode.Solution
import kotlin.math.abs

class Day09 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.map { inputLine -> inputLine.split(" ") }
             //Break each larger step of multiple moves in a specific direction into moves of only a single space each
             .flatMap { splitLine -> List(splitLine[1].toInt()) { splitLine[0].first() }}
             // Provide a list to hold the positions the rope will travel, starting with both the head and tail at 0,0
             .fold( listOf(Rope()) ) { positions : List<Rope>, moveDirection : Char ->
                 positions.plus(positions.last().movedTo(moveDirection))
             }.distinctBy { position -> position.tailCoords }
            .count()

    override fun part2(input: List<String>): Int {

        return 0
    }

    private data class Coords(val x: Int = 0, val y: Int = 0)

    private data class Rope(val headCoords: Coords = Coords(0,0), val tailCoords: Coords = Coords(0,0))

    private fun Rope.movedTo(direction : Char) : Rope {

        fun getNewHeadCoords(moveDirection: Char) : Coords =
            when(moveDirection) {
                'U' -> Coords(this.headCoords.x, this.headCoords.y + 1)
                'D' -> Coords(this.headCoords.x, this.headCoords.y - 1)
                'R' -> Coords(this.headCoords.x + 1, this.headCoords.y)
                'L' -> Coords(this.headCoords.x - 1, this.headCoords.y)
                else -> throw IllegalArgumentException("Unexpected direction encountered ($moveDirection)")
            }

        fun getNewTailCoords(newHeadCoords : Coords) : Coords =
            if(abs(this.tailCoords.x - newHeadCoords.x) >= 2) {
                if(this.tailCoords.y == newHeadCoords.y) {
                    Coords((newHeadCoords.x + this.tailCoords.x) / 2, this.tailCoords.y)
                } else { //if diagonal, bring the tail in line with the new position of the head
                    Coords((newHeadCoords.x + this.tailCoords.x) / 2, newHeadCoords.y)
                }
            } else if(abs(this.tailCoords.y - newHeadCoords.y) >= 2) {
                if(this.tailCoords.y == newHeadCoords.y) {
                    Coords(this.tailCoords.x, (newHeadCoords.y + this.tailCoords.y) / 2)
                } else { //if diagonal, bring the tail in line with the new position of the head
                    Coords(newHeadCoords.x, (newHeadCoords.y + this.tailCoords.y) / 2)
                }
            } else {
                this.tailCoords
            }

        return getNewHeadCoords(direction).let { newHeadCoords ->
            Rope(newHeadCoords , getNewTailCoords(newHeadCoords))
        }

    }
}