package set1000.set1200.set1280.p1286

object Solution {

  class CombinationIterator(_characters: String, _combinationLength: Int) {
    val arr = Array.ofDim[Int](_combinationLength + 1)
    var cur = _combinationLength - 1

    for {
      i <- 0 until _combinationLength
    } {
      arr(i) = i
    }

    arr(_combinationLength) = _characters.length

    def next(): String = {
      val res = arr.init.map(i => _characters(i)).mkString("")

      while (cur >= 0 && arr(cur) + 1 == arr(cur + 1)) {
        cur -= 1
      }

      if (cur >= 0) {
        arr(cur) += 1
        var i = cur + 1
        while (i < _combinationLength) {
          arr(i) = arr(i - 1) + 1
          i += 1
        }
        cur = i - 1
      }

      res
    }

    def hasNext(): Boolean = cur >= 0

  }

}
