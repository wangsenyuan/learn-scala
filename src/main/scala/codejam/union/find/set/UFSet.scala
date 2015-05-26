package codejam.union.find.set

/**
 * Created by senyuanwang on 15/5/26.
 */
class UFSet(val n: Int) {
  val array = Array.fill(n)(0)

  for {
    i <- 0 until n
  } {
    array(i) = i
  }

  def find(i: Int): Int = {
    val p = array(i)
    if (p != i) {
      array(i) = find(p)
      array(i)
    } else {
      p
    }
  }

  def union(a: Int, b: Int): Boolean = {
    val pa = find(a)
    val pb = find(b)
    if (pa != pb) {
      array(pa) = pb
      true
    } else {
      false
    }
  }
}
