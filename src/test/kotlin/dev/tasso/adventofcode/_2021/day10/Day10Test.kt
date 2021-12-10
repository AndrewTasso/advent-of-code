package dev.tasso.adventofcode._2021.day10

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec
import java.math.BigInteger

class Day10Test : BehaviorSpec({

    include(solutionTest(Day10()::part1, BigInteger.valueOf(26397), "2021/day10_test.txt"))
    include(solutionTest(Day10()::part2, BigInteger.valueOf(288957), "2021/day10_test.txt"))

})