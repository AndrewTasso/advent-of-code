package dev.tasso.adventofcode._2022.day11

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day11Test : BehaviorSpec({

    include(solutionTest(Day11()::part1, 10605, "2022/day11_test.txt"))
//    include(solutionTest(Day11()::part2, 1, "2022/day11_test.txt"))

})
