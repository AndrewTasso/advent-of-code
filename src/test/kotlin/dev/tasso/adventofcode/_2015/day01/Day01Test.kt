package dev.tasso.adventofcode._2015.day01

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day01Test<Int> : BehaviorSpec({

    include(solutionTest(Day01()::part1, 0, "2015/Day01_test_pt1_01.txt"))
    include(solutionTest(Day01()::part1, 0, "2015/Day01_test_pt1_02.txt"))
    include(solutionTest(Day01()::part1, 3, "2015/Day01_test_pt1_03.txt"))
    include(solutionTest(Day01()::part1, 3, "2015/Day01_test_pt1_04.txt"))
    include(solutionTest(Day01()::part1, 3, "2015/Day01_test_pt1_05.txt"))
    include(solutionTest(Day01()::part1, -1, "2015/Day01_test_pt1_06.txt"))
    include(solutionTest(Day01()::part1, -1, "2015/Day01_test_pt1_07.txt"))
    include(solutionTest(Day01()::part1, -3, "2015/Day01_test_pt1_08.txt"))
    include(solutionTest(Day01()::part1, -3, "2015/Day01_test_pt1_09.txt"))

    include(solutionTest(Day01()::part2, 1, "2015/Day01_test_pt2_01.txt"))
    include(solutionTest(Day01()::part2, 5, "2015/Day01_test_pt2_02.txt"))

})