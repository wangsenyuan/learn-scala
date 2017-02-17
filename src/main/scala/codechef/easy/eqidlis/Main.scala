package codechef.easy.eqidlis

import scala.annotation.tailrec
import scala.collection.immutable.TreeSet
import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/02/2017.
  */
object Main {

  case class Person(i: Int, num: Int)

  implicit val personOrder = new Ordering[Person] {
    override def compare(x: Person, y: Person): Int = {
      if (x.num < y.num) {
        -1
      } else if (x.num > y.num) {
        1
      } else {
        0
      }
    }
  }

  def distribute(people: Seq[Person]) = {
    val set = TreeSet(people: _*)

    @tailrec
    def go(set: TreeSet[Person], res: Int): Int = {
      val a = set.head
      val b = set.last
      val av = a.num
      val bv = b.num
      if (av == bv) {
        res
      } else {
        val x = (bv - av + 1) / 2
        go(set - a - b + a.copy(num = av + x) + b.copy(num = bv - x), res + 1)
      }
    }

    go(set, 0)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val nums = StdIn.readLine().split("\\s+").map(_.toInt)

      val sum = nums.sum
      if (sum % n != 0) {
        println(-1)
      } else {
        val people = (0 until n).map(i => Person(i, nums(i)))

        val res = distribute(people)
        println(res)
      }


      t -= 1
    }
  }
}
