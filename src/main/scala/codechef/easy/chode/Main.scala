package codechef.easy.chode

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val sequence = StdIn.readLine()
    val encrypted = StdIn.readLine()

    val freq = Array.fill(26)(0)

    var i = 0
    while (i < encrypted.length) {
      val c = encrypted(i)

      if (c >= 'a' && c <= 'z') {
        freq(c - 'a') += 1
      } else if (c >= 'A' && c <= 'Z') {
        freq(c - 'A') += 1
      }

      i += 1
    }

    val encSeq = (0 until 26).toArray.sortWith {
      (a: Int, b: Int) => freq(a) < freq(b) || (freq(a) == freq(b) && a < b)
    }

    val mapping = encSeq.zip(sequence).toMap

    val res = Array.fill(encrypted.length)(' ')
    i = 0
    while (i < res.length) {
      val c = encrypted(i)

      if (c >= 'a' && c <= 'z') {
        res(i) = mapping(c - 'a')
      } else if (c >= 'A' && c <= 'Z') {
        res(i) = (mapping(c - 'A') - 'a' + 'A').toChar
      } else {
        res(i) = c
      }

      i += 1
    }

    println(new String(res))
  }
}
