package set0000.set800.set810.p811

import scala.collection.mutable

object Solution {
  def subdomainVisits(cpdomains: Array[String]): List[String] = {
    val count = mutable.Map.empty[String, Int].withDefaultValue(0)

    cpdomains.foreach(domain => {
      val ss = domain.split("\\s+")
      val c = ss(0).toInt

      val s = ss(1)

      count(s) += c
      var i = 0
      while (i < s.length) {
        if (s(i) == '.') {
          count(s.substring(i + 1)) += c
        }
        i += 1
      }
    })

    count.toList.map(x => s"${x._2} ${x._1}")
  }
}
