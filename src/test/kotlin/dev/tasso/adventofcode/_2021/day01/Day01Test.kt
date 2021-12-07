package dev.tasso.adventofcode._2021.day01

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day01Test : BehaviorSpec({

    include(solutionTest(Day01()::part1, 7, "2021/day01_test.txt"))
    include(solutionTest(Day01()::part2, 5, "2021/day01_test.txt"))

})