package set200.set220.p224

object Solution {
  def calculate(s: String): Int = {
    cal(s.replace(" ", ""))
  }

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
