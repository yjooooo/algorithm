import kotlin.math.round

fun main() {
    val n = readLine()!!.toInt()
    val arr = ArrayList<Int>()
    val map = mutableMapOf<Int, Int>()

    for (i in 0 until n) {
        val num = readLine()!!.toInt()
        arr.add(num)
        if (map.containsKey(num)) {
            map[num] = map[num]!! + 1
        } else {
            map[num] = 1
        }
    }
    val sortedArr = arr.sorted()

    val sortedMap = map.toList().sortedWith(compareBy(
        { it.second },
        { it.first }
    ))
    val filteredMap = sortedMap.filter {
        it.second == sortedMap.last().second
    }

    // 산술평균
    println(round(arr.average()).toInt())
    // 중앙값
    println(sortedArr[n / 2])
    //최빈값
    if (filteredMap.size != 1) {
        println(filteredMap[1].first)
    } else {
        println(filteredMap.last().first)
    }
    // 범위
    println(sortedArr.last() - sortedArr.first())
}