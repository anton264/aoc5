fun main(){
    println("Hello world!")
    val input = "FBFBBFFRLR"
    var rows = input.subSequence(0,7)
    var seats = input.subSequence(7,10)
    var row = calc(rows, 0..127)
    var seat = calc(seats, 0..7)
    println(row*8+seat)

}
fun calc(input: CharSequence, numbers: IntRange): Int {
    var seatRows = numbers.toList()
    for (item in input){
        when (item) {
            'F','L' -> seatRows = seatRows.subList(0, seatRows.lastIndex/2+1)
            'B','R' -> seatRows = seatRows.subList(seatRows.lastIndex/2+1, seatRows.lastIndex+1)
        }
        //println("${seatRows.first()} ${seatRows.last()}")
    }
    return seatRows[0]
}