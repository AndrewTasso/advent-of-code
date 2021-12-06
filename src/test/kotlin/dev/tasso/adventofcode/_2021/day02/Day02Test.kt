package dev.tasso.adventofcode._2021.day02

import dev.tasso.adventofcode._2021.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day02Test : BehaviorSpec({

    include(solutionTest(Day02()::part1, 150, "day02_test.txt"))
    include(solutionTest(Day02()::part2, 900, "day02_test.txt"))

})