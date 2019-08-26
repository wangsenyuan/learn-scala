package set0000.set100.set130.p134

object Solution {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    val n = gas.length
    var i = 0
    var can = false
    while (i < n && !can) {
      var cap = gas(i) - cost(i)
      var j = (i + 1) % n
      while (cap >= 0 && j != i) {
        cap += gas(j) - cost(j)
        j = (j + 1) % n
      }
      can = cap >= 0
      if (!can) {
        if (j > i) {
          i = j
        } else {
          i = n
        }
      }
    }
    if (can) {
      i
    } else {
      -1
    }
  }
}
