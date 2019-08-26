package set0000.set800.set830.p838

object Solution {
  def pushDominoes(dominoes: String): String = {
    val n = dominoes.length
    val dp = Array.ofDim[Int](n)
    val stack = Array.ofDim[Int](n)
    var p = 0
    var i = 0
    while(i < n) {
      dp(i) = -1
      if(dominoes(i) == 'L') {
        while(p > 0) {
          dp(stack(p - 1)) = i
          p -= 1
        }
      } else if(dominoes(i) == '.') {
        stack(p) = i
        p += 1
      } else if(dominoes(i) == 'R') {
        p = 0
      }

      i += 1
    }

    val fp = Array.ofDim[Int](n)
    p = 0
    i = n - 1
    while(i >= 0) {
      fp(i) = -1
      if(dominoes(i) == 'R') {
        while(p > 0) {
          fp(stack(p - 1)) = i
          p -= 1
        }
      } else if(dominoes(i) == '.') {
        stack(p) = i
        p += 1
      } else if(dominoes(i) == 'L') {
        p = 0
      }

      i -= 1
    }

    val res = new StringBuilder
    i = 0
    while(i < n) {
      if(dominoes(i) == 'L') {
        res += 'L'
      } else if(dominoes(i) == 'R') {
        res += 'R'
      } else {
        val a = fp(i)
        val b = dp(i)
        if(a < 0 && b < 0) {
          res += '.'
        } else if(a < 0) {
          res += 'L'
        } else if(b < 0) {
          res += 'R'
        } else if(i - a < b - i) {
          res += 'R'
        } else if(i - a > b - i) {
          res += 'L'
        } else {
          res += '.'
        }
      }
      i += 1
    }

    res.toString()
  }
}
