package set0000.set300.set380.p384

class Solution(_nums: Array[Int]) {
  val n = _nums.length
  var arr = Array.ofDim[Int](n)
  Array.copy(_nums, 0, arr, 0, n)

  val rand = new util.Random()

  /** Resets the array to its original configuration and return it. */
  def reset(): Array[Int] = {
    //    arr = Array.ofDim[Int](n)
    Array.copy(_nums, 0, arr, 0, n)
    arr
  }

  /** Returns a random shuffling of the array. */
  def shuffle(): Array[Int] = {
    //    val res = Array.ofDim[Int](n)
    //    Array.copy(arr, 0, res, 0, n)
    var i = n - 1
    while (i > 0) {
      val j = rand.nextInt(i + 1)
      if (j < i) {
        arr(i) ^= arr(j)
        arr(j) ^= arr(i)
        arr(i) ^= arr(j)
      }
      i -= 1
    }
    arr = arr
    arr
  }
}
