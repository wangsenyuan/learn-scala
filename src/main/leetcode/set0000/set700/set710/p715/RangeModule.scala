package set0000.set700.set710.p715

class RangeModule() {
  val map = new java.util.TreeMap[Int, Int]()

  def addRange(left: Int, right: Int) {
    val floor = map.floorEntry(left)
    var start = left
    if(floor != null && floor.getValue >= left) {
      start = floor.getKey
    }
    var end = right
    var ceil = map.ceilingEntry(start)
    while(ceil != null && ceil.getKey <= right) {
      end = end max ceil.getValue
      map.remove(ceil.getKey)
      ceil = map.ceilingEntry(ceil.getKey)
    }

    map.put(start, end)
  }

  def queryRange(left: Int, right: Int): Boolean = {
    val floor = map.floorEntry(left)
    floor != null && floor.getValue >= right
  }

  def removeRange(left: Int, right: Int) {
    val floor = map.floorEntry(left)
    if(floor != null && floor.getValue >= left) {
      if(floor.getKey < left) {
        map.put(floor.getKey, left)
      }

      if(floor.getValue > right) {
        map.put(right, floor.getValue)
      }
    }

    var ceil = map.ceilingEntry(left)
    while(ceil != null && right > ceil.getKey) {
      map.remove(ceil.getKey)
      if(right < ceil.getValue) {
        addRange(right, ceil.getValue)
      }
      ceil = map.ceilingEntry(ceil.getKey)
    }
  }

}
