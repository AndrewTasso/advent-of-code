package dev.tasso.adventofcode._2021.day11

import dev.tasso.adventofcode.Solution

class Day11 : Solution<Int> {
    override fun part1(input: List<String>): Int {

        val energyMap = input.map{ row -> row.toCharArray().map { it.digitToInt() }.toTypedArray() }.toTypedArray()
        var numFlashes = 0

        (1..100).forEach { _ ->

            val alreadyFlashed : MutableSet<Pair<Int, Int>> = mutableSetOf()

            energyMap.forEachIndexed { rowIndex, row ->
                row.forEachIndexed { colIndex, _ ->

                    increaseEnergyLevel(energyMap, rowIndex, colIndex, alreadyFlashed)

                }
            }

            energyMap.forEachIndexed { rowIndex, row ->
                row.forEachIndexed { colIndex, _ ->

                    if(energyMap[rowIndex][colIndex] > 9 ) {
                        energyMap[rowIndex][colIndex] = 0
                    }

                }
            }

            numFlashes += alreadyFlashed.size

        }

        return numFlashes

    }

    override fun part2(input: List<String>): Int {

        val energyMap = input.map{ row -> row.toCharArray().map { it.digitToInt() }.toTypedArray() }.toTypedArray()
        var firstSynchronized = 0

        for(step in 1..Int.MAX_VALUE) {

            val alreadyFlashed : MutableSet<Pair<Int, Int>> = mutableSetOf()

            energyMap.forEachIndexed { rowIndex, row ->
                row.forEachIndexed { colIndex, _ ->

                    increaseEnergyLevel(energyMap, rowIndex, colIndex, alreadyFlashed)

                }
            }

            energyMap.forEachIndexed { rowIndex, row ->
                row.forEachIndexed { colIndex, _ ->

                    if(energyMap[rowIndex][colIndex] > 9 ) {
                        energyMap[rowIndex][colIndex] = 0
                    }

                }
            }

            if (energyMap.all { row -> row.all { energy -> energy == 0 } }) {
                firstSynchronized = step
                break

            }

        }

        return firstSynchronized

    }
}

fun increaseEnergyLevel(energyMap: Array<Array<Int>>, rowIndex: Int, colIndex: Int, alreadyFlashed : MutableSet<Pair<Int, Int>> = mutableSetOf()) {

    energyMap[rowIndex][colIndex] += 1

    if(!alreadyFlashed.contains(Pair(rowIndex, colIndex))) {

        if(energyMap[rowIndex][colIndex] > 9 ) {

            alreadyFlashed.add(Pair(rowIndex, colIndex))

            val adjacentCoords = getAdjacentCoordinates(energyMap, rowIndex, colIndex)
            adjacentCoords.forEach { adjacentCoord ->
                if(!alreadyFlashed.contains(adjacentCoord)) {
                    increaseEnergyLevel(energyMap, adjacentCoord.first, adjacentCoord.second, alreadyFlashed )
                }
            }

        }


    }
}

fun getAdjacentCoordinates(heightMap : Array<Array<Int>>, rowIndex : Int, colIndex : Int): List<Pair<Int,Int>> {

    return listOfNotNull(

        //Northwest
        if(rowIndex > 0 && colIndex > 0) Pair(rowIndex - 1,colIndex - 1) else null,
        //North
        if(rowIndex > 0) Pair(rowIndex-1,colIndex) else null,
        //Northeast
        if(rowIndex > 0 && colIndex < heightMap[0].size-1 ) Pair(rowIndex - 1,colIndex + 1) else null,
        //West
        if(colIndex > 0) Pair(rowIndex,colIndex-1) else null,
        //East
        if(colIndex < heightMap[0].size-1) Pair(rowIndex, colIndex+1) else null,
        //Southwest
        if(rowIndex < heightMap.size-1 && colIndex > 0 ) Pair(rowIndex + 1,colIndex - 1) else null,
        //South
        if(rowIndex < heightMap.size-1) Pair(rowIndex + 1,colIndex) else null,
        //Southeast
        if(rowIndex < heightMap.size-1 && colIndex < heightMap[0].size-1 ) Pair(rowIndex + 1,colIndex + 1) else null

    )

}