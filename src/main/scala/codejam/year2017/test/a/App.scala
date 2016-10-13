package codejam.year2017.test.a

import codejam.FileOp

/**
  * Created by wangsenyuan on 13/10/2016.
  */
object App extends App with FileOp {

  override val filePrefix: String = "src/main/scala/codejam/year2017/test/a/A-large-practice"

  val T = file.next().toInt
  var t = 1
  var res = Vector.empty[String]
  while (t <= T) {
    val line = file.next()
    res :+= f"Case #$t: ${spellWord(line)}\n"
    t += 1
  }

  writeToOutput(res)

  def spellWord(word: String): Long = {
    var res = 1L
    var i = 0
    while (i < word.length) {
      var cs = Set.empty[Char]
      if (i > 0) {
        cs += word(i - 1)
      }
      cs += word(i)

      if (i < word.length - 1) {
        cs += word(i + 1)
      }

      res = (res * cs.size) % 1000000007
      i += 1
    }
    res
  }
}
