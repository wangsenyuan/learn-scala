package geeks

/**
 * Created by senyuanwang on 15/10/29.
 */
object App {

  def makeAdder(x: Int) = (y: Int) => x + y

  val addFour = makeAdder(4)

  addFour(5)

  addFour(6)
}
