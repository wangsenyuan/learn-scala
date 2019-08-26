package set0000.set800.set800.p804

import scala.collection.mutable

object Solution {
  val codes = Array(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")

  def uniqueMorseRepresentations(words: Array[String]): Int = {
    val res = mutable.Set.empty[String]

    words.foreach(word => res += transform(word))

    res.size
  }

  private def transform(word: String): String = {
    word.map(c => codes(c - 'a')).mkString("")
  }
}
