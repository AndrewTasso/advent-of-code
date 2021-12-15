package dev.tasso.adventofcode._2021.day13

import dev.tasso.adventofcode.Solution

class Day13 : Solution<Int> {
    override fun part1(input: List<String>): Int {

        val dotCoordinates = input.filter { it.contains("," )}
                                  .map{ it.split(",").map { it.toInt() }}

        val foldInstructions = input.filter { it.startsWith("fold") }
                                    .map { it.substring(11, 14) }
                                    .map { it.split("=") }
                                    .map {Pair(it[0], it[1].toInt())}

        val width = dotCoordinates.maxOf {  it[0] + 1 }
        val height = dotCoordinates.maxOf {  it[1] + 1 }

        val dotMap = (0 until width).map { (0 until height).map { 0 }.toIntArray() }.toList().toTypedArray()

        dotMap[3][0] = 1

        for(coord in dotCoordinates) {
            dotMap[coord.first()][coord.last()] = 1
        }

        val foldedMap = foldMap(dotMap, foldInstructions[0])
//        val foldedMap = foldMap(dotMap, foldInstructions[1])


//        foldedMap.forEach { it.forEach { print("$it ,") }
//            println()}

        return foldedMap.sumOf { it.sum() }

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }
}

fun foldMap(origMap: Array<IntArray>, fold: Pair<String, Int>) : Array<IntArray> {

    val origWidth = origMap.size
    val origHeight = origMap[0].size
    val foldedHeight = if(fold.first == "y") origHeight / 2 else origHeight
    val foldedWidth = if(fold.first == "x") origWidth / 2 else origWidth

    val foldedMap = (0 until foldedWidth).map {  (0 until foldedHeight).map { 0 }.toIntArray() }.toList().toTypedArray()

    for(x in 0 until foldedWidth) {
        for(y in 0 until foldedHeight) {
            val upper = origMap[x][y]
            val lower = origMap[x][origHeight - y - 1]
            val value = upper or lower
            foldedMap[x][y] = value
        }
    }

    return foldedMap
}