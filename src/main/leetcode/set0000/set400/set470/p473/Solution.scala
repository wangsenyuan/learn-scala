package set0000.set400.set470.p473

object Solution {

  def joinAsKey(arr: Array[Int], n: Int): String =  {
    arr.take(n).mkString("-")
  }

  def makesquare(nums: Array[Int]): Boolean = {
    val sum = nums.sum


    if(sum == 0 || sum % 4 != 0) {
      false
    } else {
      val side = sum / 4
      val n = nums.length
      val vis = Array.ofDim[Boolean](1 << n)

//      val arr = Array.fill(4)(0)

      def go(mask: Int, sa: Int, cnt: Int, all: Int): Boolean = {
        if(cnt == 3) {
          true
        } else if(sa > side) {
          false
        } else if(sa < side){
          if(vis(all)) {
            false
          } else {
            vis(all) = true
            var can = false
            var i = 0
            while(i < n && !can) {
              if((mask & (1 << i)) == 0) {
                can = go(mask | (1 << i), sa + nums(i), cnt, all | (1 << i))
              }
              i += 1
            }
            can
          }
        } else {
          go(mask, 0, cnt + 1, all)
        }
      }

      go(0, 0, 0, 0)
    }
  }
}
