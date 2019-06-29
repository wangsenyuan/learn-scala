package set700.set770.p770

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {
  def basicCalculatorIV(expression: String, evalvars: Array[String], evalints: Array[Int]): List[String] = {
    val n = expression.length
    val pair = Array.fill(n)(-1)
    val stack = Array.ofDim[Int](n)
    var p = 0
    var i = 0
    while (i < n) {
      if (expression(i) == '(') {
        stack(p) = i
        p += 1
      } else if (expression(i) == ')') {
        pair(stack(p - 1)) = i
        p -= 1
      }
      i += 1
    }

    def loop(start: Int, end: Int): Poly = {
      if (pair(start) == end) {
        loop(start + 1, end - 1)
      } else {
        val stack = Array.ofDim[Poly](4)
        var p0 = 0
        val ops = Array.ofDim[Char](3)
        var p1 = 0
        var j = start
        var i = start
        while (i <= end + 1) {
          if (i < end && expression(i) == '(') {
            stack(p0) = loop(i, pair(i))
            p0 += 1
            i = pair(i)
            j = i + 1
          } else if (i == end + 1 || expression(i) == ' ') {
            //sep
            if (j < i) {
              val s = expression.substring(j, i)

              if (s(0).isDigit) {
                // a number
                stack(p0) = Poly.number(s.toInt)
                p0 += 1
              } else if (s(0) == '+' || s(0) == '-' || s(0) == '*') {
                while (p1 > 0 && priority(ops(p1 - 1)) >= priority(s(0))) {
                  val a = stack(p0 - 2)
                  val b = stack(p0 - 1)
                  stack(p0 - 2) = operate(a, b, ops(p1 - 1))
                  p0 -= 1
                  p1 -= 1
                }
                ops(p1) = s(0)
                p1 += 1
              } else {
                stack(p0) = Poly.variable(s)
                p0 += 1
              }
            }
            j = i + 1
          }

          i += 1
        }

        while (p1 > 0) {
          val a = stack(p0 - 2)
          val b = stack(p0 - 1)
          stack(p0 - 2) = operate(a, b, ops(p1 - 1))
          p0 -= 1
          p1 -= 1
        }

        stack(0)
      }
    }

    val res = loop(0, n - 1)

    val map = evalvars.zip(evalints).toMap

    res(map).toList
  }

  private def priority(c: Char) = {
    c match {
      case '+' => 0
      case '-' => 0
      case '*' => 1
    }
  }

  private def operate(a: Poly, b: Poly, c: Char): Poly = {
    c match {
      case '+' => a.add(b)
      case '-' => a.sub(b)
      case '*' => a.mul(b)
    }
  }


  sealed trait Term {
    def mul(term: Term): Term

    def apply(map: Map[String, Int]): Term
  }

  object Term {
    def compare(a: Term, b: Term): Boolean = {
      (a, b) match {
        case (Num(_), Variable(_, _)) => false
        case (Variable(_, _), Num(_)) => true
        case (Variable(_, a), Variable(_, b)) => {
          if (a.length > b.length) {
            true
          } else if(a.length < b.length) {
            false
          } else {
            var i = 0
            while (i < a.length && i < b.length && a(i) == b(i)) {
              i += 1
            }
            i == a.length || a(i) < b(i)
          }
        }
        case _ => false
      }
    }
  }

  case class Variable(coff: Int, arr: Array[String]) extends Term {
    override def mul(term: Term): Term = {
      term match {
        case Variable(c, a) => {
          val vs = multipleVariables(arr, a)
          Variable(coff * c, vs)
        }
        case Num(n) => Variable(coff * n, arr)
      }
    }

    def apply(map: Map[String, Int]): Term = {
      var num = coff
      val xx = ArrayBuffer.empty[String]
      var i = 0
      while (i < arr.length) {
        if (map.contains(arr(i))) {
          num *= map(arr(i))
        } else {
          xx += arr(i)
        }
        i += 1
      }
      if (xx.isEmpty) {
        Num(num)
      } else {
        Variable(num, xx.toArray)
      }
    }


    override def toString: String = {
      val buf = new java.lang.StringBuilder()
      buf.append(coff)
      var i = 0
      while (i < arr.length) {
        buf.append('*')
        buf.append(arr(i))
        i += 1
      }
      buf.toString
    }
  }

  case class Num(num: Int) extends Term {
    override def mul(term: Term): Term = {
      term match {
        case Variable(_, _) => term.mul(this)
        case Num(x) => Num(num * x)
      }
    }

    def apply(map: Map[String, Int]) = this

    override def toString: String = {
      s"$num"
    }
  }


  class Poly(val terms: Array[Term]) {
    def add(that: Poly): Poly = {
      var res = that
      var i = 0
      while (i < terms.length) {
        res = addTerm(res, terms(i))
        i += 1
      }
      res
    }

    def sub(that: Poly): Poly = {
      var res = this
      var i = 0
      while (i < that.terms.length) {
        res = subTerm(res, that.terms(i))
        i += 1
      }
      res
    }

    def mul(that: Poly): Poly = {
      var res: Poly = null
      var i = 0
      while (i < terms.length) {
        val tmp = mulTerm(that, terms(i))
        if (res == null) {
          res = tmp
        } else {
          res = res.add(tmp)
        }
        i += 1
      }
      res
    }

    def apply(vars: Map[String, Int]): Poly = {
      val buf = ArrayBuffer.empty[Term]
      var i = 0
      while (i < terms.length) {
        buf += terms(i)(vars)
        i += 1
      }
      val ts = combineTerms(buf.toArray)
      new Poly(ts)
    }

    def toList(): List[String] = terms.map(_.toString).toList
  }

  object Poly {
    def number(num: Int) = {
      new Poly(Array(Num(num)))
    }

    def variable(s: String) = {
      new Poly(Array(Variable(1, Array(s))))
    }
  }

  private def mulTerm(poly: Poly, term: Term): Poly = {
    val terms = ArrayBuffer.empty[Term]
    var i = 0
    while (i < poly.terms.length) {
      terms += poly.terms(i).mul(term)
      i += 1
    }
    val ts = terms.toArray
    sortTerms(ts)
    new Poly(ts)
  }

  private def subTerm(poly: Poly, term: Term): Poly = {
    term match {
      case Variable(coff, arr) => addTerm(poly, Variable(-1 * coff, arr))
      case Num(n) => addTerm(poly, Num(-1 * n))
    }
  }

  private def addTerm(poly: Poly, term: Term): Poly = {
    val terms = ArrayBuffer.empty[Term]
    var found = false
    term match {
      case Variable(coff, arr) =>
        var i = 0
        while (i < poly.terms.length) {
          poly.terms(i) match {
            case Variable(c, a) if sameVariables(arr, a) => {
              terms += Variable(coff + c, arr)
              found = true
            }
            case _ => terms += poly.terms(i)
          }

          i += 1
        }

      case Num(n) =>
        var i = 0
        while (i < poly.terms.length) {
          poly.terms(i) match {
            case Variable(_, _) => terms += poly.terms(i)
            case Num(m) => {
              terms += Num(n + m)
              found = true
            }

          }
          i += 1
        }
    }
    var ts: Array[Term] = null
    if (!found) {
      terms += term
      ts = terms.toArray
      sortTerms(ts)
    } else {
      ts = terms.toArray
    }

    new Poly(ts)
  }

  private def sameVariables(a: Array[String], b: Array[String]): Boolean = {
    if (a.length != b.length) {
      false
    } else {
      var i = 0
      while (i < a.length && a(i) == b(i)) {
        i += 1
      }
      i == a.length
    }
  }

  private def combineTerms(terms: Array[Term]): Array[Term] = {
    sortTerms(terms)
    val buf = ArrayBuffer.empty[Term]
    var j = 0
    var i = 1
    while (i <= terms.length) {
      if (i == terms.length || !canCombine(terms(i - 1), terms(i))) {
        var res = terms(j)
        j += 1
        while (j < i) {
          res = combineTerm(res, terms(j))
          j += 1
        }

        res match {
          case Num(n) if n != 0 => {
            buf += res
          }
          case Variable(x, _) if x != 0 => {
            buf += res
          }
          case _ =>
        }


      }
      i += 1
    }
    buf.toArray
  }

  private def sortTerms(terms: Array[Term]): Unit = {
    Sorting.quickSort(terms)(Ordering.fromLessThan(Term.compare))
  }

  def canCombine(a: Term, b: Term): Boolean = {
    (a, b) match {
      case (Num(_), Num(_)) => true
      case (Variable(_, x), Variable(_, y)) =>
        sameVariables(x, y)
      case _ => false
    }
  }

  def combineTerm(a: Term, b: Term): Term = {
    (a, b) match {
      case (Num(x), Num(y)) => Num(x + y)
      case (Variable(x, a), Variable(y, _)) => Variable(x + y, a)
      case _ => null
    }

  }

  private def multipleVariables(a: Array[String], b: Array[String]): Array[String] = {
    val ss = ArrayBuffer.empty[String]
    ss ++= a
    ss ++= b
    val s = ss.toArray
    Sorting.quickSort(s)
    s
  }
}
