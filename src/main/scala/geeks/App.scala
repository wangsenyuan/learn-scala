package geeks

/**
  * Created by senyuanwang on 15/10/29.
  */
object App extends App {

  def makeAdder(x: Int) = (y: Int) => x + y

  val addFour = makeAdder(4)

  addFour(5)

  addFour(6)

  val n = 100000L

  val m = (n + 1) * n

  println(m)

  println(Int.MaxValue)

  println(1000000000)
}
