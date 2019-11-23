package set1000.set1100.set1150.p1154

import java.time.LocalDate

object Solution {
  def dayOfYear(date: String): Int = {
    val localDate = LocalDate.parse(date)
    localDate.getDayOfYear + 1
  }
}
