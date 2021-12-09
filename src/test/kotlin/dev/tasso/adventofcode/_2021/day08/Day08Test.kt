package dev.tasso.adventofcode._2021.day08

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

internal class Day08Test : BehaviorSpec({

    include(solutionTest(Day08()::part1, 26, "2021/day08_test.txt"))
    include(solutionTest(Day08()::part2, 61229, "2021/day08_test.txt"))

})