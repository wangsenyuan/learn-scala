package set0000.set900.set930.p936

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  private def useResult(stamp: String, target: String, res: Array[Int]): String = {
    val str = Array.ofDim[Char](target.length)

    val arr = stamp.toCharArray

    res.foreach(i => {
      Array.copy(arr, 0, str, i, arr.length)
    })

    str.mkString("")
  }

  "example one" should "work" in {
    val stamp = "abc"
    val target = "ababc"
    val res = Solution.movesToStamp(stamp, target)
    val str = useResult(stamp, target, res)
    str should be(target)
  }

  "example two" should "work" in {
    val stamp = "abca"
    val target = "aabcaca"
    val res = Solution.movesToStamp(stamp, target)
    val str = useResult(stamp, target, res)

    str should be(target)
  }

  "example three" should "work" in {
    val stamp = "lemk"
    val target = "lleme"
    val res = Solution.movesToStamp(stamp, target)
    //    val str = useResult(stamp, target, res)

    //    str should be(target)
    res should be(Array())
  }

  "example four" should "work" in {
    val stamp = "oz"
    val target = "ooozz"
    val res = Solution.movesToStamp(stamp, target)
    val str = useResult(stamp, target, res)

    str should be(target)
  }

  "example five" should "work" in {
    val stamp = "h"
    val target = "hhhh"
    val res = Solution.movesToStamp(stamp, target)
    val str = useResult(stamp, target, res)

    str should be(target)
  }

  "example six" should "work" in {
    val stamp = "de"
    val target = "ddeddeddee"
    val res = Solution.movesToStamp(stamp, target)
    val str = useResult(stamp, target, res)

    str should be(target)
  }
}
