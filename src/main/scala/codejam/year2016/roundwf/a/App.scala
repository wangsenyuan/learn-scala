package codejam.year2016.roundwf.a

import scala.annotation.tailrec
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

  case class Edge(from: Int, to: Int, op: Int)

  class NFA(var n: Int, var edges: Vector[Edge], var klein: Boolean = false) {
    def transit(v: Int, op: Int): Set[Int] = {
      edges.filter(e => e.from == v && e.op == op).map(_.to).toSet
    }

    def transitEmpty(v: Int, op: Int): Set[Int] = {
      @tailrec
      def go(vs: Set[Int], res: Set[Int]): Set[Int] = {
        if (vs.isEmpty) {
          res
        } else {
          val cur = vs.flatMap(v => transit(v, op))
          val ws = vs.flatMap(v => transit(v, -1))
          go(ws, cur ++ res)
        }
      }

      //transit(v, op) ++ transit(v, -1).flatMap(w => transitEmpty(w, op))
      go(Set(v), Set())
    }
  }

  object NFA {
    def digit(d: Int): NFA = new NFA(2, Vector(Edge(0, 1, d)))

    def concat(a: NFA, b: NFA): NFA = {
      if (b.n == 1) {
        a
      } else {
        a.edges ++= b.edges.map(e => e.copy(from = e.from + a.n - 1, to = e.to + a.n - 1))
        a.n += b.n - 1
        a.klein = false
        a
      }
    }

    def union(a: NFA, b: NFA): NFA = {
      val edges0 = {
        val (left, right) = a.edges.partition(_.to < a.n - 1)
        left ++ right.map(e => e.copy(to = a.n + b.n - 3))
      }
      val edges1 = {
        val (left, right) = b.edges.partition(_.from == 0)
        left.map(e => e.copy(to = e.to + a.n - 2)) ++ right.map(e => e.copy(from = e.from + a.n - 2, to = e.to + a.n - 2))
      }

      a.edges = edges0 ++ edges1
      a.n += b.n - 2
      a.klein = false
      a
    }

    def kleine(a: NFA): NFA = {
      if (a.klein) {
        a
      } else {
        val edges = a.edges.map(e => e.copy(from = e.from + 1, to = e.to + 1))
        a.n += 2
        a.edges = Edge(0, 1, -1) +: Edge(0, a.n - 1, -1) +: Edge(a.n - 2, a.n - 1, -1) +: Edge(a.n - 2, 1, -1) +: edges
        a.klein = true
        a
      }
    }

    private def pair(s: String): Int = {
      def go(i: Int, level: Int): Int = {
        if (i == s.length) {
          -1
        } else s(i) match {
          case '(' => go(i + 1, level + 1)
          case ')' if level == 1 => i
          case ')' => go(i + 1, level - 1)
          case _ => go(i + 1, level)
        }
      }

      go(0, 0)
    }

    private def split(s: String): Vector[String] = {
      def go(i: Int, j: Int, level: Int, res: Vector[String]): Vector[String] = {
        if (i == s.length) {
          res :+ s.substring(j, i)
        } else s(i) match {
          case '(' => go(i + 1, j, level + 1, res)
          case ')' => go(i + 1, j, level - 1, res)
          case '|' if level == 0 => go(i + 1, i + 1, 0, res :+ s.substring(j, i))
          case _ => go(i + 1, j, level, res)
        }
      }
      go(0, 0, 0, Vector())
    }

    def apply(r: String): NFA = {
      if (r.length == 0) {
        new NFA(1, Vector())
      } else {
        var x: NFA = null
        if (r(0) == '(') {
          var i = pair(r)
          if (i < r.length - 1 && r(i + 1) == '*') {
            x = kleine(apply(r.substring(1, i)))
            i += 1
          } else {
            val ss = split(r.substring(1, i))
            x = ss.map(apply(_)).reduce(union(_, _))
          }
          concat(x, apply(r.substring(i + 1)))
        } else {
          concat(digit(r(0) - '0'), apply(r.substring(1)))
        }
      }
    }
  }

  def play(r: String, a: Long, b: Long): Long = {
    val nfa = NFA(r)

    def matchNFA(x: Long): Long = {
      val s = x.toString

      var countState = Map((true, true, Set(0)) -> 1L)

      var i = 0
      while (i < s.length) {
        var newCountState = Map((true, false, Set(0)) -> 1L)

        for {
          ((isEmpty, isPrefix, states), count) <- countState
          newDigit <- 0 until 10
          if !isEmpty || newDigit != 0
          if !isPrefix || newDigit <= (s(i) - '0')
        } {
          var newPossibleStates = Set.empty[Int]

          for {
            state <- states
          } {
            newPossibleStates ++= nfa.transitEmpty(state, newDigit)
          }

          val key = (false, isPrefix && newDigit == (s(i) - '0'), newPossibleStates)
          newCountState.get(key) match {
            case None => newCountState += key -> count
            case Some(x) => newCountState += key -> (count + x)
          }
        }

        countState = newCountState

        i += 1
      }

      var countMatch = 0L

      for {
        ((isEmpty, _, states), count) <- countState
        if !isEmpty
        state <- states
        if state == nfa.n - 1 || nfa.transitEmpty(state, -1).exists(_ == nfa.n - 1)
      } {
        countMatch += count
      }

      countMatch
    }

    matchNFA(b) - matchNFA(a - 1)
  }
}
