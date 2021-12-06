package dev.tasso.adventofcode._2021.day05

import dev.tasso.adventofcode._2021.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day05Test : BehaviorSpec({

    include(solutionTest(Day05()::part1, 5, "day05_test.txt"))
    include(solutionTest(Day05()::part2, 12, "day05_test.txt"))

})