package dev.tasso.adventofcode._2021.day08

import dev.tasso.adventofcode.Solution

class Day08 : Solution<Int> {
    override fun part1(input: List<String>): Int {

       return input.map { notesEntry -> notesEntry.split("|")[1].trim().split(" ")}
            .sumOf { it.count { listOf(2,3,4,7).contains(it.length) } }

    }

    override fun part2(input: List<String>): Int {

        //Split each note into signal patterns and output value by splitting on the '|'
        val splitNotes = input.map{notesEntry -> notesEntry.split("|")}


        val processedNotes = splitNotes.map { splitNote ->
            //For each element of the note entry (signal patterns and output values)
            splitNote.map { digits ->
                //Get a list of digits
                digits.trim().split(" ").map{ digit ->
                    //Break the digit into its component segments and sort to ensure consistent representation herein
                    digit.toCharArray().sorted()
                }
            }
        }

        return processedNotes.sumOf { noteEntry ->

            val lookupTable = decodeLookupTable(noteEntry[0])

            noteEntry[1].joinToString("") { outputDigit -> lookupTable[outputDigit].toString() }.toInt()
        }

    }
}

fun decodeLookupTable(signalPatternDigits : List<List<Char>>): Map<List<Char>, Int> {

    //Knock out the easy number of segment based digits first
    val characterToSegmentsMap = mutableMapOf(
        1 to signalPatternDigits.single { it.size == 2 },
        7 to signalPatternDigits.single { it.size == 3 },
        4 to signalPatternDigits.single { it.size == 4 },
        8 to signalPatternDigits.single { it.size == 7 },
    )
    //3 is the only 5 segment character that shares every segment of the digit 7
    characterToSegmentsMap[3] = signalPatternDigits.single{it.size == 5 && (it intersect characterToSegmentsMap[7]!!).toTypedArray() contentEquals characterToSegmentsMap[7]!!.toTypedArray()}
    //9 is the only 6 segment character that shares every segment of the digit 4
    characterToSegmentsMap[9] = signalPatternDigits.single{it.size == 6 && (it intersect characterToSegmentsMap[4]!!).toTypedArray() contentEquals characterToSegmentsMap[4]!!.toTypedArray()}
    //Now that 9 is decoded, 0 is the only 6 segment character that shares every segment of the digit 7
    characterToSegmentsMap[0] = signalPatternDigits.single{it.size == 6 && it != characterToSegmentsMap[9]!! && (it intersect characterToSegmentsMap[7]!!).toTypedArray() contentEquals characterToSegmentsMap[7]!!.toTypedArray()}
    //Now that 9 and 0 are decoded, 6 is the only 6 segment character remaining
    characterToSegmentsMap[6] = signalPatternDigits.single{it.size == 6 && it != characterToSegmentsMap[9]!! && it !=characterToSegmentsMap[0]!!}
    //5 is the only remaining 3 segment character the shares any segments with another number (6)
    characterToSegmentsMap[5] = signalPatternDigits.single{it.size == 5 && (it intersect characterToSegmentsMap[6]!!).toTypedArray() contentEquals it.toTypedArray()}
    //2 is the only character remaining not assigned
    characterToSegmentsMap[2] = (signalPatternDigits subtract characterToSegmentsMap.values).single()


    //Swap the keys and values so that the digit can be looked up by the segments
    return characterToSegmentsMap.entries.associate { entry -> Pair(entry.value, entry.key)}
}
