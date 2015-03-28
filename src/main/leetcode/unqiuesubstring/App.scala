package unqiuesubstring

/**
 * Created by senyuanwang on 15/3/18.
 */
object App extends App {

  def lengthOfLongestSubstring(str: String): Int = {

    def go(idx: Int, map: Map[Char, Int], lastPos: Int, currLen: Int, maxLen: Int): Int =
      if (idx >= str.length) {
        maxLen
      } else {
        val c = str(idx)
        val prevIdx = map(c)

        if (prevIdx < lastPos) {
          go(idx + 1, map + (c -> idx), lastPos, currLen + 1, maxLen max (currLen + 1))
        } else {
          go(idx + 1, map + (c -> idx), prevIdx + 1, idx - prevIdx, maxLen)
        }
      }

    go(0, Map.empty.withDefaultValue(-1), 0, 0, 0)
  }

  println(lengthOfLongestSubstring("abba"))

  println(lengthOfLongestSubstring("aab"))

  println(lengthOfLongestSubstring("ab"))

  println(lengthOfLongestSubstring("bbbbbb"))

  println(lengthOfLongestSubstring("abcabcbb"))
}
