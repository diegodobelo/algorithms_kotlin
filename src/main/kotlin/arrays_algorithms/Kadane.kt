package arrays_algorithms

import kotlin.math.max

class Kadane {
    fun maxSubArraySum(arr: Array<Int>) : Int {
        var maxEndingHere = arr[0]
        var maxSoFar = arr[0]

        for (i in (1..<arr.size)) {
            val currentValue = arr[i]
            val maxPlusCurrent = maxEndingHere + arr[i]
            maxEndingHere = max(arr[i], maxEndingHere + arr[i])
            maxSoFar = max(maxSoFar, maxEndingHere)
        }

        return maxSoFar
    }
}