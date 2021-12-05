package dev.tasso.adventofcode._2021.day04

class BingoCard (numbers: List<List<String>>) {

    private val calledNumberMap = numbers.map { row -> row.associateWith { _ -> false }.toMutableMap()}

    var lastCalledNumber: String = "0"
        private set

    fun numberCalled(calledNumber : String) {

        lastCalledNumber = calledNumber

        calledNumberMap.forEach{ row ->
            if (row.containsKey(calledNumber)) {
                row[calledNumber] = true
            }
        }
    }

    fun hasBingo() : Boolean {

        //check if any of the rows have all numbers called
        val hasWinningRow = calledNumberMap.any { row -> row.all { number -> number.value } }

        var hasWinningColumn = false

        for(column in 0 until calledNumberMap[0].size) {
            if (calledNumberMap.map { it.toList()[column] }.all { it.second }) {
                hasWinningColumn = true
            }
        }

        return hasWinningRow || hasWinningColumn
    }

    fun getUnmarkedNumbers() : List<String> {

        return calledNumberMap.flatMap { row -> row.filter { number -> !number.value }.map { it.key } }

    }

}