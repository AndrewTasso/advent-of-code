package dev.tasso.adventofcode._2021.day12

import dev.tasso.adventofcode.Solution

class Day12 : Solution<Int> {
    override fun part1(input: List<String>): Int {

        return getPathsSmallCavesOnce(parseCaveGraph(input)).size

    }

    override fun part2(input: List<String>): Int {

        return getPathsSmallCavesTwice(parseCaveGraph(input)).size

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

fun getPathsSmallCavesOnce(caveMap : Map<String, List<String>>,
                           currPath : List<String> = mutableListOf(),
                           startNode : String = "start") : List<List<String>>{

    val paths = mutableListOf<List<String>>()

    val newPath = currPath.toMutableList()
    newPath.add(startNode)

    if(startNode == "end" ) {

        paths.add(newPath)

    }
    else {

        caveMap[startNode]!!.forEach { node ->

            if (!(node.isLowerCase() && currPath.contains(node))) {

                paths.addAll(getPathsSmallCavesOnce(caveMap, newPath, node))

            }
        }

    }

    return paths

}

fun getPathsSmallCavesTwice(caveMap : Map<String, List<String>>,
                            currPath : List<String> = mutableListOf(),
                            startNode : String = "start") : List<List<String>>{

    val paths = mutableListOf<List<String>>()

    val newPath = currPath.toMutableList()
    newPath.add(startNode)

    if(startNode == "end" ) {

        paths.add(newPath)

    }
    else {

        caveMap[startNode]!!.forEach { node ->

            if(node.isUpperCase()) {
                paths.addAll(getPathsSmallCavesTwice(caveMap, newPath, node))
            }else {
                if(node != "start") {
                    if(!newPath.hasTwoSmallCaveVisits()) {
                        paths.addAll(getPathsSmallCavesTwice(caveMap, newPath, node))
                    } else if(newPath.hasTwoSmallCaveVisits() && !currPath.contains(node)) {
                        paths.addAll(getPathsSmallCavesTwice(caveMap, newPath, node))

                    }
                }
            }

        }
    }

    return paths

}

fun String.isLowerCase() = this.all { it.isLowerCase() }

fun String.isUpperCase() = !this.isLowerCase()

fun List<String>.hasTwoSmallCaveVisits() = this.filter { it.isLowerCase() }.groupingBy { it }.eachCount().filter { it.value >= 2 }.isNotEmpty()