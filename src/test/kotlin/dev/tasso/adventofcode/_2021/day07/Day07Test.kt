package dev.tasso.adventofcode._2021.day07

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

internal class Day07Test : BehaviorSpec({

    include(solutionTest(Day07()::part1, 37, "2021/day07_test.txt"))
    include(solutionTest(Day07()::part2, 168, "2021/day07_test.txt"))

})