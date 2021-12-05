package dev.tasso.adventofcode._2021.day05

import kotlin.math.abs

class DiagonalLineOceanFloor(width: Int, height: Int) {

    private val floorMap: Array<IntArray> =
        IntRange(0, width-1).map { IntRange(0, height-1).map { 0 }.toIntArray() }.toList().toTypedArray()

    fun addVent(line: Line) {

        if(line.startCoordinate.x == line.endCoordinate.x || line.startCoordinate.y == line.endCoordinate.y ) {

            val startX = Integer.min(line.startCoordinate.x, line.endCoordinate.x)
            val endX = Integer.max(line.startCoordinate.x, line.endCoordinate.x)
            val startY = Integer.min(line.startCoordinate.y, line.endCoordinate.y)
            val endY = Integer.max(line.startCoordinate.y, line.endCoordinate.y)

            for(x in startX .. endX) {
                for(y in startY .. endY) {
                    floorMap[x][y] += 1
                }
            }

        } else {

            val distance = abs(line.startCoordinate.x - line.endCoordinate.x)
            val xSign = if (line.startCoordinate.x < line.endCoordinate.x) 1 else -1
            val ySign = if (line.startCoordinate.y < line.endCoordinate.y) 1 else -1

            for(delta in 0..distance) {
                val x = line.startCoordinate.x + (delta * xSign)
                val y = line.startCoordinate.y + (delta * ySign)

                floorMap[x][y] += 1
            }

        }

    }

    fun getNumOverlappingPoints() : Int{
        return floorMap.sumOf{ row -> row.count { it >= 2 } }
    }

}