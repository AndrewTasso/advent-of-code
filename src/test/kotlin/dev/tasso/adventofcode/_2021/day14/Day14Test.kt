package dev.tasso.adventofcode._2021.day14

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

internal class Day14Test : BehaviorSpec({

    include(solutionTest(Day14()::part1, 1588, "2021/day14_test.txt"))

})