package dev.tasso.adventofcode._2015.day03

import dev.tasso.adventofcode.Solution

class Day02 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.first()
             .fold(listOf(Pair(0,0))) { visitedHouses, direction ->
                 visitedHouses.plus(
                     when(direction) {
                         '^' -> Pair(visitedHouses.last().first, visitedHouses.last().second + 1)
                         'v' -> Pair(visitedHouses.last().first, visitedHouses.last().second - 1)
                         '>' -> Pair(visitedHouses.last().first + 1, visitedHouses.last().second)
                         '<' -> Pair(visitedHouses.last().first - 1, visitedHouses.last().second)
                         else -> throw IllegalArgumentException("Unexpected move encountered ($direction)")
                     }
                 )
             }
            .toSet()
            .count()

    override fun part2(input: List<String>): Int =
        input.first()
             .withIndex()
             .partition { it.index % 2 == 0 }
             .toList()
             .asSequence()
             .map { it.map{ indexed ->  indexed.value} }
             .map{
                 it.fold(listOf(Pair(0,0))) { visitedHouses, direction ->
                     visitedHouses.plus(
                         when(direction) {
                             '^' -> Pair(visitedHouses.last().first, visitedHouses.last().second + 1)
                             'v' -> Pair(visitedHouses.last().first, visitedHouses.last().second - 1)
                             '>' -> Pair(visitedHouses.last().first + 1, visitedHouses.last().second)
                             '<' -> Pair(visitedHouses.last().first - 1, visitedHouses.last().second)
                             else -> throw IllegalArgumentException("Unexpected move encountered ($direction)")
                         }
                     )
                }
             }
             .flatten()
             .toSet()
             .count()

}
