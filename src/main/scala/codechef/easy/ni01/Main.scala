package codechef.easy.ni01

import scala.annotation.tailrec
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    var i = 0
    while (i < n) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val cars = line(0)
    val wander = line(1)
    val ready = line(2)
    val p = line(3)
    val r = line(4)
    val k = line(5)

    if (cars == 0) {
      val waitingInLine = (wander min (k / r))
      println(s"0 0 ${wander - waitingInLine}, ${ready + waitingInLine}")
    } else {
      val carArries = Array.fill(cars)(0)
      val peopleReady = Array.fill(wander + ready)(0)
      (0 until wander) foreach {
        i =>
          peopleReady(ready + i) = (i + 1) * r
      }

      @tailrec
      def checkPerson(i: Int, nextCar: Int, done: Int, riding: Int): (Int, Int) = {
        if (i < ready + wander && peopleReady(i) <= k) {
          var readyTime = peopleReady(i)
          if (carArries(nextCar) > readyTime) {
            readyTime = carArries(nextCar)
          }
          carArries(nextCar) = readyTime + p

          var ndone = done
          var nriding = riding
          if (readyTime + p <= k) {
            ndone += 1
          } else if (readyTime <= k) {
            nriding += 1
          }
          checkPerson(i + 1, (nextCar + 1) % cars, ndone, nriding)
        } else {
          (done, riding)
        }
      }

      val (done, riding) = checkPerson(0, 0, 0, 0)

      val carWaiting = (0 until cars).filter(i => carArries(i) <= k).size

      println(s"$carWaiting $done ${0 max (wander - k / r)} ${ready + (wander min (k / r)) - done - riding}")
    }

  }
}
