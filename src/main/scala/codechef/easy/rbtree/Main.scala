package codechef.easy.rbtree

import scala.annotation.tailrec
import scala.io.StdIn
import scala.language.postfixOps

/**
 * Created by wangsenyuan on 28/03/2017.
 */
object Main {


  def lowestCommonAncestor(x: Int, y: Int): Int = {

    @tailrec
    def go(x: Int, y: Int): Int = {
      if (x == y) {
        x
      } else if (x < y) {
        go(x, y / 2)
      } else {
        go(x / 2, y)
      }
    }

    go(x, y)
  }


  def steps(x: Int, root: Int) = {
    def go(x: Int, cnt: Int): Int = {
      if (x == root) {
        cnt
      } else {
        go(x / 2, cnt + 1)
      }
    }

    go(x, 0)
  }


  def queryRed(rootBlack: Boolean, x: Int, y: Int): Int = {
    val root = lowestCommonAncestor(x, y)

    val a = steps(x, root)
    val b = steps(y, root)

    //color diff from root
    val ra = (a + 1) / 2
    val rb = (b + 1) / 2

    val c = steps(root, 1)
    val rootColor =
      if (c % 2 == 1) {
        //different from root
        !rootBlack
      } else {
        rootBlack
      }

    if (!rootColor) {
      //root is red
      (a + 1 - ra) + (b + 1 - rb) - 1
    } else {
      //root is black
      ra + rb
    }
  }

  def queryBlack(rootBlack: Boolean, x: Int, y: Int) = {
    val root = lowestCommonAncestor(x, y)

    val a = steps(x, root)
    val b = steps(y, root)
    val red = queryRed(rootBlack, x, y)
    (a + 1 + b + 1 - 1) - red
  }

  def main(args: Array[String]): Unit = {
    var n = StdIn.readInt()

    var rootBlack = true

    while (n > 0) {
      val question = StdIn.readLine()
      if ("Qi" == question) {
        rootBlack = !rootBlack
      } else {
        val qs = question.split("\\s+")
        val x = qs(1) toInt
        val y = qs(2) toInt
        val res =
          if (qs(0) == "Qr") {
            queryRed(rootBlack, x, y)
          } else {
            queryBlack(rootBlack, x, y)
          }
        println(res)
      }
      n -= 1
    }
  }
}
