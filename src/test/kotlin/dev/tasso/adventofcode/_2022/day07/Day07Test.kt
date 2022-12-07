package dev.tasso.adventofcode._2022.day07

import dev.tasso.adventofcode.solutionTest
import io.kotest.core.spec.style.BehaviorSpec

class Day07Test : BehaviorSpec({

    include(solutionTest(Day07()::part1, 95437, "2022/day07_test.txt"))
    include(solutionTest(Day07()::part2, 24933642, "2022/day07_test.txt"))


})
