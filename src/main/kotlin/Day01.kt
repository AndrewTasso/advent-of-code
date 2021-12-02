import one.util.streamex.StreamEx
import java.util.stream.IntStream
import java.util.stream.Stream
import kotlin.streams.toList

fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")

}

fun part1(input: List<String>): Int =
    input.stream()
         .map(String::toInt)
         .asStreamEx()
         .pairMap{ previousDepth, currentDepth -> currentDepth > previousDepth}
         .filter{b -> b}
         .count()
         .toInt()

fun part2(input: List<String>): Int =
    input.stream()
         .map(String::toInt)
         .ofSlidingWindowSubLists(3)
         .asStreamEx()
         .pairMap{ previousDepths, currentDepths -> currentDepths.sum() > previousDepths.sum()}
         .filter{b -> b}
         .count()
         .toInt()

fun <T> Stream<T>.asStreamEx() : StreamEx<T> = StreamEx.of(this)

fun <T> Stream<T>.ofSlidingWindowSubLists(windowSize: Int) : Stream<List<T>> {

    val list = this.toList()

    return if(windowSize > list.size)
        Stream.empty()
    else
        IntStream.range(0, list.size - windowSize + 1)
                 .mapToObj{ start -> list.subList(start, start+windowSize) }

}
