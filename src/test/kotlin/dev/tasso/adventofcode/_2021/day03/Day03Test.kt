package dev.tasso.adventofcode._2021.day03

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day03Test : BehaviorSpec({

    include(solutionTest(Day03()::part1, 198, "2021/day03_test.txt"))
    include(solutionTest(Day03()::part2, 230, "2021/day03_test.txt"))

})