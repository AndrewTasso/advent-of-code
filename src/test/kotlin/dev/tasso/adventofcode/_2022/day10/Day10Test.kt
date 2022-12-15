package dev.tasso.adventofcode._2022.day10

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day10Test : BehaviorSpec({

    include(solutionTest(Day10()::part1, 13140, "2022/day10_test.txt"))
    include(solutionTest(Day10()::part2, 1, "2022/day10_test.txt"))

})
