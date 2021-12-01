import kotlin.streams.toList

fun main() {

    fun part1(input: List<String>): Int {

        var count = 0

        val depths = input.stream().mapToInt(String::toInt).toList()

        for(i in 0 until depths.size - 1) {

            if(depths[i+1] > depths[i]) {

                count++

            }

        }

        return count
    }

    fun part2(input: List<String>): Int {

        var count = 0

        val depths = input.stream().mapToInt(String::toInt).toList()

        for(i in 0 until depths.size - 3) {

            if(depths.subList(i+1, i+3).sum() > depths.subList(i, i+2).sum()) {

                count++

            }

        }

        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
