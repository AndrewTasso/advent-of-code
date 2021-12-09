package dev.tasso.adventofcode._2021.day09

import dev.tasso.adventofcode.Solution

class Day09 : Solution<Int> {
    override fun part1(input: List<String>): Int {

        val heightMap = input.map{ row -> row.toCharArray().map { it.digitToInt() }.toTypedArray()}.toTypedArray()

        return determineLowPointCoordinates(heightMap).sumOf {
                (rowIndex, colIndex) -> heightMap[rowIndex][colIndex] + 1
        }

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }
}

fun determineLowPointCoordinates(heightMap : Array<Array<Int>>): MutableList<Pair<Int, Int>> {

    val lowPointCoordinates = mutableListOf<Pair<Int,Int>>()

    heightMap.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, height ->

            val adjacentCoordinate = getAdjacentCoordinates(heightMap, rowIndex, colIndex)

            if(adjacentCoordinate.all{ (col,row) -> heightMap[col][row] > height}) {
                lowPointCoordinates.add(Pair(rowIndex,colIndex))
            }

        }
    }

    return lowPointCoordinates

}

fun getAdjacentCoordinates(heightMap : Array<Array<Int>>, rowIndex : Int, colIndex : Int): List<Pair<Int,Int>> {

    return listOfNotNull(
        //North
        if(rowIndex > 0) Pair(rowIndex-1,colIndex) else null,
        //South
        if(rowIndex < heightMap.size-1) Pair(rowIndex+1,colIndex) else null,
        //West
        if(colIndex > 0) Pair(rowIndex,colIndex-1) else null,
        //East
        if(colIndex < heightMap[0].size-1) Pair(rowIndex, colIndex+1) else null
    )

}