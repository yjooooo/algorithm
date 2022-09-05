import java.util.LinkedList

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        var currentTruck = 0
        val trucksCount = truck_weights.size
        val doneTrucks = mutableListOf<Int>()
        val movingTrucks = LinkedList<Int>().apply { addAll(List(bridge_length) { 0 }) }
        var sumWeight = 0

        while (doneTrucks.size < trucksCount) {
            answer++
            with(movingTrucks.poll()) {
                sumWeight -= this
                if (this != 0) doneTrucks.add(this)
            }
            if (currentTruck <= trucksCount -1 && sumWeight + truck_weights[currentTruck] <= weight) {
                sumWeight += truck_weights[currentTruck]
                movingTrucks.add(truck_weights[currentTruck++])
            } else {
                movingTrucks.add(0)
            }
        }

        return answer
    }
}