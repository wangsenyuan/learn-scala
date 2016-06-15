package geeks.sort.bitonic

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangsenyuan on 6/15/16.
  */
trait Sorter {

  def normalizeArray(nums: Vector[Int]): Array[Int] = {
    val ab = new ArrayBuffer[Int]()
    ab ++= nums

    var l = 2
    while (l < ab.size) {
      l *= 2
    }

    if (ab.size < l) {
      ab ++= Array.fill(l - ab.size)(Int.MaxValue)
    }

    ab.toArray
  }

  def bitonic(nums: Vector[Int]): Vector[Int] = {
    val n = nums.length
    val array = normalizeArray(nums)

    def sort(low: Int, cnt: Int, asc: Boolean): Unit =
      if (cnt > 1) {
        val k = cnt / 2
        sort(low, k, true)
        sort(low + k, k, false)
        merge(low, cnt, asc)
      }

    def merge(low: Int, cnt: Int, asc: Boolean): Unit =
      if (cnt > 1) {
        val k = cnt / 2
        var i = low;
        while (i < low + k) {
          compAndSwap(i, k + i, asc)
          i += 1
        }
        merge(low, k, asc)
        merge(low + k, k, asc)
      }

    def compAndSwap(i: Int, j: Int, asc: Boolean): Unit = {
      if ((array(i) > array(j) && asc) || (array(i) < array(j) && !asc)) {
        val temp = array(i)
        array(i) = array(j)
        array(j) = temp
      }
    }

    sort(0, array.length, true)
    array.toVector.take(n)
  }
}
