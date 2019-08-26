package set0000.set000.set010.p015

/**
  * Created by wangsenyuan on 1/2/16.
  */
object App extends App {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    type THREE_NUM = List[Int]

    if (nums == null || nums.length < 3) {
      Nil
    } else {
      val sorted = nums.sorted

      def twoSum(start: Int, end: Int, target: Int): List[THREE_NUM] = {
        var i = start
        var j = end
        var result: List[THREE_NUM] = Nil

        while (i < j) {
          val sum = sorted(i) + sorted(j)
          if (sum < target) {
            i += 1
          } else if (sum > target) {
            j -= 1
          } else {
            result = List(-target, sorted(i), sorted(j)) :: result

            i += 1
            while (i < j && sorted(i - 1) == sorted(i)) {
              i += 1
            }

            j -= 1
            while (i < j && sorted(j) == sorted(j + 1)) {
              j -= 1
            }
          }
        }

        result
      }

      var result: List[THREE_NUM] = Nil
      for {
        i <- 0 until sorted.length - 2
        if nums(i) <= 0
        if !(i > 0 && sorted(i) == sorted(i - 1))
      } {
        result ++= twoSum(i + 1, sorted.length - 1, -sorted(i))
      }

      result
    }
  }

  println(threeSum(Array(-1, 0, 1, 2, -1, -4)))
}
