package set100.set160.p165

object Solution {

  def compareVersion(version1: String, version2: String): Int = {
    val a = version1.split("\\.")
    val b = version2.split("\\.")


    def cal(a: Array[String], i: Int): Int = {
      if (i >= a.length) {
        0
      } else {
        a(i).toInt
      }
    }

    def go(i: Int, j: Int, x: Int, y: Int): Int = {
      if (x < y) {
        -1
      } else if (x > y) {
        1
      } else if (i >= a.length && j >= b.length) {
        0
      } else {
        go(i + 1, j + 1, cal(a, i), cal(b, j))
      }
    }

    go(0, 0, 0, 0)
  }
}
