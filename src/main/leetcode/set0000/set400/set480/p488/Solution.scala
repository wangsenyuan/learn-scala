package set0000.set400.set480.p488

import scala.collection.mutable

object Solution {
  def findMinStep(board: String, hand: String): Int = {
    val INF = Int.MaxValue >> 1
    val cache = mutable.Map.empty[String, Int]

    def loop(board: String, hand: String):Int = {
      if(board.isEmpty) {
        0
      } else {
        val key = board + "-" + hand
        if(cache.contains(key)) {
          cache(key)
        } else {
          var i = 1
          var j = 0
          var best = INF
          while(i <= board.length) {
            if(i == board.length || board(i) != board(i-1)) {
              val color = board(i-1)
              val cnt = i - j
              val need = 3 - cnt
              val tmp = hand.count(_ == color)
              if(tmp >= need) {
                val cost = need + loop(newBoard(board.substring(0, j), board.substring(i)), newHand(hand, color, need))
                best = best min cost
              }

              j = i
            }

            i += 1
          }
          cache(key) = best
        }
        cache(key)
      }
    }

    val cs = hand.toCharArray.sorted

    val res = loop(board, new String(cs))
    if(res >= INF) {
      -1
    } else {
      res
    }
  }

  private def newHand(hand: String, color: Char, remove: Int): String = {
    val cs = hand.toCharArray
    var i = 0
    var j = 0
    var c = 0
    while(i < cs.length) {
      if(cs(i) != color || c == remove) {
        cs(j) = cs(i)
        j += 1
      } else {
        c += 1
      }

      i += 1
    }
    cs.subSequence(0, j).toString
  }

  private def newBoard(a: String, b: String): String = {
    if(a.isEmpty) {
      b
    } else if(b.isEmpty) {
      a
    } else {
      var i = a.length - 1
      while(i > 0 && a(i-1) == a(i)) {
        i -= 1
      }
      var j = 0
      while(j < b.length - 1 && b(j+1) == b(j)) {
        j += 1
      }
      if(a.length - i + j + 1 >= 3 && a(i) == b(j)) {
        newBoard(a.substring(0, i), b.substring(j+1))
      } else {
        a + b
      }
    }
  }
}
