package dev.tasso.adventofcode._2021.day04

import dev.tasso.adventofcode.Solution

class Day04 : Solution<Int> {

    override fun part1(input: List<String>): Int {

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

    override fun part2(input: List<String>): Int {

        val calledNumbers = input[0].split(",")

        val cards = input.asSequence()
            .drop(2)
            .filterNot { it == "" }
            .map{it.trim().split(Regex("""\s+"""))}
            .chunked(5)
            .map{ BingoCard(it)}
            .toList()

        var lastWinningCard: BingoCard? = null

        for(number in calledNumbers) {
            cards.filter { !it.hasBingo() }.forEach { it.numberCalled(number) }

            val nonWinningCards = cards.filter { !it.hasBingo() }

            if(nonWinningCards.size == 1) {
                lastWinningCard = nonWinningCards[0]
            }
            if(nonWinningCards.isEmpty()) {
                break
            }
        }

        return lastWinningCard!!.getUnmarkedNumbers().map{ it.toInt() }.sum() * lastWinningCard.lastCalledNumber.toInt()

    }

}
