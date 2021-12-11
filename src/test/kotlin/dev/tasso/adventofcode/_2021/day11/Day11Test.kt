package dev.tasso.adventofcode._2021.day11

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

internal class Day11Test : BehaviorSpec({

    include(solutionTest(Day11()::part1, 1656, "2021/day11_test.txt"))

})