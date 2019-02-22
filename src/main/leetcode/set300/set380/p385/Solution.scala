package set300.set380.p385

/**
  * // This is the interface that allows for creating nested lists.
  * // You should not implement it, or speculate about its implementation
  **/
class NestedInteger {
  var value = Option.empty[Int]
  var list = Option.empty[NestedInteger]

  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  def isInteger: Boolean = value.isDefined

  // Return the single integer that this NestedInteger holds, if it holds a single integer
  def getInteger: Int = value.get

  // Set this NestedInteger to hold a single integer.
  def setInteger(i: Int) = {
    value = Some(i)
  }

  // Return the nested list that this NestedInteger holds, if it holds a nested list
  def getList: NestedInteger = {
    list.getOrElse(null)
  }

  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  def add(ni: NestedInteger) = {
    list = Some(ni)
  }
}

object Solution {
  def deserialize(s: String): NestedInteger = {
    val n = s.length
    var p = 0

    def buildList(): NestedInteger = {
      p += 1
      val res = new NestedInteger

      while (p < n && s(p) != ']') {
        if (s(p) == '[') {
          res.add(buildList())
        } else {
          res.add(buildInteger())
        }
      }
      //skip ]
      p += 1
      if (p < n && s(p) == ',') {
        p += 1
      }
      res
    }


    def buildInteger(): NestedInteger = {
      var sign = 1
      if (s(p) == '-') {
        sign = -1
        p += 1
      }
      var num = 0
      while (p < n && s(p).isDigit) {
        num = num * 10 + s(p) - '0'
        p += 1
      }
      if (p < n && s(p) == ',') {
        p += 1
      }
      val res = new NestedInteger
      res.setInteger(sign * num)
      res
    }

    if (s.isEmpty) {
      null
    } else if (s(0) == '[') {
      buildList()
    } else {
      buildInteger()
    }
  }
}
