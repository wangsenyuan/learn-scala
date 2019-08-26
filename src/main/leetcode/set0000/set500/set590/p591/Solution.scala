package set0000.set500.set590.p591

object Solution {
  val cdataBegin = "<![CDATA["
  val cdataEnd = "]]>";

  def isValid(code: String): Boolean = {
    var stack = List.empty[String]
    val n = code.length
    var hasToken = false
    var i = 0
    while (i < n) {
      if (code(i) == '<') {
        if(hasToken && stack.isEmpty) {
          return false
        }
        if (isCdata(code, i)) {
          val j = endOfCdata(code, i + cdataBegin.length)
          if (j < 0) {
            //can't find cdata end
            return false
          }
          i = j
          hasToken = true
        } else if (i == n - 1) {
          return false
        } else if (code(i + 1) == '/') {
          // end tag
          val j = findTagEndPos(code, i + 2)
          if (j < 0) {
            return false
          }
          val tagName = code.substring(i + 2, j)

          if (stack.isEmpty || stack.head != tagName) {
            return false
          }

          stack = stack.tail
          i = j + 1
        } else {
          // start tag
          val j = findTagEndPos(code, i + 1)
          if (j < 0) {
            return false
          }


          if (code(j - 1) != '/') {
            // a open tag
            val tagName = code.substring(i + 1, j)
            if(tagName.isEmpty || tagName.length > 9 || !tagName.forall(_.isUpper)) {
              return false
            }
            stack = tagName :: stack
          }

          i = j + 1
          hasToken = true
        }
      } else if (stack.isEmpty) {
        return false
      } else {
        i += 1
      }
    }
    return stack.isEmpty
  }

  private def findTagEndPos(str: String, start: Int): Int = {
    var i = start
    while (i < str.length && str(i) != '>') {
      i += 1
    }
    if (i < str.length) {
      i
    } else {
      -1
    }
  }

  private def isCdata(str: String, start: Int): Boolean = {
    var i = 0
    while (i < cdataBegin.length && start + i < str.length && cdataBegin(i) == str(i + start)) {
      i += 1
    }

    i == cdataBegin.length
  }

  private def endOfCdata(str: String, start: Int): Int = {
    var i = start
    while (i + 3 <= str.length) {
      if (str(i) == ']' && str(i + 1) == ']' && str(i + 2) == '>') {
        return i + 3;
      }
      i += 1
    }
    return -1
  }
}
