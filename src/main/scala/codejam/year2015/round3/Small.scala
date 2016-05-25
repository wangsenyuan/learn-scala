package codejam.year2015.round3

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/24/16.
  */
object Small extends App {

  case class Interval(a: Long, b: Long) {
    def intersect(that: Interval): Option[Interval] = {
      if (this.b < that.a || this.a > that.b) {
        None
      } else {
        Some(Interval(this.a max that.a, this.b min that.b))
      }
    }
  }

  case class Node(id: Int, s: Long, interval: Interval, var children: List[Node] = Nil) {
    def addChild(child: Node): Unit = {
      children = child :: children
    }

    def updateInterval(parentInterval: Interval): Option[Node] = {
      parentInterval.intersect(interval).map {
        x =>
          this.copy(
            interval = x,
            children = children.map(_.updateInterval(x)).filter(_.isDefined).map(_.get)
          )
      }
    }

    def flatten(): List[Node] = {
      this :: children.flatMap(_.flatten())
    }
  }

  def findInterval(root: Node): List[(Long, Int)] = {
    val copy = root.updateInterval(root.interval).get
    val nodes = copy.flatten()
    nodes.map(_.interval).flatMap(x => List((x.a, 1), (x.b, -1))).sortWith {
      (a, b) =>
        if (a._1 < b._1) {
          true
        } else if (a._1 > b._1) {
          false
        } else {
          a._2 > b._2
        }
    }
  }

  def maxSubSum(nums: List[Int]): Int = {
    def go(nums: List[Int], sum: Int, result: Int): Int =
      nums match {
        case Nil => result
        case h :: tail =>
          val nsum = (sum max 0) + h
          go(tail, nsum, nsum max result)
      }
    go(nums, 0, 0)
  }

  val t = StdIn.readInt()

  var i = 1
  while (i <= t) {
    val line1 = StdIn.readLine().split("\\s+").map(_.toLong)
    val n = line1(0)
    val d = line1(1)
    val line2 = StdIn.readLine().split("\\s+").map(_.toLong)
    val s = line2(0)
    val as = line2(1)
    val cs = line2(2)
    val rs = line2(3)
    val line3 = StdIn.readLine().split("\\s+").map(_.toLong)
    val m = line3(0)
    val am = line3(1)
    val cm = line3(2)
    val rm = line3(3)

    var nodes = Map[Int, Node]()
    nodes += (0 -> Node(0, s, Interval(s - d, s)))

    var j = 1
    var sj = s
    var mj = m
    while (j < n) {
      sj = (sj * as + cs) % rs
      nodes += (j -> Node(j, sj, Interval((sj - d) max 0, sj)))
      mj = (mj * am + cm) % rm
      nodes((mj % (j.toLong)).toInt).addChild(nodes(j))
      j += 1
    }

    val intervals = findInterval(nodes(0))

    val result = maxSubSum(intervals.map(_._2))

    println(s"Case #$i: $result")
    i += 1
  }
}
