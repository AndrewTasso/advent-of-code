package dev.tasso.adventofcode._2022.day11

import dev.tasso.adventofcode.Solution
import java.lang.IllegalArgumentException
import kotlin.math.floor

class Day11 : Solution<Int> {

    override fun part1(input: List<String>): Int {

        return input.asMonkeys()
                    .let {monkeys ->
                        (0..19).forEach { _ ->
                            monkeys.forEach { monkey ->
                                monkey.inspectAndTest().forEach {
                                        (monkeyNum, item) -> monkeys[monkeyNum].items.add(item)
                                }
                            }
                        }

                        monkeys.map { it.numInspected }
                               .sortedDescending()
                               .take(2)
                               .reduce(Int::times)
                    }



    }

    override fun part2(input: List<String>): Int {

        return 0

    }

    /**
     * Splits a sequence of values which are delineated by an empty string, into subsequences (discarding empty strings)
     */
    private fun Sequence<String>.chunkedOnEmpty(): Sequence<List<String>> = sequence {

        val subList = mutableListOf<String>()

        for (element in this@chunkedOnEmpty) {
            if (element.isNotEmpty()) {
                subList += element
            }else {
                yield(subList)
                subList.clear()
            }
        }

        if (subList.isNotEmpty()) yield(subList)
    }

    private data class Monkey(val items : MutableList<Int>,
                              val operation : Operation,
                              val testModulo : Int,
                              val trueMonkey : Int,
                              val falseMonkey : Int,
                              var numInspected: Int = 0) {

        fun inspectAndTest() : List<Pair<Int, Int>> {

            numInspected += items.size

            val inspectedItems =  items.map { item -> operation.invoke(item) }
                                       .map { inspectedItem -> floor(inspectedItem / 3.0).toInt() }
                                       .map { inspectedItem -> (if (inspectedItem % testModulo == 0) trueMonkey else falseMonkey) to inspectedItem }

            items.clear()

            return inspectedItems
        }
    }

    private class Operation(val leftOperand : (Int) -> Int,
                            val operator: (Int, Int) -> Int,
                            val rightOperand : (Int) -> Int) {

        fun invoke(oldValue : Int) : Int =
            operator.invoke(leftOperand.invoke(oldValue), rightOperand.invoke(oldValue))

    }

    private fun String.toOperation() : Operation {

        fun getOperandFunc(operand: String) : (Int) -> Int =
            if(operand == "old") { value: Int -> value } else { _: Int -> operand.toInt() }

        fun getOperatorFunc(operator: String): (Int, Int) -> Int =
            when (operator) {
                "+" -> { left: Int, right: Int -> left + right }
                "*" -> { left: Int, right: Int -> left * right }
                else -> {
                    throw IllegalArgumentException("Unexpected operator encountered!: $operator")
                }
            }

        return this.split(" ")
                   .let { (leftOperand, operator, rightOperand) ->
                       Operation(getOperandFunc(leftOperand), getOperatorFunc(operator), getOperandFunc(rightOperand))
                   }

    }

    private fun List<String>.asMonkeys() : List<Monkey> =
        this.asSequence()
            .chunkedOnEmpty()
            .map { it.asMonkey() }
            .toList()

    private fun List<String>.asMonkey() : Monkey {

        fun String.parseItems() : MutableList<Int> =
            this.split("Starting items: ")
                .last()
                .split(", ")
                .map{ it.toInt() }
                .toMutableList()

        fun String.parseOperation() : Operation =
            this.split(" new = ")
                 .last()
                 .toOperation()

        fun String.parseTestModulo() : Int =
            this.split(" divisible by ")
                .last()
                .toInt()

        fun String.parseThrownMonkey(): Int =
            this.split(" throw to monkey ")
                .last()
                .toInt()

        return Monkey(items = this[1].parseItems(),
                      operation = this[2].parseOperation(),
                      testModulo = this[3].parseTestModulo(),
                      trueMonkey = this[4].parseThrownMonkey(),
                      falseMonkey = this[5].parseThrownMonkey())

    }

}

