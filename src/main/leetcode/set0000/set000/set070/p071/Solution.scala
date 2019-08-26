package set0000.set000.set070.p071

object Solution {

  def simplifyPath(path: String): String = {
    var stack = List.empty[String]
    for {
      tk <- path.split("/")
    } {
      tk match {
        case "." | "" =>
        case ".." if stack.isEmpty =>
        case ".." => stack = stack.tail
        case other => stack = other :: stack
      }
    }
    "/" + (stack.reverse.mkString("/"))
  }

  def simplifyPath1(path: String): String = {
    var stack = List.empty[String]

    val n = path.length
    var j = 0

    while (j < n && path(j) == '/') {
      j += 1
    }
    var i = j
    while (i <= n) {
      if (i == n || path(i) == '/') {
        if (j < i) {
          val tk = path.substring(j, i)
          if (tk == ".") {
            //ignore it
          } else if (tk == "..") {
            if (!stack.isEmpty) {
              stack = stack.tail
            }
          } else {
            stack = tk :: stack
          }
        }
        j = i + 1
      }
      i += 1
    }
    stack = stack.reverse

    "/" + stack.mkString("/")
  }
}
