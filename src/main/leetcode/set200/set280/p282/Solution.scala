package set200.set280.p282

object Solution {
  def addOperators(num: String, target: Int): List[String] = {
    val T = target.toLong

    def go(left: String, exp: String, stack: List[Long], op: Option[Char]): List[String] = {
      if (left.isEmpty) {
        val ss = addOrSub(exp, stack, 0, op)
        if (ss.size == 2 && ss.last == T) {
          List(exp)
        } else {
          Nil
        }
      } else {
        var res = List.empty[String]
        var cur = 0L
        var i = 0
        while (i < left.length && (i == 0 || left.head != '0')) {
          cur = cur * 10 + left(i) - '0'
          //try to put a + in front of current
          res ++= go(left.substring(i + 1), exp + "+" + left.substring(0, i + 1), addOrSub(exp, stack, cur, op), Some('+'))
          res ++= go(left.substring(i + 1), exp + "-" + left.substring(0, i + 1), addOrSub(exp, stack, cur, op), Some('-'))
          //try to put a * in front of current
          res ++= go(left.substring(i + 1), exp + "*" + left.substring(0, i + 1), mul(exp, stack, cur), op)

          i += 1
        }


        res
      }
    }

    var res = List.empty[String]
    var cur = 0L
    var i = 0
    while (i < num.length && (i == 0 || num.head != '0')) {
      cur = cur * 10 + num(i) - '0'
      res ++= go(num.substring(i + 1), num.substring(0, i + 1), List(cur), None)
      i += 1
    }
    res
  }

  private def mul(exp: String, stack: List[Long], cur: Long): List[Long] = {
    //stack must not be empty
    val a = stack.head
    (a * cur) :: stack.tail
  }

  private def addOrSub(exp: String, nums: List[Long], cur: Long, op: Option[Char]): List[Long] = {
    op match {
      case None => cur :: nums
      case Some(o) =>
        val a = nums.tail.head
        val b = nums.head
        if (o == '+') {
          cur :: (a + b) :: nums.tail.tail
        } else {
          cur :: (a - b) :: nums.tail.tail
        }
    }
  }
}
