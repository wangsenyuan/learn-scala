package p179

/**
 * Created by senyuanwang on 15/3/14.
 */
object App extends App {

  def largestNumber(num: Array[Int]): String = {
    val strs = num.map(_.toString)

    val sorted = strs.sortWith((a, b) => (a + b).compareTo(b + a) >= 0)

    sorted.mkString("").dropWhile(x => x == '0')
  }

  println(largestNumber(Array(3, 30, 34, 5, 9)))
}
