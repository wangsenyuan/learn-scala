package set0000.set900.set930.p937

import scala.util.Sorting

object Solution {

  case class Log(log: String, id: String, key: String, digit: Boolean)

  private def parseAsLog(s: String): Log = {
    val ss = s.split("\\s+")
    val id = ss(0)
    val key = s.substring(id.length + 1)
    val digit = ss(1).forall(x => x >= '0' && x <= '9')
    Log(s, id, key, digit)
  }

  def reorderLogFiles(logs: Array[String]): Array[String] = {
    val ls = logs.map(parseAsLog)
    val (xs, ys) = ls.partition(log => log.digit)
    Sorting.quickSort(ys)(Ordering.fromLessThan((a, b) => a.key < b.key || (a.key == b.key && a.id < b.id)))
    (ys ++ xs).map(_.log)
  }
}
