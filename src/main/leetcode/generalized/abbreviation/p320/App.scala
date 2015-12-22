package generalized.abbreviation.p320

/**
  * Created by senyuanwang on 15/12/22.
  */
object App {

  def generateAbbreviations(word: String): List[String] = {

    def go(str: String): Set[String] = {
      if (str == "") {
        Set("")
      } else {
        var set: Set[String] = Set()
        set += str.length().toString

        for {
          i <- 0 until str.length
          c = str.charAt(i)
          prev <- go(str.substring(0, i))
          next <- go(str.substring(i + 1))
        } {
          set += prev + c + next
        }

        set
      }
    }

    go(word).toList
  }
}
