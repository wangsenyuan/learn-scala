package set0000.set600.set600.p609

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {
  def findDuplicate(paths: Array[String]): List[List[String]] = {
    val map = mutable.Map.empty[String, ListBuffer[String]].withDefault(_ => ListBuffer.empty[String])

    for {
      path <- paths
    } {
      process(path, map)
    }

    val res = ListBuffer.empty[List[String]]
    for {
      (_, v) <- map
      if(v.size > 1)
    } {
      res.append(v.toList)
    }

    res.toList
  }

  private def process(str: String, map: mutable.Map[String, ListBuffer[String]]): Unit = {
    val ss = str.split(" ")
    val dir = ss(0)
    var i = 1
    while (i < ss.length) {
      val file = ss(i)

      val x = file.indexOf('(')
      val y = file.length - 1
      val name = file.substring(0, x)
      val content = file.substring(x + 1, y)

      map(content) = map(content) :+ (dir + "/" + name)

      i += 1
    }
  }
}
