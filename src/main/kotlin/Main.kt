import java.io.File

fun solvePart1(input: List<Int>) {
    println("PART 1 ANSWER")
    println(countFishByDay(input = input, days = 80))
}

fun solvePart2(input: List<Int>) {
    println("PART 2 ANSWER")
    println(countFishByDay(input = input, days = 256))
}

fun countFishByDay(input: List<Int>, days: Int): Long {
    val fishByAge = Array(size = 9) { 0L }

    // We initialise the number of fish for each age.
    input.forEach { fishByAge[it] += 1L }

    // Now, we loop from day 1 until xx.
    for (day in 1..days) {
        val parentCount = fishByAge[0]

        for (age in 1..8) {
            fishByAge[age - 1] = fishByAge[age]
        }

        // All parents will now back to 6
        fishByAge[6] += parentCount
        fishByAge[8] = parentCount
    }

    return fishByAge.sum()
}

fun main() {
    val input = File("input.txt").readText().split(",").map { it.toInt() }

    solvePart1(input)
    solvePart2(input)
}