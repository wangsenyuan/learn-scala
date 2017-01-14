package codechef.easy.dragbool

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/01/2017.
  */
object Main {

  case class Warrior(chakra: Int, level: Int)

  class WarriorGroup(warriors: Array[Warrior]) {
    val group = warriors.groupBy(_.level).mapValues(_.map(_.chakra).sum)

    def getGroupChakra(level: Int): Int = group(level)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = firstLine(0)
      val m = firstLine(1)

      val soints = Array.fill[Warrior](n)(null)
      val sofloats = Array.fill[Warrior](m)(null)
      var i = 0
      var levels = Set.empty[Int]
      while (i < n) {
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        soints(i) = Warrior(line(0), line(1))

        levels += soints(i).level

        i += 1
      }

      i = 0
      while (i < m) {
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        sofloats(i) = Warrior(line(0), line(1))
        i += 1
      }


      val groupSoints = new WarriorGroup(soints)
      val groupSofloats = new WarriorGroup(sofloats)

      var res = 0
      for {
        level <- levels
        a = groupSoints.getGroupChakra(level)
        b = groupSofloats.getGroupChakra(level)
        if a < b
      } {
        res += b - a
      }

      println(res)

      t -= 1
    }
  }
}
