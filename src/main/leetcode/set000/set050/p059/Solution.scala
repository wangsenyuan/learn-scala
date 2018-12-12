package set000.set050.p059

object Solution {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    if (n <= 0) {
      Array()
    } else {
      val res = Array.fill(n, n)(0)

      def right(rect: Rect, num: Int): Unit = {
        if (rect.width > 0) {
          var i = 0
          while (i < rect.width) {
            res(rect.a)(rect.b + i) = num + i
            i += 1
          }
          down(rect.down, num + rect.width)
        }
      }

      def down(rect: Rect, num: Int): Unit = {
        if (rect.height > 0) {
          var i = 0
          while (i < rect.height) {
            res(rect.a + i)(rect.d) = num + i
            i += 1
          }

          left(rect.left, num + rect.height)
        }
      }

      def left(rect: Rect, num: Int): Unit = {
        if (rect.width > 0) {
          var i = 0
          while (i < rect.width) {
            res(rect.c)(rect.d - i) = num + i
            i += 1
          }

          up(rect.up, num + rect.width)
        }
      }

      def up(rect: Rect, num: Int): Unit = {
        if (rect.height > 0) {
          var i = 0
          while (i < rect.height) {
            res(rect.c - i)(rect.b) = num + i
            i += 1
          }

          right(rect.right, num + rect.height)
        }
      }

      right(Rect(0, 0, n - 1, n - 1), 1)

      res
    }
  }

  case class Rect(a: Int, b: Int, c: Int, d: Int) {
    def width = d - b + 1

    def height = c - a + 1

    def down: Rect = {
      Rect(a + 1, b, c, d)
    }

    def left: Rect = {
      Rect(a, b, c, d - 1)
    }

    def up: Rect = {
      Rect(a, b, c - 1, d)
    }

    def right: Rect = {
      Rect(a, b + 1, c, d)
    }
  }

}
