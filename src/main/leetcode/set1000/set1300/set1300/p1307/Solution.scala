package set1000.set1300.set1300.p1307

import scala.collection.mutable

object Solution {
  def isSolvable(words: Array[String], result: String): Boolean = {
    val canNotBeZeros = mutable.Set.empty[Char]

    words.foreach(word => {
      if (word.length > 1) {
        canNotBeZeros += word(0)
      }
    })

    if (result.length > 1) {
      canNotBeZeros += result(0)
    }

    for {
      i <- 0 until words.length
    } {
      words(i) = words(i).reverse
    }

    val res = result.reverse

    val assign = Array.fill(26)(-1)

    val n = res.length

    def dfs(i: Int, j: Int, carry: Int, flag: Int): Boolean = {
      if (i == n) {
        carry == 0
      } else {
        if (j == words.length) {
          var sum = carry
          for {
            word <- words
            if (word.length > i)
          } {
            sum += assign(word(i) - 'A')
          }
          val r = sum % 10
          val x = res(i) - 'A'

          if (assign(x) >= 0) {
            assign(x) == r && dfs(i + 1, 0, sum / 10, flag)
          } else {
            if (i == n - 1 && r == 0 && canNotBeZeros(res(i))) {
              false
            } else if ((flag & (1 << r)) != 0) {
              false
            } else {
              assign(x) = r
              val ans = dfs(i + 1, 0, sum / 10, flag | (1 << r))
              assign(x) = -1
              ans
            }
          }
        } else {
          if (words(j).length <= i) {
            dfs(i, j + 1, carry, flag)
          } else if (assign(words(j)(i) - 'A') >= 0) {
            dfs(i, j + 1, carry, flag)
          } else {
            var num = 0
            if (canNotBeZeros(words(j)(i))) {
              num += 1
            }
            val x = words(j)(i) - 'A'

            var can = false
            while (num < 10 && !can) {
              if ((flag & (1 << num)) == 0) {
                assign(x) = num
                can = dfs(i, j + 1, carry, flag | (1 << num))
                assign(x) = -1
              }
              num += 1
            }
            can
          }
        }
      }
    }

    dfs(0, 0, 0, 0)
  }

}
