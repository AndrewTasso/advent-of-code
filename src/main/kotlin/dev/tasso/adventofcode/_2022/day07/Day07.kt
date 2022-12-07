package dev.tasso.adventofcode._2022.day07

import dev.tasso.adventofcode.Solution

class Day07 : Solution<Int> {

    override fun part1(input: List<String>): Int =
        input.asSequence()
             .chunkedByCommand()
             .drop(1)
             .fold(FileSystemNode("/", "dir")) { currNode , command ->
                 if(command.first().startsWith("$ cd", 0)) {

                     val dirName = command.first().replaceFirst("$ cd ", "")

                     if(dirName == "..") {
                         currNode.parent!!
                     } else {
                         currNode.children.first { it.name == dirName }
                     }

                 } else {

                     command.drop(1).forEach {

                         val fileInfo = it.split(" ")

                         if(!fileInfo[0].startsWith("dir", 0)) {
                             val newNode = FileSystemNode(fileInfo[1], "file", fileInfo[0].toInt())
                             currNode.addChild(newNode)
                         } else {
                             val newNode = FileSystemNode(fileInfo[1], "dir")
                             currNode.addChild(newNode)
                         }
                     }

                     currNode
                 }
             }.getRootNode()
             .getSmallDirsSize()


    override fun part2(input: List<String>): Int =
        input.asSequence()
             .chunkedByCommand()
             .drop(1)
             .fold(FileSystemNode("/", "dir")) { currNode , command ->
                 if(command.first().startsWith("$ cd", 0)) {

                     val dirName = command.first().replaceFirst("$ cd ", "")

                     if(dirName == "..") {
                         currNode.parent!!
                     } else {
                         currNode.children.first { it.name == dirName }
                     }

                 } else {

                     command.drop(1).forEach {

                         val fileInfo = it.split(" ")

                         if(!fileInfo[0].startsWith("dir", 0)) {
                             val newNode = FileSystemNode(fileInfo[1], "file", fileInfo[0].toInt())
                             currNode.addChild(newNode)
                         } else {
                             val newNode = FileSystemNode(fileInfo[1], "dir")
                             currNode.addChild(newNode)
                         }
                     }

                     currNode
                 }
             }.getRootNode()
             .getDirSizes()
             .filter { it > 358913 }
             .min()

    private fun Sequence<String>.chunkedByCommand(): Sequence<List<String>> = sequence {

        val subList = mutableListOf(this@chunkedByCommand.first())

        for (element in this@chunkedByCommand.drop(1)) {

            if (element.startsWith("$")) {
                yield(subList)
                subList.clear()
            }

            subList += element
        }

        if (subList.isNotEmpty()) yield(subList)
    }

    private class FileSystemNode(val name: String, val type: String, var size: Int = 0){

        var parent:FileSystemNode? = null
        val children:MutableList<FileSystemNode> = mutableListOf()

        fun addChild(newNode:FileSystemNode){

            newNode.parent = this
            children.add(newNode)

            var currNode = newNode
            while(currNode.parent != null) {
                currNode = currNode.parent!!
                currNode.size += newNode.size
            }
        }

        fun getRootNode() : FileSystemNode {

            var currNode = this

            while(currNode.parent != null) {
                currNode = currNode.parent!!
            }

            return currNode
        }

        fun getSmallDirsSize(): Int {

            val currSize = if(this.type == "dir" && this.size <= 100000) this.size else 0

            return currSize + this.children.sumOf { it.getSmallDirsSize() }
        }

        fun getDirSizes(): Set<Int> {

            return (if(this.type == "dir") setOf(this.size) else emptySet()) + this.children.flatMap { it.getDirSizes() }.toSet()

        }
    }
}