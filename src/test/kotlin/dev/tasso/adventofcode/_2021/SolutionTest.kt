package dev.tasso.adventofcode._2021

import io.kotest.core.spec.style.behaviorSpec
import io.kotest.matchers.shouldBe

fun <T> solutionTest(solutionPart: (List<String>) -> T,
                     expectedResult: T,
                     inputResourcePath: String) = behaviorSpec {

    Given("A sample input file of $inputResourcePath") {

        val input = this::class.java.classLoader.getResource(inputResourcePath)!!.readText().trim().split(System.lineSeparator())

        When("executing a the solution") {
            Then("a result of $expectedResult should be received") {


                solutionPart(input) shouldBe expectedResult

            }
        }
    }
}
