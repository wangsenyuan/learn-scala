package set600.set690.p691

object Solution {
  def minStickers(stickers: Array[String], target: String): Int = {
    val n = target.length

    val N = 1 << n

    val dp = Array.fill(N)(Int.MaxValue)
    dp(0) = 0

    val m = stickers.length

    val ts = target.toCharArray.sorted
    val ss = stickers.map(_.toCharArray.sorted)

    var state = 0
    while(state < N) {
      if(dp(state) < Int.MaxValue) {
        var i = 0
        while(i < m) {
          val next = useStick(state, ss(i), ts)

          dp(next) = dp(next) min (dp(state) + 1)

          i += 1
        }
      }

      state += 1
    }

    if(dp(N - 1) < Int.MaxValue) {
      dp(N - 1)
    } else {
      -1
    }
  }

  private def useStick(state: Int, stick: Array[Char], target: Array[Char]): Int = {
    var next = state
    var i = 0
    var j = 0
    while(i < target.length && j < stick.length) {
      if(target(i) < stick(j)) {
        i += 1
      } else if(target(i) > stick(j)) {
        j += 1
      } else  {
        if((state & (1 << i)) == 0) {
          // target doesn't have stick(j)
          next |= 1 << i
          j += 1
        }
        i += 1
      }
    }
    next
  }
}
