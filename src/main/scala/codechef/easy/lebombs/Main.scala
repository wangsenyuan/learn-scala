package codechef.easy.lebombs

import scala.io.StdIn

/**
  * Created by senyuanwang on 2016/10/6.
  */
object Main {

  def play(rooms: Array[Char]) = {
    if (rooms.length <= 2) {
      if (rooms.exists(_ == '1')) {
        0
      } else {
        rooms.length
      }
    } else {
      var cnt = 0
      var i = 0
      while (i < rooms.length) {
        if (rooms(i) == '1') {
          //stay same
        } else if (i == 0 && rooms(i + 1) == '0') {
          cnt += 1
        } else if (i == rooms.length - 1 && rooms(i - 1) == '0') {
          cnt += 1
        } else if (i > 0 && i < rooms.length - 1 && rooms(i - 1) == '0' && rooms(i + 1) == '0') {
          cnt += 1
        }
        i += 1
      }

      cnt
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val rooms = StdIn.readLine().toCharArray()

      val r = play(rooms)

      println(r)
      t -= 1
    }
  }
}
