package set0000.set800.set830.p831

object Solution {
  def maskPII(S: String): String = {
    if (S.find(_.isDigit).isDefined) {
      maskPhone(S)
    } else {
      maskEmail(S)
    }
  }

  private def maskEmail(s: String): String = {
    val ss = s.toLowerCase().split("@")
    val firstName = ss(0)
    val a = firstName.head
    val b = firstName.last
    a + "*****" + b + "@" + ss(1)
  }

  private def maskPhone(s: String): String = {
    val nums = s.toCharArray.filter(_.isDigit)
    if (nums.length > 10) {
      "+" + ("*" * (nums.length - 10)) + "-***-***-" + nums.drop(nums.length - 4).mkString("")
    } else {
      "***-***-" + nums.drop(6).mkString("")
    }
  }
}
