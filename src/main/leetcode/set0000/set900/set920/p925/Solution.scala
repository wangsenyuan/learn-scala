package set0000.set900.set920.p925

object Solution {
  def isLongPressedName(name: String, typed: String): Boolean = {
    var i = 0
    var j = 0
    while (i < name.length && j < typed.length) {
      if (name(i) == typed(j)) {
        i += 1
        j += 1
      } else if (i > 0 && name(i - 1) == typed(j)) {
        j += 1
      } else {
        return false
      }
    }

    if (i < name.length) {
      false
    } else {
      while (j < typed.length && name(i - 1) == typed(j)) {
        j += 1
      }
      j == typed.length
    }
  }
}
