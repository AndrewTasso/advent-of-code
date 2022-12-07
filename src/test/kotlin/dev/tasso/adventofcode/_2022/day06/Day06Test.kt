package dev.tasso.adventofcode._2022.day06

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day06Test : BehaviorSpec({

    include(solutionTest(Day06()::part1, 5, "2022/day06_test_pt1_01.txt"))
    include(solutionTest(Day06()::part1, 6, "2022/day06_test_pt1_02.txt"))
    include(solutionTest(Day06()::part1, 10, "2022/day06_test_pt1_03.txt"))
    include(solutionTest(Day06()::part1, 11, "2022/day06_test_pt1_04.txt"))

    include(solutionTest(Day06()::part2, 19, "2022/day06_test_pt2_01.txt"))
    include(solutionTest(Day06()::part2, 23, "2022/day06_test_pt2_02.txt"))
    include(solutionTest(Day06()::part2, 23, "2022/day06_test_pt2_03.txt"))
    include(solutionTest(Day06()::part2, 29, "2022/day06_test_pt2_04.txt"))
    include(solutionTest(Day06()::part2, 26, "2022/day06_test_pt2_05.txt"))

})
