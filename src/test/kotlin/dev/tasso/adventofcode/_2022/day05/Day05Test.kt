package dev.tasso.adventofcode._2022.day05

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day05Test : BehaviorSpec({

    include(solutionTest(Day05()::part1, "CMZ", "2022/day05_test.txt"))

})