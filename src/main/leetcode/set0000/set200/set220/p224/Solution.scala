package set0000.set200.set220.p224

object Solution {
  def calculate(s: String): Int = {
    val n = s.length
    val m = s.count(_ == '(')
    val stack = Array.fill(m + 1)(1)
    var p = 1

    var sign = 1
    var ans = 0
    var i = 0
    while (i < n) {
      if (s(i) == ' ') {

      } else if (s(i) == '(') {
        stack(p) = sign
        p += 1
      } else if (s(i) == ')') {
        sign = stack(p - 1)
        p -= 1
      } else if (s(i) == '+') {
        //sign no change
        sign = stack(p - 1)
      } else if (s(i) == '-') {
        sign = -1 * stack(p - 1)
      } else {
        var num = 0
        var j = i
        while (j < n && isDigit(s(j))) {
          num = num * 10 + (s(j) - '0')
          j += 1
        }
        ans += sign * num
        i = j - 1
      }
      i += 1
    }

    ans
  }

  private def isDigit(c: Char) = c >= '0' && c <= '9'

  private def cal(s: String): Int = {
    var nums = List.empty[Int]
    var ops = List.empty[Char]
    val n = s.length
    var j = 0
    var i = 0
    while (i <= n) {
      if (i == n || s(i) == '+' || s(i) == '-') {
        val num = process(s.substring(j, i))
        if (nums.isEmpty) {
          nums = num :: nums
          //          ops = s(i) :: ops
        } else {
          val sum = operate(nums.head, num, ops.head)
          nums = sum :: nums.tail
          ops = ops.tail
        }
        if (i < n) {
          ops = s(i) :: ops
        }
        j = i + 1
      } else if (s(i) == '(') {
        val k = pair(s, i)
        j = i
        i = k
      }

      i += 1
    }
    nums.head
  }

  private def operate(a: Int, b: Int, c: Char): Int = {
    if (c == '+') {
      a + b
    } else {
      a - b
    }
  }

  private def process(s: String): Int = {
    if (s(0) == '(') {
      cal(s.substring(1, s.length - 1))
    } else {
      s.toInt
    }
  }

  private def pair(s: String, start: Int): Int = {
    var level = 0
    var i = start
    do {
      if (s(i) == '(') {
        level += 1
      } else if (s(i) == ')') {
        level -= 1
      }
      i += 1
    } while (level > 0)

    i - 1
  }
}
