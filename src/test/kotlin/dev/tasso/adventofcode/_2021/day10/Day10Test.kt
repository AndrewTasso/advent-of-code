package dev.tasso.adventofcode._2021.day10

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day10Test : BehaviorSpec({

    include(solutionTest(Day10()::part1, 26397, "2021/day10_test.txt"))
//    include(solutionTest(Day10()::part2, -1, "2021/day10_test.txt"))

})