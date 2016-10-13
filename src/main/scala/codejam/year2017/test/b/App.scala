package codejam.year2017.test.b

import codejam.FileOp

/**
  * Created by wangsenyuan on 13/10/2016.
  */
object App extends App with FileOp {

  override val filePrefix: String = "src/main/scala/codejam/year2017/test/b/B-large-practice"

  val T = file.next().toInt
  var t = 1
  var out = Vector.empty[String]
  while (t <= T) {
    val line = file.next().split("\\s+").map(_.toLong)
    val k = line(1)

    val A = file.next().split("\\s+").map(_.toLong)
    val B = file.next().split("\\s+").map(_.toLong)
    val C = file.next().split("\\s+").map(_.toLong)
    val D = file.next().split("\\s+").map(_.toLong)

    val res = play(k, A, B, C, D)
    out :+= "Case #%d: %d\n".format(t, res)
    t += 1
  }

  writeToOutput(out)

  def xor(A: Array[Long], B: Array[Long]) = {
    (for {a <- A; b <- B} yield a ^ b)
  }

  def play(K: Long, A: Array[Long], B: Array[Long], C: Array[Long], D: Array[Long]): Long = {
    val X = xor(A, B)
    val Y = xor(C, D).sorted

    X.map(_ ^ K).map(find(Y, _)).sum
  }

  def find(arr: Array[Long], target: Long): Long = {
    val i = find(arr.length)(arr(_) >= target)
    val j = find(arr.length)(arr(_) > target)

    return j - i
  }

  def find(len: Int)(f: Int => Boolean): Int = {
    var i = 0;
    var j = len - 1
    while (i <= j) {
      val k = i + (j - i) / 2
      if (f(k)) {
        j = k - 1
      } else {
        i = k + 1
      }
    }
    j + 1
  }
}
