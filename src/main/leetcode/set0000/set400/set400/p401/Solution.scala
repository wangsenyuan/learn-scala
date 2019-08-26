package set0000.set400.set400.p401

object Solution {
  def readBinaryWatch(num: Int): List[String] = {
    val res = for {
      h <- 0 to (4 max num)
      m = num - h
      if(m < 6)
    } yield {
      convert(h, m)
    }

    res.flatten.toList
  }

  private def convert(h: Int, m: Int): List[String] = {

    def loop(cnt: Int, i: Int, time: Int, cap: Int): List[Int] = {
      if(time >= cap) {
        Nil
      } else if(cnt == 0) {
        List(time)
      } else if(i < 0) {
        Nil
      } else {
        loop(cnt, i -1, time, cap) ++ loop(cnt - 1, i - 1, time + (1 << i), cap )
      }
    }

    val hs = loop(h, 3, 0, 12)
    val ms = loop(m, 5, 0, 60)

    for {
      x <- hs
      y <- ms
    } yield {
      f"$x:$y%02d"
    }
  }
}
