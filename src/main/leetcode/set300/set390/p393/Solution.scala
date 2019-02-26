package set300.set390.p393

object Solution {

  def validUtf8(data: Array[Int]): Boolean = {
    val n = data.length

    def go(i: Int): Boolean = {
      if (i == n) {
        true
      } else {
        val cur = data(i)
        if ((cur & 128) != 128) {
          //first digit is 0
          go(i + 1)
        } else if ((cur & 192) != 192) {
          //second digit is 0
          false
        } else if ((cur & 224) != 224) {
          //third digit is 0
          if (i >= n - 1 || !validRem(data(i + 1))) {
            false
          } else {
            go(i + 2)
          }
        } else if ((cur & 240) != 240) {
          //forth digit is 0
          if (i >= n - 2 || !validRem(data(i + 1)) || !validRem(data(i + 2))) {
            false
          } else {
            go(i + 3)
          }
        } else if ((cur & 248) != 248) {
          //fifth digit is 0
          if (i >= n - 3 || !validRem(data(i + 1)) || !validRem(data(i + 2)) || !validRem(data(i + 3))) {
            false
          } else {
            go(i + 4)
          }
        } else {
          false
        }
      }
    }

    go(0)
  }

  private def validRem(num: Int): Boolean = {
    (num & 128) == 128 && (num & 192) != 192
  }
}
