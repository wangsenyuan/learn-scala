package set0000.set700.set780.p780

object Solution {
  def reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean = {
    var x = tx
    var y = ty
    while(x >= sx && y >= sy && x != y) {
      if(x > y) {
        if(y > sy) {
          x %= y
        } else {
          return (x - sx) % sy == 0
        }
      } else {
        if(x > sx) {
          y %= x
        } else {
          return (y - sy) % sx == 0
        }
      }
    }
    return x == sx && y == sy
  }
}
