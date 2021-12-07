package dev.tasso.adventofcode

import io.kotest.core.spec.style.behaviorSpec
import io.kotest.matchers.shouldBe

fun <T> solutionTest(solutionPart: (List<String>) -> T,
                     expectedResult: T,
                     inputResourcePath: String) = behaviorSpec {

    Given("A sample input file of $inputResourcePath") {

        val url = this::class.java.classLoader.getResource(inputResourcePath)

        val input = url?.readText()?.trim()?.split(System.lineSeparator())
            ?: throw IllegalArgumentException("Failed to read content of test input file - $inputResourcePath")

        When("executing the solution") {
            Then("a result of $expectedResult should be received") {


                solutionPart(input) shouldBe expectedResult

            }
        }
    }
}
