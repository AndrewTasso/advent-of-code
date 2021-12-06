package dev.tasso.adventofcode._2021.day04

import dev.tasso.adventofcode._2021.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day04Test : BehaviorSpec({

    include(solutionTest(Day04()::part1, 4512, "day04_test.txt"))
    include(solutionTest(Day04()::part2, 1924, "day04_test.txt"))

})