package dev.tasso.adventofcode._2015.day03

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec


class Day03Test : BehaviorSpec({

    include(solutionTest(Day02()::part1, 2, "2015/Day03_test_pt1_01.txt"))
    include(solutionTest(Day02()::part1, 4, "2015/Day03_test_pt1_02.txt"))
    include(solutionTest(Day02()::part1, 2, "2015/Day03_test_pt1_03.txt"))

    include(solutionTest(Day02()::part2, 3, "2015/Day03_test_pt2_01.txt"))
    include(solutionTest(Day02()::part2, 3, "2015/Day03_test_pt2_02.txt"))
    include(solutionTest(Day02()::part2, 11, "2015/Day03_test_pt2_03.txt"))

})