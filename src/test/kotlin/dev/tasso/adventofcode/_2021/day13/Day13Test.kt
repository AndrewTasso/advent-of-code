package dev.tasso.adventofcode._2021.day13

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

internal class Day13Test : BehaviorSpec({

    include(solutionTest(Day13()::part1, 17, "2021/day13_test.txt"))

})