package dev.tasso.adventofcode._2022.day08

import dev.tasso.adventofcode.Solution

class Day08 : Solution<Int> {

    override fun part1(input: List<String>): Int =

        input.mapIndexed { yCoord, currRow ->

            currRow.mapIndexed{ xCoord, currHeight ->

                val coords = Pair(yCoord, xCoord)

                listOf(
                    (input northOf coords).all { it < currHeight },
                    (input eastOf coords).all { it < currHeight },
                    (input southOf coords).all { it < currHeight },
                    (input westOf coords).all { it < currHeight },
                ).any{ it }

            }.count { it }

        }.sum()


    override fun part2(input: List<String>): Int =

        input.mapIndexed { yCoord, currRow ->

            currRow.mapIndexed{ xCoord, currHeight ->

                val coords = Pair(yCoord, xCoord)

                listOf(
                    (input northOf coords).run{ this.indexOfFirst { it >= currHeight }.takeIf{ it > -1 }?.let { it + 1 } ?: this.length},
                    (input eastOf coords).run{ this.indexOfFirst { it >= currHeight }.takeIf{ it > -1 }?.let { it + 1 } ?: this.length},
                    (input southOf coords).run{ this.indexOfFirst { it >= currHeight }.takeIf{ it > -1 }?.let { it + 1 } ?: this.length},
                    (input westOf coords).run{ this.indexOfFirst { it >= currHeight }.takeIf{ it > -1 }?.let { it + 1 } ?: this.length}
                ).reduce(Int::times)

            }.max()

        }.max()

    /**
     * Gets the heights of all trees in a straight line North of the provided coordinates
     */
    private infix fun List<String>.northOf(coords: Pair<Int,Int>) : String =
        String(CharArray(coords.first){ this[coords.first - it - 1][coords.second] })

    /**
     * Gets the heights of all trees in a straight line East of the provided coordinates
     */
    private infix fun List<String>.eastOf(coords: Pair<Int,Int>) : String =
        this[coords.first].substring((coords.second + 1) until this.first().length)

    /**
     * Gets the heights of all trees in a straight line South of the provided coordinates
     */
    private infix fun List<String>.southOf(coords: Pair<Int,Int>) : String =
        String(CharArray(this.size - coords.first - 1){ this[it + coords.first + 1][coords.second] })

    /**
     * Gets the heights of all trees in a straight line West of the provided coordinates
     */
    private infix fun List<String>.westOf(coords: Pair<Int,Int>) : String =
        this[coords.first].substring(0 until coords.second).reversed()
}