package set100.set170.p179

/**
  * Created by senyuanwang on 15/3/14.
  */
object App extends App {

  def largestNumber(num: Array[Int]): String = {
    val strs = num.map(_.toString)

    val res = strs.sortWith((a, b) => (a + b).compareTo(b + a) >= 0).mkString("")

    if (res(0) == '0') {
      "0"
    } else {
      res
    }
  }

  println(largestNumber(Array(3, 30, 34, 5, 9)))
}
