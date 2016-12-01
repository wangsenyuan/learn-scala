package p358

import scala.annotation.tailrec

/**
  * Created by wangsenyuan on 28/11/2016.
  */
object App {

  def main(args: Array[String]): Unit = {
    println(rearrangeString("bbabcaccaaabababbaaaaccbbcbacbacacccbbcaabcbcacaaccbabbbbbcacccaccbabaccbacabcabcacb", 2))
    println(rearrangeString("aaabc", 3))
  }

  def rearrangeString(str: String, k: Int): String = {
    val words = str.groupBy(identity).mapValues(_.size).toVector.sortBy(_._2).reverse
    val res = Array.fill(str.length)('\0')

    @tailrec
    def fillWord(ch: Char, count: Int, cycles: Int, index: Int, i: Int): Option[(Int, Int)] = {
      if (i == count) {
        Some(cycles, index)
      } else {
        res(index) = ch
        if (index > 0 && res(index) == res(index - 1)) {
          None
        } else {
          if (index + k >= str.length) {
            fillWord(ch, count, cycles + 1, cycles + 1, i + 1)
          } else {
            fillWord(ch, count, cycles, index + k, i + 1)
          }
        }
      }
    }

    def fill(cycles: Int, index: Int, words: Vector[(Char, Int)]): Option[String] =
      words match {
        case word +: left =>
          fillWord(word._1, word._2, cycles, index, 0).flatMap {
            case (newCycles, newIndex) => fill(newCycles, newIndex, left)
          }
        case Vector() =>
          Some(res.mkString)
      }

    fill(0, 0, words).getOrElse("")
  }
}
