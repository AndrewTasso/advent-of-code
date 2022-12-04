package dev.tasso.adventofcode._2022.day01

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day01Test : BehaviorSpec({

    include(solutionTest(Day01()::part1, 24000, "2022/day01_test.txt"))
    include(solutionTest(Day01()::part2, 45000, "2022/day01_test.txt"))

})