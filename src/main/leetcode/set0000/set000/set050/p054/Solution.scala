package set0000.set000.set050.p054

object Solution {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    val m = matrix.length
    if (m == 0) {
      Nil
    } else {
      val n = matrix(0).length
      if (n == 0) {
        Nil
      } else {

        def right(rect: Rect, res: Vector[Int]): Vector[Int] = {
          if (rect.width == 0) {
            res
          } else {
            val row = for {
              j <- rect.b to rect.d
            } yield matrix(rect.a)(j)

            down(rect.down, res ++ row)
          }
        }

        def down(rect: Rect, res: Vector[Int]): Vector[Int] = {
          if (rect.height == 0) {
            res
          } else {
            val col = for {
              i <- rect.a to rect.c
            } yield matrix(i)(rect.d)

            left(rect.left, res ++ col)
          }
        }

        def left(rect: Rect, res: Vector[Int]): Vector[Int] = {
          if (rect.width == 0) {
            res
          } else {
            val row = for {
              j <- rect.d to rect.b by -1
            } yield matrix(rect.c)(j)
            up(rect.up, res ++ row)
          }
        }

        def up(rect: Rect, res: Vector[Int]): Vector[Int] = {
          if (rect.height == 0) {
            res
          } else {
            val col = for {
              i <- rect.c to rect.a by -1
            } yield matrix(i)(rect.b)
            right(rect.right, res ++ col)
          }
        }

        val res = right(Rect(0, 0, m - 1, n - 1), Vector())

        res.toList
      }
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
