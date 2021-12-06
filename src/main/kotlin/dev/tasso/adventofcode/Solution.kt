package dev.tasso.adventofcode

import kotlin.reflect.full.primaryConstructor

interface Solution<T> {

    fun part1(input: List<String>): T

    fun part2(input: List<String>): T

}

