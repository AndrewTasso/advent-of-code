package dev.tasso.adventofcode._2022.day03

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day03Test : BehaviorSpec({

    include(solutionTest(Day03()::part1, 157, "2022/day03_test.txt"))

})