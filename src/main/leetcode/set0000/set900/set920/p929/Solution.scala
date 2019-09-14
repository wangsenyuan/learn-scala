package set0000.set900.set920.p929

object Solution {
  def numUniqueEmails(emails: Array[String]): Int = {
    emails.map(format).toSet.size
  }

  private def format(email: String): String = {
    val ss = email.split("@")
    val local = ss(0).toCharArray
    var n = 0
    var i = 0
    while (i < local.length) {
      if (local(i) == '+') {
        // break here
        i = local.length
      } else if (local(i) == '.') {
        // skip .
        i += 1
      } else {
        // normal case
        local(n) = local(i)
        n += 1
        i += 1
      }
    }
    local.slice(0, n).mkString("") + '@' + ss(1)
  }
}
