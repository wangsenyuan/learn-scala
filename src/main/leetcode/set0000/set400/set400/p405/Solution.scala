package set0000.set400.set400.p405

object Solution {
  def toHex(num: Int): String = {
    val dict = "0123456789abcdef".toCharArray
    val mask = 0xf

    val buf = new StringBuilder

    var x = num
    while(x != 0) {
      val y = x & mask
      buf.append(dict(y))
      x >>>= 4
    }

    if(buf.isEmpty) {
      "0"
    } else {
      buf.reverse.toString()
    }
  }
}
