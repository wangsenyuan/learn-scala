package set1000.set1000.set1020.p1023

object Solution {
  def camelMatch(queries: Array[String], pattern: String): Array[Boolean] = {
    queries.map(query => check(query, pattern))
  }

  private def check(query: String, pattern: String): Boolean = {
    var i = 0
    var j = 0

    while (i < query.length && j < pattern.length) {
      if (query(i) == pattern(j)) {
        i += 1
        j += 1
      } else if (query(i).isLower) {
        // just insert a lower case character
        i += 1
      } else {
        return false
      }
    }

    if (i == query.length && j == pattern.length) {
      true
    } else if (i == query.length) {
      false
    } else {
      // check no upper case after i
      while (i < query.length && query(i).isLower) {
        i += 1
      }
      i == query.length
    }
  }
}
