package dev.tasso.adventofcode._2021.day12

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

internal class Day12Test : BehaviorSpec({

    include(solutionTest(Day12()::part1, 10, "2021/Day12_test_pt1_01.txt"))
    include(solutionTest(Day12()::part1, 19, "2021/Day12_test_pt1_02.txt"))
    include(solutionTest(Day12()::part1, 226, "2021/Day12_test_pt1_03.txt"))

})