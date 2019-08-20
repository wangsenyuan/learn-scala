package set800.set850.p857

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val quality = Array(10, 20, 5)
    val wage = Array(70, 50, 30)
    val K = 2
    val res = Solution.mincostToHireWorkers(quality, wage, K)
    (res - 105.00000).abs should be < (1e-5)
  }

  "example two" should "work" in {
    val quality = Array(3, 1, 10, 10, 1)
    val wage = Array(4, 8, 2, 2, 7)
    val K = 3
    val res = Solution.mincostToHireWorkers(quality, wage, K)
    (res - 30.66667).abs should be < (1e-5)
  }

  "example three" should "work" in {
    val quality = Array(25, 68, 35, 62, 52, 57, 35, 83, 40, 51)
    val wage = Array(147, 97, 251, 129, 438, 443, 120, 366, 362, 343)
    val K = 6
    val res = Solution.mincostToHireWorkers(quality, wage, K)
    (res - 1979.31429).abs should be < (1e-5)
  }

  "example four" should "work" in {
    val quality = Array(37, 32, 14, 14, 23, 31, 82, 96, 81, 96, 22, 17, 68, 3, 88, 59, 54, 23, 22, 77, 61, 16, 46, 22, 94, 50, 29, 46, 7, 33, 22, 99, 31, 99, 75, 67, 95, 54, 31, 48, 44, 96, 99, 20, 51, 54, 18, 85, 25, 84)
    val wage = Array(453, 236, 199, 359, 107, 45, 150, 433, 32, 192, 433, 94, 113, 200, 293, 31, 48, 27, 15, 32, 295, 97, 199, 427, 90, 215, 390, 412, 475, 131, 122, 398, 479, 142, 103, 243, 86, 309, 498, 210, 173, 363, 449, 135, 353, 397, 105, 165, 165, 62)
    val K = 20
    val res = Solution.mincostToHireWorkers(quality, wage, K)
    (res - 4947.75).abs should be < (1e-5)
  }
}
