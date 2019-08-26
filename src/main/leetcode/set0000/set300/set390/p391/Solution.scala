package set0000.set300.set390.p391

object Solution {
  def isRectangleCover(rectangles: Array[Array[Int]]): Boolean = {
    if(hasOverlap(rectangles)) {
      false
    } else {
      val rec = coverRect(rectangles)

      area(rec) == rectangles.map(area).sum
    }
  }

  private def hasOverlap(rects: Array[Array[Int]]): Boolean = {
    val n = rects.length
    var flag = false
    var i = 0
    while(i < n - 1 && !flag) {
      var j = i + 1
      while(j < n && !flag) {
        flag = overlap(rects(i), rects(j))
        j += 1
      }

      i += 1
    }

    flag
  }

  private def overlap(a: Array[Int], b: Array[Int]): Boolean = {
    if(a(2) <= b(0) || a(3) <= b(1)) {
      false
    } else if(b(2) <= a(0) || b(3) <= a(1)) {
      false
    } else {
      true
    }
  }

  private def coverRect(rects: Array[Array[Int]]): Array[Int] = {
    val res = Array(Int.MaxValue, Int.MaxValue, Int.MinValue, Int.MinValue)

    rects.foreach(rect => {
      res(0) = res(0) min rect(0)
      res(1) = res(1) min rect(1)
      res(2) = res(2) max rect(2)
      res(3) = res(3) max rect(3)
    })

    res
  }

  private def area(rect: Array[Int]): Int = {
    (rect(2) - rect(0)) * (rect(3) - rect(1))
  }
}
