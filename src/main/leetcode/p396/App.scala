package p396

/**
  * Created by wangsenyuan on 07/12/2016.
  */
object App {

  def main(args: Array[String]) = {
    val a = Array(4, 3, 2, 6)
    println(maxRotateFunction(a))
  }

  def maxRotateFunction(a: Array[Int]): Int = {
    val b = a.map(_.toLong)
    val sum = b.sum
    val f0 = b.zipWithIndex.map {
      case (x, i) => x * i
    }.sum
    //println(f0)
    val n = a.length

    def fs(prev: Long, k: Int): Stream[Long] = {
      val j =
        if (n - k - 1 >= 0) {
          (n - k - 1) % n
        } else {
          (n - k - 1) % n + n
        }
      val cur = (prev + sum - n * a(j))
      prev #:: fs(cur, k + 1)
    }

    //fs(f0, 0).take(n).foreach(println)
    fs(f0, 0).take(n).max.toInt
  }

}
