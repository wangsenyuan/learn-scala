package set0000.set800.set850.p850

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {

  class Tree(xs: Array[Int]) {

    class Node(start: Int, end: Int) {
      var left: Node = null
      var right: Node = null
      var count = 0
      var total = 0L

      def getMid() = start + (end - start) / 2

      def getLeftNode() = {
        if (left == null) {
          left = new Node(start, getMid())
        }
        left
      }

      def getRightNode() = {
        if (right == null) {
          right = new Node(getMid(), end)
        }
        right
      }

      def update(i: Int, j: Int, v: Int): Long = {
        if (i >= j) {
          0
        } else {
          if (i == start && j == end) {
            count += v
          } else {
            getLeftNode().update(i, getMid() min j, v)
            getRightNode().update(getMid() max i, j, v)

          }
          if (count > 0) {
            total = xs(end) - xs(start)
          } else {
            total = getLeftNode().total + getRightNode().total
          }
          total
        }
      }
    }

    val root = new Node(0, xs.length - 1)

    def update(i: Int, j: Int, v: Int): Long = {
      root.update(i, j, v)
    }

  }


  def rectangleArea(rectangles: Array[Array[Int]]): Int = {
    val n = rectangles.length
    val events = Array.ofDim[Array[Int]](2 * n)
    val xs = mutable.Set.empty[Int]
    val OPEN = 1
    val CLOSE = -1

    for {
      i <- 0 until n
      rect = rectangles(i)
    } {
      events(2 * i) = Array(rect(1), OPEN, rect(0), rect(2))
      events(2 * i + 1) = Array(rect(3), CLOSE, rect(0), rect(2))
      xs += rect(0)
      xs += rect(2)
    }

    val arr = xs.toArray
    Sorting.quickSort(arr)

    val xi = mutable.Map.empty[Int, Int]
    (0 until arr.length).foreach(i => xi(arr(i)) = i)

    Sorting.quickSort(events)(Ordering.fromLessThan((a, b) => a(0) < b(0)))

    val tree = new Tree(arr)
    var res = 0L
    var curXSum = 0L
    var curY = events(0)(0)
    for {
      event <- events
    } {
      val y = event(0)
      val tp = event(1)
      val x0 = event(2)
      val x1 = event(3)
      res += curXSum * (y - curY)

      curXSum = tree.update(xi(x0), xi(x1), tp)

      curY = y
    }

    (res % 1000000007).toInt
  }

  def rectangleArea2(rectangles: Array[Array[Int]]): Int = {
    val n = rectangles.length
    val events = Array.ofDim[Array[Int]](2 * n)

    val OPEN = 0
    val CLOSE = 1

    for {
      i <- 0 until n
      rect = rectangles(i)
    } {
      events(2 * i) = Array(rect(1), OPEN, rect(0), rect(2))
      events(2 * i + 1) = Array(rect(3), CLOSE, rect(0), rect(2))
    }

    Sorting.quickSort(events)(Ordering.fromLessThan((a, b) => a(0) < b(0)))

    var active = ArrayBuffer.empty[Array[Int]]

    var curY = events(0)(0)

    var res = 0L

    for {
      event <- events
    } {
      val y = event(0)
      val tp = event(1)
      val x1 = event(2)
      val x2 = event(3)
      var len = 0L
      var curX = -1
      for {
        seg <- active
      } {
        val x0 = seg(0)
        val x1 = seg(1)
        curX = curX max x0
        len += (x1 - curX) max 0
        curX = curX max x1
      }

      res += len * (y - curY)

      if (tp == OPEN) {
        active += Array(x1, x2)
        active = active.sortWith((a, b) => a(0) < b(0))
      } else {
        var j = -1
        var i = 0
        while (i < active.length && j < 0) {
          if (active(i)(0) == x1 && active(i)(1) == x2) {
            j = i
          }
          i += 1
        }
        active.remove(j)
      }

      curY = y
    }

    (res % 1000000007).toInt
  }

  def rectangleArea1(rectangles: Array[Array[Int]]): Int = {
    val xset = mutable.Set.empty[Int]
    val yset = mutable.Set.empty[Int]

    rectangles.foreach(rec => {
      xset += rec(0)
      xset += rec(2)
      yset += rec(1)
      yset += rec(3)
    })

    val xarr = xset.toArray
    val yarr = yset.toArray

    Sorting.quickSort(xarr)
    Sorting.quickSort(yarr)

    val xmap = mutable.Map.empty[Int, Int]
    (0 until xarr.length).map(i => xmap += xarr(i) -> i)
    val ymap = mutable.Map.empty[Int, Int]
    (0 until yarr.length).map(i => ymap += yarr(i) -> i)

    val grid = Array.ofDim[Boolean](xmap.size, ymap.size)

    rectangles.foreach(rec => {
      val x0 = xmap(rec(0))
      val x1 = xmap(rec(2))
      val y0 = ymap(rec(1))
      val y1 = ymap(rec(3))

      for {
        x <- x0 until x1
        y <- y0 until y1
      } {
        grid(x)(y) = true
      }
    })

    var res = 0L

    for {
      x <- 0 until xmap.size
      y <- 0 until ymap.size
      if grid(x)(y)
    } {
      val w = xarr(x + 1) - xarr(x)
      val h = yarr(y + 1) - yarr(y)
      res += w.toLong * h.toLong
    }

    (res % 1000000007).toInt
  }
}
