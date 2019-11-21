package set1000.set1100.set1130.p1131

object Solution {
  def maxAbsValExpr(arr1: Array[Int], arr2: Array[Int]): Int = {
    // let i > j
    // |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + i - j
    // => 1. arr1[i] - arr1[j] + arr2[i] - arr2[j] => arr1[i] + arr2[i] + i - (arr1[j] + arr2[j] + j)
    // => 2. arr1[i] - arr1[j] + arr2[j] - arr2[i] => (arr1[i] - arr2[i] + i) - (arr1[j] - arr2[j] + j)
    // => 3. arr1[j] - arr1[i] + arr2[i] - arr2[j] => -(arr1[i] - arr2[i] - i) + (arr1[j] - arr2[j] - j)
    // => 4. arr1[j] - arr1[i] + arr2[j] - arr2[i] => -(arr1[i] + arr2[i] - i) + (arr1[j] + arr2[j] - j)
    val n = arr1.length

    // A is min value of arr1[i] + arr2[i] + i
    var A = arr1(0) + arr2(0)
    // B is min value of arr1[i] - arr2[i] + i
    var B = arr1(0) - arr2(0)
    // C is max value of arr1[i] - arr2[i] - i
    var C = arr1(0) - arr2(0)
    // D is max value of arr1[i] + arr2[i] - i
    var D = arr1(0) + arr2(0)

    var best = 0

    var i = 1
    while (i < n) {
      val x = arr1(i) + arr2(i)
      val y = arr1(i) - arr2(i)

      best = best max (x + i - A) max (y + i - B) max (-y + i + C) max (-x + i + D)

      A = A min (x + i)
      B = B min (y + i)
      C = C max (y - i)
      D = D max (x - i)

      i += 1
    }

    best
  }
}
