package dev.tasso.adventofcode._2021.day12

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class Day12Test : BehaviorSpec({

    include(solutionTest(Day12()::part1, 10, "2021/Day12_test_01.txt"))
    include(solutionTest(Day12()::part1, 19, "2021/Day12_test_02.txt"))
    include(solutionTest(Day12()::part1, 226, "2021/Day12_test_03.txt"))
    include(solutionTest(Day12()::part2, 36, "2021/Day12_test_01.txt"))
    include(solutionTest(Day12()::part2, 103, "2021/Day12_test_02.txt"))
    include(solutionTest(Day12()::part2, 3509, "2021/Day12_test_03.txt"))

    Given("a path with two small cave visits") {
        val path = listOf("start", "a", "B", "c", "a")
        When("checking if two small caves have been visited") {
            Then("return true") {
                path.hasTwoSmallCaveVisits() shouldBe true
            }

        }
    }

    Given("a path with only single small cave visits") {
        val path = listOf("start", "a", "B", "c", "d")
        When("checking if two small caves have been visited") {
            Then("return false") {
                path.hasTwoSmallCaveVisits() shouldBe false
            }

        }
    }

})