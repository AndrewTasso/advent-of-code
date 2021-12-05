package dev.tasso.adventofcode._2021.day04

import dev.tasso.adventofcode._2021.readInput

fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
    check(part2(testInput) == 19)

    val input = readInput("Day04")
    println("Part 1: ${part1(input)}")
//    println("Part 2: ${part2(input)}")

}

fun part1(input: List<String>): Int {

    val calledNumbers = input[0].split(",")

    val cards = input.asSequence()
                     .drop(2)
                     .filterNot { it == "" }
                     .map{it.trim().split(Regex("""\s+"""))}
                     .chunked(5)
                     .map{ BingoCard(it)}
                     .toList()

    var winningCard: BingoCard? = null

    for(number in calledNumbers) {
        for(card in cards) {
            card.numberCalled(number)
            if(card.hasBingo()) {
                winningCard = card
                break
            }
        }
        if(winningCard != null) {
            break
        }
    }

    return winningCard!!.getUnmarkedNumbers().map{ it.toInt() }.sum() * winningCard.lastCalledNumber.toInt()

}

fun part2(input: List<String>): Int {

    return input.size

}


