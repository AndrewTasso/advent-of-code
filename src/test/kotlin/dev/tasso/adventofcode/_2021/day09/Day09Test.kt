package dev.tasso.adventofcode._2021.day09

import dev.tasso.adventofcode._2021.day08.Day08
import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

internal class Day09Test : BehaviorSpec({

    include(solutionTest(Day09()::part1, 15, "2021/day09_test.txt"))
//    include(solutionTest(Day09()::part2, 15, "2021/day09_test.txt"))

})