package set0000.set000.set010.p012

object Solution {
  val map = Map(1 -> "I", 4 -> "IV", 5 -> "V", 9 -> "IX", 10 -> "X", 40 -> "XL", 50 -> "L", 90 -> "XC", 100 -> "C", 400 -> "CD", 500 -> "D", 900 -> "CM", 1000 -> "M")

  def intToRoman(num: Int): String = {
    if (num >= 1000) {
      map(1000) * (num / 1000) + intToRoman(num % 1000)
    } else if (num >= 900) {
      map(900) + intToRoman(num - 900)
    } else if (num >= 500) {
      map(500) + intToRoman(num - 500)
    } else if (num >= 400) {
      map(400) + intToRoman(num - 400)
    } else if (num >= 100) {
      map(100) * (num / 100) + intToRoman(num % 100)
    } else if (num >= 90) {
      map(90) + intToRoman(num - 90)
    } else if (num >= 50) {
      map(50) + intToRoman(num - 50)
    } else if (num >= 40) {
      map(40) + intToRoman(num - 40)
    } else if (num >= 10) {
      map(10) * (num / 10) + intToRoman(num % 10)
    } else if (num == 9) {
      map(9)
    } else if (num >= 5) {
      map(5) + intToRoman(num - 5)
    } else if (num == 4) {
      map(4)
    } else if (num > 0) {
      map(1) * num
    } else {
      ""
    }
  }
}
