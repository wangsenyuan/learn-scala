package set0000.set700.set730.p736

import scala.collection.mutable

object Solution {
  def evaluate(expression: String): Int = {
    val n = expression.length
    val pair = Array.ofDim[Int](n)
    val stack = Array.ofDim[Int](n)
    var p = 0
    var i = n - 1

    while (i >= 0) {
      if (expression(i) == ')') {
        stack(p) = i
        p += 1
      } else if (expression(i) == '(') {
        pair(i) = stack(p - 1)
        p -= 1
      }

      i -= 1
    }

    def eval(begin: Int, end: Int, ctx: Context): Long = {
      if (expression(begin) == 'l' && begin + 3 < end && expression(begin + 1) == 'e' && expression(begin + 2) == 't') {
        // let
        evalLet(begin, end, Context.inherits(ctx))
      } else if (expression(begin) == 'a' && begin + 3 < end && expression(begin + 1) == 'd' && expression(begin + 2) == 'd') {
        // add
        evalAdd(begin, end, ctx)
      } else if (expression(begin) == 'm' && begin + 4 < end && expression(begin + 1) == 'u' && expression(begin + 2) == 'l' && expression(begin + 3) == 't') {
        // mult
        evalMult(begin, end, ctx)
      } else if (expression(begin) == '(') {
        eval(begin + 1, pair(begin) - 1, ctx)
      } else if (expression(begin).isDigit || expression(begin) == '-') {
        expression.substring(begin, end + 1).toLong
      } else {
        ctx.getValue(expression.substring(begin, end + 1))
      }
    }

    def evalLet(begin: Int, end: Int, ctx: Context): Long = {
      var i = begin + 4
      var j = i
      var key = ""
      var lastValue = 0L
      while (i < end && (key != "" || expression(i) != '(')) {
        if (expression(i) == '(') {
          // key can't be empty
          lastValue = eval(i, pair(i), ctx)
          ctx.putValue(key, lastValue)
          key = ""
          i = pair(i)
          j = i + 1
        } else if (expression(i) == ' ') {
          val part = expression.substring(j, i)
          if (key == "") {
            key = part
          } else {
            lastValue = eval(j, i - 1, ctx)
            ctx.putValue(key, lastValue)
            key = ""
          }
          j = i + 1
        }

        i += 1
      }

      if (i == end) {
        if(j < i) {
          eval(j, i, ctx)
        } else {
          lastValue
        }
      } else {
        j = pair(i)
        eval(i + 1, j - 1, ctx)
      }
    }

    def evalAdd(begin: Int, end: Int, ctx: Context) = evalOp(begin + 4, end, ctx, _ + _)

    def evalMult(begin: Int, end: Int, ctx: Context) = evalOp(begin + 5, end, ctx, _ * _)

    def evalOp(begin: Int, end: Int, ctx: Context, fn: (Long, Long) => Long): Long = {
      val i = begin

      if (expression(i) == '(') {
        // a sub expression
        val first = eval(i, pair(i), ctx)
        val second = eval(pair(i) + 2, end, ctx)
        fn(first, second)
      } else {
        var j = i
        while (expression(j) != ' ') {
          j += 1
        }
        val first = eval(i, j - 1, ctx)
        val second = eval(j + 1, end, ctx)
        fn(first, second)
      }
    }

    val res = eval(0, n, Context.empty)

    res.toInt
  }

  case class Context(parent: Context, cur: mutable.Map[String, Long]) {
    def getValue(key: String): Long = {
      if (cur.contains(key)) {
        cur(key)
      } else {
        parent.getValue(key)
      }
    }

    def putValue(key: String, value: Long) = cur += key -> value
  }

  object Context {
    def empty = new Context(null, mutable.Map.empty)

    def inherits(ctx: Context) = new Context(ctx, mutable.Map.empty)
  }

}
