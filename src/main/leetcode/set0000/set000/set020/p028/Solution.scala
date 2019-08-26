package set0000.set000.set020.p028

object Solution {

  def strStr(haystack: String, needle: String): Int = {
    if (needle == null || needle.isEmpty) {
      0
    } else if (haystack == null || haystack.isEmpty) {
      -1
    } else if (haystack.length < needle.length) {
      -1
    } else {
      kmp(haystack, needle)
    }
  }

  private def kmp(str: String, pat: String): Int = {
    val lps = computeLPS(pat)

    var i = 0
    var j = 0
    while (i < str.length && j < pat.length) {
      if (str(i) == pat(j)) {
        i += 1
        j += 1
      }

      if (j < pat.length && i < str.length && str(i) != pat(j)) {
        if (j != 0) {
          j = lps(j - 1)
        } else {
          i += 1
        }
      }
    }

    if (j == pat.length) {
      i - j
    } else {
      -1
    }
  }


  private def computeLPS(pat: String) = {
    val n = pat.length
    val arr = Array.fill(n)(0)
    var len = 0
    var i = 1
    while (i < n) {
      if (pat(i) == pat(len)) {
        len += 1
        arr(i) = len
        i += 1
      } else {
        if (len > 0) {
          len = arr(len - 1)
        } else {
          arr(i) = 0
          i += 1
        }
      }
    }

    arr
  }


  def strStr1(haystack: String, needle: String): Int = {
    if (needle == null || needle.isEmpty) {
      0
    } else if (haystack == null || haystack.isEmpty) {
      -1
    } else {
      haystack.indexOf(needle)
    }
  }
}
