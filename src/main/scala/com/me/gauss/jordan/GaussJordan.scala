package codejam.gauss.jordan

/**
 * Created by senyuanwang on 15/5/28.
 */
trait GaussJordan {

  val EPS: Double = 1e-8

  type VEC = Array[Double]
  type MAT = Array[VEC]

  def swap(a: VEC, b: VEC): Unit = {
    for {
      i <- 0 until a.length
      x = a(i)
      y = b(i)
    } {
      a(i) = y
      b(i) = x
    }
  }

  def solve(a: MAT, b: VEC): Option[VEC] = {
    try {
      val n = a.length
      val c = Array.fill(n)(Array.fill(n + 1)(0.0))

      for {
        i <- 0 until n
        _ = {
          c(i)(n) = b(i)
        }
        j <- 0 until n
      } {
        c(i)(j) = a(i)(j)
      }

      for {
        i <- 0 until n
      } {
        var pivot = i
        for {
          j <- i until n
          if (c(j)(i).abs > c(pivot)(i).abs)
        } {
          pivot = j
        }

        swap(c(i), c(pivot))

        if (c(i)(i).abs < EPS) {
          val error = c.map(_.mkString(", ")).mkString("\n")
          throw new Exception("NO RESULT AT " + error)
        }

        for {
          j <- i + 1 to n
        } {
          c(i)(j) /= c(i)(i)
        }

        for {
          j <- 0 until n
          if (i != j)
          k <- i + 1 to n
        } {
          c(j)(k) -= c(j)(i) * c(i)(k)
        }
      }

      val ans =
        for {
          i <- 0 until n
        } yield c(i)(n)

      Some(ans.toArray)
    } catch {
      case e: Exception =>
        e.printStackTrace()
        None
    }
  }
}
