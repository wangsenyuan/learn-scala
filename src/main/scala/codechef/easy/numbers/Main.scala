package codechef.easy.numbers

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/03/2017.
  */
object Main {

  case class Person(name: String, num: Long)

  def solve() = {
    val n = StdIn.readInt()

    val people = Array.fill[Person](n)(null)

    val one = mutable.Set.empty[Long]
    val two = mutable.Set.empty[Long]

    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+")
      val name = line(0)
      val num = line(1).toLong

      people(i) = new Person(name, num)

      if (one.contains(num)) {
        two += num
      } else {
        one += num
      }

      i += 1
    }

    var winner = ""
    var minmum = -1L
    i = 0
    while (i < people.length) {
      val p = people(i)

      if (!two.contains(p.num)) {
        if (minmum == -1 || p.num < minmum) {
          minmum = p.num
          winner = p.name
        }
      }

      i += 1
    }

    if (minmum == -1) {
      println("Nobody wins.")
    } else {
      println(winner)
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
