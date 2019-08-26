package set0000.set400.set470.p478

class Solution(_radius: Double, _x_center: Double, _y_center: Double) {
  def randPoint(): Array[Double] = {
    val len = Math.sqrt(Math.random() ) * _radius
    val deg = Math.random() * 2 * Math.PI
    val x = _x_center + len * Math.cos(deg)
    val y = _y_center + len * Math.sin(deg)
    Array(x, y)
  }

}
