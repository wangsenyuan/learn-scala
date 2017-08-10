package codechef.easy.ipctrain

import java.util

import scala.collection.mutable
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


  case class Trainer(arriveAt: Int, want: Int, sad: Int)

  implicit val trainerOrdering = new Ordering[Trainer] {
    override def compare(x: Trainer, y: Trainer): Int = {
      if (x.sad < y.sad) {
        -1
      } else if (x.sad > y.sad) {
        1
      } else if (x.arriveAt < y.arriveAt) {
        1
      } else if (x.arriveAt > y.arriveAt) {
        -1
      } else if (x.want < y.want) {
        1
      } else if (x.want > y.want) {
        -1
      } else {
        0
      }
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val d = firstLine(1)

    val trainers = new mutable.PriorityQueue[Trainer]()

    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val trainer = Trainer(line(0), line(1), line(2))
      trainers.enqueue(trainer)
      i += 1
    }


    val days = new util.TreeMap[Int, Boolean]()

    i = 1
    while (i <= d) {
      days.put(i, true)
      i += 1
    }

    var ans = 0L
    while (!trainers.isEmpty) {
      val trainer = trainers.dequeue()
      var entry = days.ceilingEntry(trainer.arriveAt)
      var j = 0
      while (entry != null && j < trainer.want) {
        days.remove(entry.getKey)

        j += 1
        entry = days.ceilingEntry(trainer.arriveAt + j)
      }
      if (j < trainer.want) {
        ans += 1L * (trainer.want - j) * trainer.sad
      }
    }

    println(ans)
  }


}
