package dev.tasso.adventofcode._2022.day02

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day02Test : BehaviorSpec({

    include(solutionTest(Day02()::part1, 15, "2022/day02_test.txt"))
    include(solutionTest(Day02()::part2, 12, "2022/day02_test.txt"))

})