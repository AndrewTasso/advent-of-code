package dev.tasso.adventofcode._2022.day04

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day04Test : BehaviorSpec({

    include(solutionTest(Day04()::part1, 2, "2022/day04_test.txt"))
    include(solutionTest(Day04()::part2, 4, "2022/day04_test.txt"))


})