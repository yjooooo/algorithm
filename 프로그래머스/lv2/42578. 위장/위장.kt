class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val clothesMap = HashMap<String, Int>()

        for (clothe in clothes) {
            if (clothesMap[clothe[1]] == null) {
                clothesMap[clothe[1]] = 1
            } else {
                clothesMap[clothe[1]] = requireNotNull(clothesMap[clothe[1]]) + 1
            }
        }

        for (key in clothesMap.keys) {
            // 현재 종류의 옷을 입었을 경우 + 현재 종류의 옷을 안입었을 경우
            // = 옷 개수 + 1
            answer *= requireNotNull(clothesMap[key]) + 1
        }

        // -1 : 어떤 종류의 옷도 안입었을 경우
        return answer - 1
    }
}