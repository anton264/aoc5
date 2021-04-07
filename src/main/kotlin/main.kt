fun main() {
    val inputs = getResourceAsText("input")
    var highestId = 0
    val seatIds = mutableListOf<Int>()
    for (input in inputs) {
        val rows = input.subSequence(0, 7)
        val seats = input.subSequence(7, 10)
        val row = findRowOrColumn(rows, 0..127)
        val seat = findRowOrColumn(seats, 0..7)
        val seatId = row * 8 + seat
        if (seatId > highestId) highestId = seatId
        //Part 2
        seatIds.add(seatId)
    }
    println("The highest seatId is: $highestId")
    // Part 2
    val sortedSeatIds = seatIds.sorted()
    for ((index, seat) in sortedSeatIds.withIndex()) {
        if (sortedSeatIds[index + 1] != seat + 1) {
            println("My seat is ${seat + 1}")
            break
        }
    }
}

fun findRowOrColumn(input: CharSequence, numbers: IntRange): Int {
    var rowsOrColumns = numbers.toList()
    for (item in input) {
        when (item) {
            'F', 'L' -> rowsOrColumns = rowsOrColumns.subList(0, rowsOrColumns.lastIndex / 2 + 1)
            'B', 'R' -> rowsOrColumns = rowsOrColumns.subList(rowsOrColumns.lastIndex / 2 + 1, rowsOrColumns.lastIndex + 1)
        }
    }
    return rowsOrColumns[0]
}

fun getResourceAsText(path: String): List<String> {
    return object {}.javaClass
        .getResource(path)
        .readText()
        .lines()
}