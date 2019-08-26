package set0000.set300.set320.p320

/**
  * Created by senyuanwang on 15/12/22.
  */
object App {

  def generateAbbreviations(word: String): Vector[String] = {

    def go(i: Int, abbr: Boolean, prev: String): Vector[String] = {
      if (i == word.length) {
        Vector(prev)
      } else {
        go(i + 1, false, prev + word(i)) ++
          (if (!abbr) {
            for {
              j <- i + 1 to word.length
              str <- go(j, true, prev + (j - i))
            } yield str
          } else Vector())
      }
    }

    go(0, false, "")
  }

  def main(args: Array[String]): Unit = {
    println(generateAbbreviations("word"))
  }
}
