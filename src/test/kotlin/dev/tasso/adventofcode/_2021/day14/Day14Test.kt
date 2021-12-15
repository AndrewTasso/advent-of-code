package dev.tasso.adventofcode._2021.day14

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec
import java.math.BigInteger

internal class Day14Test : BehaviorSpec({

    include(solutionTest(Day14()::part1, BigInteger.valueOf(1588), "2021/day14_test.txt"))
    include(solutionTest(Day14()::part2, BigInteger.valueOf(2188189693529), "2021/day14_test.txt"))


})