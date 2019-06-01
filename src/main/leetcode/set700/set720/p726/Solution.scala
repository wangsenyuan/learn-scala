package set700.set720.p726

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution {
  def countOfAtoms(formula: String): String = {
    val count = mutable.Map.empty[String, Int].withDefaultValue(0)

    val name = new mutable.StringBuilder()
    def loop(expr: String, factor: Int): Unit = {
      var i = 0
      while(i < expr.length) {
        if(expr(i).isUpper) {
          name.clear()
          name.append(expr(i))
          var j = i + 1
          while(j < expr.length && expr(j).isLower) {
            name.append(expr(j))
            j += 1
          }
          var cnt = 1
          if(j < expr.length && expr(j).isDigit) {
            cnt = 0
            while(j < expr.length && expr(j).isDigit) {
              cnt = cnt * 10 + (expr(j) - '0')
              j += 1
            }
          }
          count(name.toString()) += factor * cnt
          i = j - 1
        } else if(expr(i) == '(') {
          var level = 1
          var j = i + 1
          while(level > 0) {
            if(expr(j) == '(') {
              level += 1
            } else if(expr(j) == ')') {
              level -= 1
            }
            j += 1
          }
          val k = j
          var cnt = 1
          if(j < expr.length && expr(j).isDigit) {
            cnt = 0
            while(j < expr.length && expr(j).isDigit) {
              cnt = cnt * 10 + (expr(j) - '0')
              j += 1
            }
          }
          loop(expr.substring(i + 1, k - 1), cnt * factor)
          i = j - 1
        }

        i += 1
      }
    }

    loop(formula, 1)

    var res = ArrayBuffer.empty[(String, Int)]

    count.foreach(x => res.append(x))

    res = res.sortBy(_._1)

    res.map(x => {
      if(x._2 > 1) {
        s"${x._1}${x._2}"
      } else {
        x._1
      }
    }).mkString("")
  }

}
