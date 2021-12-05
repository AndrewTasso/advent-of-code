package dev.tasso.adventofcode._2021.day05

import java.lang.Integer.min
import java.lang.Integer.max

class StraightLineOceanFloor(width: Int, height: Int) {

    private val floorMap: Array<IntArray> =
        IntRange(0, width-1).map { IntRange(0, height-1).map { 0 }.toIntArray() }.toList().toTypedArray()

    fun addVent(line: Line) {

        if(line.startCoordinate.x == line.endCoordinate.x || line.startCoordinate.y == line.endCoordinate.y ) {

            val startX = min(line.startCoordinate.x, line.endCoordinate.x)
            val endX = max(line.startCoordinate.x, line.endCoordinate.x)
            val startY = min(line.startCoordinate.y, line.endCoordinate.y)
            val endY = max(line.startCoordinate.y, line.endCoordinate.y)

            for(x in startX .. endX) {
                for(y in startY .. endY) {
                    floorMap[x][y] += 1
                }
            }

        }
    }

    fun getNumOverlappingPoints() : Int{
        return floorMap.sumOf{ row -> row.count { it >= 2 } }
    }

}