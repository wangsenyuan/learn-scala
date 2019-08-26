package set0000.set100.set160.p164

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1,1,1,1,1,5,5,5,5,5" should "get 4" in {
    val res = Solution.maximumGap(Array(1, 1, 1, 1, 1, 5, 5, 5, 5, 5))
    res should be(4)
  }

  "3,6,9,1" should "get 3" in {
    val res = Solution.maximumGap(Array(3, 6, 9, 1))
    res should be(3)
  }

  "[15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740]" should "get 2901" in {
    val nums = Array(15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740)
    val res = Solution.maximumGap(nums)
    res should be(2901)
  }
}
