package set700.set720.p722

import scala.collection.mutable.ListBuffer

object Solution {
  def removeComments(source: Array[String]): List[String] = {
    val res = ListBuffer.empty[String]

    var open = false
    var open2 = false
    val buf = new StringBuilder()

    var i = 0
    while (i < source.length) {
      open = false
      if (source(i).length > 0) {
        var j = 0
        while (j < source(i).length) {
          if (source(i)(j) == '/' && j + 1 < source(i).length && source(i)(j + 1) == '/') {
            if (!open && !open2) {
              open = true
              j += 1
            }
          } else if (source(i)(j) == '/' && j + 1 < source(i).length && source(i)(j + 1) == '*') {
            if (!open && !open2) {
              open2 = true
              j += 1
            }
          } else if (source(i)(j) == '*' && j + 1 < source(i).length && source(i)(j + 1) == '/') {
            if (open2) {
              open2 = false
              j += 1
            } else if(!open) {
              buf.append(source(i)(j))
            }
          } else {
            if(!open && !open2) {
              buf.append(source(i)(j))
            }
          }

          j += 1
        }
        if(!open2 && buf.length > 0) {
          res += buf.toString()
          buf.clear()
        }
      }

      i += 1
    }

    res.toList
  }
}
