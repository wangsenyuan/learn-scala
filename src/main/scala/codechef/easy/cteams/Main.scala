package codechef.easy.cteams

import scala.collection.mutable
import scala.io.StdIn

object Main {

  case class Chef(age: Int, rating: Int)

  object Chef {
    implicit val byAge = new Ordering[Chef] {
      override def compare(x: Chef, y: Chef) = {
        if (x.age < y.age) {
          -1
        } else if (x.age > y.age) {
          1
        } else {
          0
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val b = mutable.PriorityQueue.empty[Chef]
    val a = new mutable.PriorityQueue[Chef]()(Chef.byAge.reverse)
    var young = 0
    var old = 0
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val age = line(0)
      val rating = line(1)

      if (a.isEmpty || age > a.head.age) {
        a.enqueue(Chef(age, rating))
        old += rating
      } else {
        b.enqueue(Chef(age, rating))
        young += rating
      }

      if (a.size > b.size) {
        val tmp = a.dequeue()
        old -= tmp.rating
        b.enqueue(tmp)
        young += tmp.rating
      } else if (b.size > a.size + 1) {
        val tmp = b.dequeue()
        young -= tmp.rating
        a.enqueue(tmp)
        old += tmp.rating
      }

      println((old - young).abs)

      i += 1
    }
  }
}
