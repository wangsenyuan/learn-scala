package set1000.set1100.set1140.p1146

import scala.collection.mutable.ArrayBuffer

class SnapshotArray(_length: Int) {
  val array = Array.ofDim[ArrayBuffer[(Int, Int)]](_length)
  var current = 0

  (0 until _length).foreach(i => {
    array(i) = ArrayBuffer.empty
    array(i) += current -> 0
  })


  def set(index: Int, v: Int) {
    val row = array(index)
    if (row.last._1 == current) {
      row(row.length - 1) = current -> v
    } else {
      array(index) += current -> v
    }
  }

  def snap(): Int = {
    val res = current
    current += 1
    res
  }

  def get(index: Int, snap_id: Int): Int = {
    val row = array(index)

    var left = 0
    var right = row.length

    while (left < right) {
      val mid = (left + right) / 2
      if (row(mid)._1 > snap_id) {
        right = mid
      } else {
        left = mid + 1
      }
    }

    row(right - 1)._2
  }

}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * var obj = new SnapshotArray(length)
 * obj.set(index,`val`)
 * var param_2 = obj.snap()
 * var param_3 = obj.get(index,snap_id)
 */
