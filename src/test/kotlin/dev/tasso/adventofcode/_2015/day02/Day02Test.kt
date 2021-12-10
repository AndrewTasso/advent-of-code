package dev.tasso.adventofcode._2015.day02

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec


class Day02Test : BehaviorSpec({

    include(solutionTest(Day02()::part1, 58, "2015/Day02_test_pt1_01.txt"))
    include(solutionTest(Day02()::part1, 43, "2015/Day02_test_pt1_02.txt"))

})