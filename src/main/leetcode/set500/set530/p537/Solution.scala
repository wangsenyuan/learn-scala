package set500.set530.p537

object Solution {
  def complexNumberMultiply(a: String, b: String): String = {
    val x = Complex(a)
    val y = Complex(b)
    val z = x.multiply(y)
    z.toString
  }

  case class Complex(a: Int, b: Int) {
    def multiply(that: Complex): Complex = {
      val x = a * that.a - b * that.b
      val y = a * that.b + b * that.a
      Complex(x, y)
    }

    override def toString: String = {
      f"$a+${b}i"
    }
  }

  object Complex {
    def apply(s: String): Complex = {
      val ss = s.split("\\+")
      val a = ss(0).toInt
      val b = ss(1).substring(0, ss(1).length - 1).toInt
      Complex(a, b)
    }
  }
}
