package dev.tasso.adventofcode._2021.day12

import dev.tasso.adventofcode.Solution

class Day12 : Solution<Int> {
    override fun part1(input: List<String>): Int {

        return getPaths(parseCaveGraph(input)).size

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }
}

fun parseCaveGraph(input: List<String>) : Map<String, List<String>> {

    val caveMap = mutableMapOf<String, MutableList<String>>()

    val edges = input.map { it.split("-") }

    edges.forEach { edge ->

        caveMap.getOrPut(edge.first()) { mutableListOf() }.add(edge.last())
        caveMap.getOrPut(edge.last()) { mutableListOf() }.add(edge.first())

    }

    return caveMap

}

fun getPaths(caveMap : Map<String, List<String>>, currPath : List<String> = mutableListOf(), startNode : String = "start") : List<List<String>>{

    val paths = mutableListOf<List<String>>()

    val newPath = currPath.toMutableList()
    newPath.add(startNode)

    if(startNode == "end" ) {

        paths.add(newPath)

    }
    else {

        caveMap[startNode]!!.forEach { node ->

            if (!(node.isLowerCase() && currPath.contains(node))) {

                paths.addAll(getPaths(caveMap, newPath, node))

            }
        }

    }



    return paths

}

fun String.isLowerCase() = this.all { it.isLowerCase() }