package codechef.rrecipe

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/12/2016.
  */
object Main {

  val M = 10000009

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val res = reconstructReceipt(StdIn.readLine())
      println(res)
    }
  }

  def reconstructReceipt(receipt: String): Int = {
    var i = 0
    var j = receipt.length - 1
    var res = 1
    while (i <= j && res != 0) {
      val x = receipt(i)
      val y = receipt(j)
      if (x == '?' && y == '?') {
        res = res * 26 % M
      } else if (x == '?' || y == '?') {
        res = res * 1
      } else if (x != y) {
        res = 0
      }

      i += 1
      j -= 1
    }

    res
  }
}
