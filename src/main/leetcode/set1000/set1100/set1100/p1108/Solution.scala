package set1000.set1100.set1100.p1108

object Solution {
  def defangIPaddr(address: String): String = {
    address.replaceAll("\\.", "\\[\\.\\]")
  }
}
