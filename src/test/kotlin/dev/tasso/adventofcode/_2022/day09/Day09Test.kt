package dev.tasso.adventofcode._2022.day09

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day09Test : BehaviorSpec({

    include(solutionTest(Day09()::part1, 13, "2022/day09_test.txt"))
//    include(solutionTest(Day09()::part2, 8, "2022/day09_test.txt"))

})
