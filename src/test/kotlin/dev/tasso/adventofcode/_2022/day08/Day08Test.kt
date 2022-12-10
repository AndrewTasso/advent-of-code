package dev.tasso.adventofcode._2022.day08

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day08Test : BehaviorSpec({

    include(solutionTest(Day08()::part1, 21, "2022/day08_test.txt"))
    include(solutionTest(Day08()::part2, 8, "2022/day08_test.txt"))

})
