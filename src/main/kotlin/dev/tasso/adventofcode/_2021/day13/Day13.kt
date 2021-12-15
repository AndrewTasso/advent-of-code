package dev.tasso.adventofcode._2021.day13

import dev.tasso.adventofcode.Solution

class Day13 : Solution<Int> {
    override fun part1(input: List<String>): Int {

        val dotCoordinates = input.filter { it.contains("," )}
                                  .map{ it.split(",").map { it.toInt() }}

        val foldInstructions = input.filter { it.startsWith("fold") }
                                    .map { it.substring(11, it.length) }
                                    .map { it.split("=") }
                                    .map {Pair(it[0], it[1].toInt())}

        val width = dotCoordinates.maxOf {  it[0] + 1 }
        val height = dotCoordinates.maxOf {  it[1] + 1 }

        val dotMap = (0 until width).map { (0 until height).map { 0 }.toIntArray() }.toList().toTypedArray()


        for(coord in dotCoordinates) {
            dotMap[coord.first()][coord.last()] = 1
        }

        dotMap.forEach { it.forEach { print("$it ,") }
            println()}

        println()

        val folded = if(foldInstructions[0].first == "y")
            foldUp(dotMap, foldInstructions[0].second)
        else
            foldLeft(dotMap, foldInstructions[0].second)

        folded.forEach { it.forEach { print("$it ,") }
            println()}
//
//        println()

        return folded.sumOf { it.sum() }

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }
}

fun foldUp(origMap: Array<IntArray>, mirrorPoint: Int) : Array<IntArray> {

    val origWidth = origMap.size
    val origHeight = origMap[0].size
    val foldedHeight = origHeight - mirrorPoint - 1

    val foldedMap = (0 until origWidth).map {  (0 until foldedHeight).map { 0 }.toIntArray() }.toList().toTypedArray()

    for(x in 0 until origWidth) {
        for(y in 0 until foldedHeight) {

            val upper = origMap[x][mirrorPoint - y - 1]
            val lower = origMap[x][mirrorPoint + y + 1]
            val value = upper or lower
            foldedMap[x][mirrorPoint - y - 1] = value
        }
    }

    return foldedMap
}

fun foldLeft(origMap: Array<IntArray>, mirrorPoint : Int) : Array<IntArray> {

    val origWidth = origMap.size
    val origHeight = origMap[0].size
    val foldedWidth = origWidth - mirrorPoint - 1

    val foldedMap = (0 until mirrorPoint).map {  (0 until origHeight).map { 0 }.toIntArray() }.toList().toTypedArray()
    for(x in 0 until mirrorPoint)
        for(y in 0 until origHeight)
            foldedMap[x][y] = origMap[x][y]

    for(x in 0 until foldedWidth) {
        for(y in 0 until origHeight) {
            val left = origMap[mirrorPoint - x - 1][y]
            val right = origMap[mirrorPoint + x + 1][y]
            val value = left or right
            foldedMap[mirrorPoint - x - 1][y] = value
        }
    }

    return foldedMap
}

//fun foldLeftOld(origMap: Array<IntArray>, fold: Pair<String, Int>) : Array<IntArray> {
//
//    val origWidth = origMap.size
//    val origHeight = origMap[0].size
//    val foldedHeight = if(fold.first == "y") origHeight / 2 else origHeight
//    val foldedWidth = if(fold.first == "x") origWidth / 2 else origWidth
//
//    val foldedMap = (0 until foldedWidth).map {  (0 until foldedHeight).map { 0 }.toIntArray() }.toList().toTypedArray()
//
//    for(x in 0 until foldedWidth) {
//        for(y in 0 until foldedHeight) {
//            val left = origMap[x][y]
//            val right = origMap[origWidth - x - 1][y]
//            val value = left or right
//            foldedMap[x][y] = value
//        }
//    }
//
//    return foldedMap
//}
