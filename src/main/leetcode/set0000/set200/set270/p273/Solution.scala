package set0000.set200.set270.p273

object Solution {

  val nums = Array("Zero", "One", "Two", "Three", "Four", "Five",
    "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
    "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
  val tens = Array("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

  def numberToWords(num: Int): String = {
    if (num == 0) {
      "Zero"
    } else {
      val s = num.toString
      val n = s.length
      val r = n % 3
      val ss = if (r == 0) {
        s
      } else {
        ("0" * (3 - r)) + s
      }

      val gg = ss.grouped(3).toArray.reverse

      val g = gg.map(read)
      val f = Array("", " Thousand", " Million", " Billion")

      val gf = g.zip(f).map(x => if (x._1 != "") x._1 + x._2 else "").filterNot(_.isEmpty).reverse

      gf.mkString(" ").trim
    }
  }

  private def read(s: String): String = {
    val num = s.toInt

    def one(num: Int): String = {
      if (num > 0) {
        " " + nums(num)
      } else {
        ""
      }
    }

    def ten(num: Int): String = {
      if (num < 20) {
        one(num)
      } else {
        " " + tens(num / 10) + one(num % 10)
      }
    }

    def hundred(num: Int): String = {
      if (num < 100) {
        ten(num)
      } else {
        nums(num / 100) + " Hundred" + ten(num % 100)
      }
    }

    if (num == 0) {
      ""
    } else {
      hundred(num).trim
    }
  }
}
