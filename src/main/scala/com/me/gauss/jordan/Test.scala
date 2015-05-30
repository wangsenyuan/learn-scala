package codejam.gauss.jordan

/**
 * Created by senyuanwang on 15/5/28.
 */
object Test extends App with GaussJordan {

  val a = Array.fill(3)(Array.fill(3)(0.0))
  val b = Array.fill(3)(0.0)
  /**
   * x - 2y + 3z = 6
   * 4x - 5y + 6z = 12
   * 7x - 8y + 10z = 21
   */

  a(0)(0) = 1
  a(0)(1) = -2
  a(0)(2) = 3
  b(0) = 6

  a(1)(0) = 4
  a(1)(1) = -5
  a(1)(2) = 6
  b(1) = 12

  a(2)(0) = 7
  a(2)(1) = -8
  a(2)(2) = 10
  b(2) = 21

  val c = solve(a, b)

  println(c.get.mkString(", "))
}
