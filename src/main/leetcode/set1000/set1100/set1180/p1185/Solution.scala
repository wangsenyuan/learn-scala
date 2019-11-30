package set1000.set1100.set1180.p1185

object Solution {
  def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
    val cal = java.util.Calendar.getInstance()
    cal.set(java.util.Calendar.YEAR, year)
    cal.set(java.util.Calendar.MONTH, month - 1)
    cal.set(java.util.Calendar.DAY_OF_MONTH, day)

    val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    val i = cal.get(java.util.Calendar.DAY_OF_WEEK)
    days(i - 1)
  }
}
