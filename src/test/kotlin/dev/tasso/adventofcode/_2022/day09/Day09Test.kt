package dev.tasso.adventofcode._2022.day09

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day09Test : BehaviorSpec({

    include(solutionTest(Day09()::part1, 13, "2022/day09_test_01.txt"))
    include(solutionTest(Day09()::part1, 88, "2022/day09_test_02.txt"))

    include(solutionTest(Day09()::part2, 1, "2022/day09_test_01.txt"))
    include(solutionTest(Day09()::part2, 36, "2022/day09_test_02.txt"))

})
