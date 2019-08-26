package set0000.set200.set290.p299

import scala.collection.immutable

object Solution {

  private def count(xs: immutable.IndexedSeq[Char]) = {
    val res = Array.fill(10)(0)
    xs.foreach(x => res(x - '0') += 1)
    res
  }

  def getHint(secret: String, guess: String): String = {
    val nums = secret.zip(guess)
    val left = nums.filterNot(p => p._1 == p._2)
    val bulls = nums.length - left.length

    val (x, y) = left.unzip
    val cnt1 = count(x)
    val cnt2 = count(y)
    val cows = cnt1.zip(cnt2).map(p => p._1 min p._2).sum

    s"${bulls}A${cows}B"
  }
}
