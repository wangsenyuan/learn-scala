package set0000.set900.set900.p905

object Solution {
  def sortArrayByParity(A: Array[Int]): Array[Int] = {
    var i = 0
    var j = A.length - 1

    while (i < j) {
      if ((A(i) & 1) == 0) {
        i += 1
      } else if ((A(j) & 1) == 1) {
        j -= 1
      } else {
        val x = A(i)
        A(i) = A(j)
        A(j) = x
        i += 1
        j -= 1
      }
    }
    A
  }
}
