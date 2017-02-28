package codechef.easy.chefvote

import scala.io.StdIn

/**
  * Created by wangsenyuan on 28/02/2017.
  */
object Main {

  def valid(votes: Array[Int], n: Int) = {
    votes.sum == n && votes.find(x => x >= n || x < 0).isEmpty
  }

  def amend(f: Array[Int], b: Int, n: Int): Unit = {
    if (b == 0) {
      //do nothing
    } else if (b == 1) {
      var i = 0
      while (i < n && f(i) != i) {
        i += 1
      }

      var j = (i + 1) % n
      while (f(j) == i) {
        j = (j + 1) % n
      }
      f(i) = f(j)
      f(j) = i
    } else {
      var i = 0
      while (i < n && f(i) != i) {
        i += 1
      }
      var j = i + 1
      while (j < n && f(j) != j) {
        j += 1
      }
      val x = f(j)
      f(j) = f(i)
      f(i) = x
      amend(f, b - 2, n)
    }
  }

  def findPossibleVote(votes: Array[Int], n: Int): Array[Int] = {
    val f = Array.fill(n)(0)

    var i = 0
    var j = 0
    var b = 0
    while (i < n) {
      var x = votes(i)
      while (x > 0) {
        f(j) = i

        if (j == i) {
          b += 1
        }

        j += 1
        x -= 1
      }
      i += 1
    }

    if (b > 0) {
      amend(f, b, n)
    }


    f.map(_ + 1)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val votes = StdIn.readLine().split("\\s+").map(_.toInt)

        if (!valid(votes, n)) {
          println(-1)
        } else {
          val res = findPossibleVote(votes, n)
          println(res.mkString(" "))
        }
    }
  }
}
