package geeks

/**
 * Created by senyuanwang on 15/5/22.
 */
object ForLoopTest extends App {

  for {
    i <- 0 until 10
    array = Array(1, 2, 3)
  } {
    println("before another loop")
    for {
      j <- array
    } {
      println(i + " and " + j)
    }
  }
}
