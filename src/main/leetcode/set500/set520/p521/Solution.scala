package set500.set520.p521

object Solution {
  def findLUSlength(a: String, b: String): Int = {
    if(a.length > b.length) {
      a.length
    } else if(a.length < b.length) {
      b.length
    } else if(a != b) {
      a.length
    } else {
      -1
    }
  }
}
