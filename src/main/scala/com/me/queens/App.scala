package com.me.queens

/**
  * Created by senyuanwang on 16/7/17.
  */
object App extends App {

  def queens(n: Int): Vector[Vector[String]] = {
    var result = Vector[Vector[String]]()
    val col = Array.fill(n)(-1)

    def promising(i: Int): Boolean = {
      var switch = true
      var k = 0
      while (k < i && switch) {
        switch = !(col(i) == col(k) || (col(i) - col(k)).abs == i - k)
        k += 1
      }

      switch
    }

    def rowRep(i: Int): String = {
      var str = ""
      var j = 0
      while (j < i) {
        str += "."
        j += 1
      }

      str += "Q"
      j += 1
      while (j < n) {
        str += "."
        j += 1
      }
      str
    }
    def toResult(): Vector[String] = {
      col.map(rowRep).toVector
    }

    def arrange(i: Int): Unit = {
      if (promising(i)) {
        if (i == n - 1) {
          result = result :+ toResult()
        } else {
          for {
            j <- 0 until n
          } {
            col(i + 1) = j
            arrange(i + 1)
          }
        }
      }
    }

    arrange(-1)

    result
  }

  val candiates = queens(4)

  for {
    candidate <- candiates
  } {
    for {
      row <- candidate
    } {
      println(row.mkString(""))
    }
    println
  }
}
