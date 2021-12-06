package dev.tasso.adventofcode._2021.day06

import dev.tasso.adventofcode._2021.solutionTest
import io.kotest.core.spec.style.BehaviorSpec
import java.math.BigInteger

class Day06Test : BehaviorSpec({

    include(solutionTest(Day06()::part1, BigInteger.valueOf(5934), "day06_test.txt"))
    include(solutionTest(Day06()::part2, BigInteger.valueOf(26984457539), "day06_test.txt"))

})