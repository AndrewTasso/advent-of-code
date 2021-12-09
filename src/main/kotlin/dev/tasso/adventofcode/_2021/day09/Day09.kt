package dev.tasso.adventofcode._2021.day09

import dev.tasso.adventofcode.Solution

class Day09 : Solution<Int> {
    override fun part1(input: List<String>): Int {

        val heightMap = input.map{ row -> row.toCharArray().map { it.digitToInt() }.toTypedArray()}.toTypedArray()

        var riskLevel = 0

        heightMap.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, height ->
                val adjacentHeights = setOfNotNull(
                    //North
                    if(rowIndex > 0) heightMap[rowIndex-1][colIndex] else null,
                    //South
                    if(rowIndex < heightMap.size-1) heightMap[rowIndex+1][colIndex] else null,
                    //West
                    if(colIndex > 0) heightMap[rowIndex][colIndex-1] else null,
                    //East
                    if(colIndex < heightMap[0].size-1) heightMap[rowIndex][colIndex+1] else null
                )

                if(adjacentHeights.all{ adjacentHeight -> adjacentHeight > height}) {
                    riskLevel += height + 1
                }
            }
        }

        return riskLevel
    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }
}