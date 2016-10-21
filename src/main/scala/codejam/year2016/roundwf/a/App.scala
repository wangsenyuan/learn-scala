package codejam.year2016.roundwf.a

import scala.io.StdIn

/**
  * Created by wangsenyuan on 21/10/2016.
  */
object App {

  def main(args: Array[String]): Unit = {
    val T = StdIn.readInt()

    var t = 1

    while (t <= T) {
      val ab = StdIn.readLine().split("\\s+").map(_.toLong)
      val r = StdIn.readLine()

      val ans = play(r, ab(0), ab(1))

      println(s"Case #$t: $ans")

      t += 1
    }
  }

  val ç = '\0'

  class State {
    var transitions = Map.empty[Char, List[State]]

    def transit(op: Char, next: State) = {
      transitions.get(op) match {
        case None => transitions += op -> List(next)
        case Some(xs) => transitions += op -> (next :: xs)
      }
    }

    def reach(op: Char): Option[State] = {
      transitions.get(ç) match {
        case None =>
          transitions.get(op) match {
            case Some(xs) =>
              xs match {
                case h :: Nil => Some(h)
                case _ => None
              }
            case None => None
          }
        case Some(ys) =>
          var res: Option[State] = None
          for {
            y <- ys
            if res.isEmpty
            z <- y.reach(op)
          } {
            res = Some(z)
          }
          res
      }
    }
  }

  class NFA(r: String) {
    val start = new State
    val end = new State
    val n = r.length

    private def build(): Unit = {
      if (n == 1) {
        start.transit(r(0), end)
      } else if (n > 3 && r(0) == '(' && r(n - 1) == '*') {
        val sub = new NFA(r.substring(1, n - 2))
        sub.end.transit(ç, sub.start)
        start.transit(ç, sub.start)
        sub.end.transit(ç, this.end)
      } else if (n > 2 && r(0) == '(' && r(n - 1) == ')') {
        val xs = r.substring(1, n - 1).split("|")
        xs.foreach {
          x =>
            val sub = new NFA(x)
            start.transit(ç, sub.start)
            sub.end.transit(ç, this.end)
        }
      } else {
        val xs = r.toCharArray
        var prev = this.start
        xs.foreach {
          x =>
            val sub = new NFA("" + x)
            prev.transit(ç, sub.start)
            prev = sub.end
        }
        prev.transit(ç, this.end)
      }
    }

    build()
  }


  def play(r: String, a: Long, b: Long): Long = {
    val nfa = new NFA(r)

    def matchNFA(x: Long): Long = {
      val s = x.toString

      var countState = Map((true, true, Set(nfa.start)) -> 1)

      var i = 0
      while (i < s.length) {
        var newCountState = Map((true, false, Set(nfa.start)) -> 1)

        for {
          ((isEmpty, isPrefix, states), count) <- countState
          newDigit <- 0 until 10
          if !isEmpty || newDigit != 0
          if !isPrefix || newDigit <= (s(i) - '0')
        } {
          var newPossibleStates = Set.empty[State]

          for {
            state <- states
            newState <- state.reach(s(i))
          } {
            newPossibleStates += newState
          }

          if (newPossibleStates.size > 0) {
            val key = (false, isPrefix && newDigit == (s(i) - '0'), newPossibleStates)
            newCountState.get(key) match {
              case None => newCountState += key -> count
              case Some(x) => newCountState += key -> (count + x)
            }
          }
        }

        countState = newCountState

        i += 1
      }

      var countMatch = 0L

      for {
        ((_, _, states), count) <- countState
        if states(nfa.end)
      } {
        countMatch += count
      }

      countMatch
    }

    matchNFA(b) - matchNFA(a - 1)
  }
}
