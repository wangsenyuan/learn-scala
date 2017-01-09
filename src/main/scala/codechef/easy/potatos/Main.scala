package codechef.easy.potatos

import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {

    //primes.take(10).foreach(println)

    var t = StdIn.readInt

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      val x = line(0)
      val y = line(1)

      val z = primes.dropWhile(p => p <= x + y).head
      println(z - x - y)
      t -= 1
    }
  }


  def primes: Stream[Int] = {
    /*
        def factors(n: Int): List[Int] = {
          var x = 1
          var res: List[Int] = Nil
          while (x * x <= n) {
            if (n % x == 0) {
              val y = n / x
              res = x :: res
              if (y != x) {
                res = y :: res
              }
            }
            x += 1
          }
          res
        }
    */

    //Stream.from(2).filter(factors(_).size == 2)

    def go(prev: List[Int], cur: Int): Stream[Int] = {
      if (prev.forall(x => cur % x != 0)) {
        cur #:: go(cur :: prev, cur + 1)
      } else {
        go(prev, cur + 1)
      }
    }

    go(Nil, 2)
  }
}
