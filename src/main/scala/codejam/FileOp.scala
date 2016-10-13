package codejam

import java.io.File

import scala.io.Source

/**
  * Created by senyuanwang on 14/11/29.
  */
trait FileOp {

  val filePrefix = ""

  def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try {
      op(p)
    } finally {
      p.close()
    }
  }

  def writeToOutput(sa: Array[String]) =
    printToFile(new File((s"$filePrefix.out")))(
      pw => sa.foreach(pw.write)
    )

  def writeToOutput(sa: Vector[String]) =
    printToFile(new File((s"$filePrefix.out")))(
      pw => sa.foreach(pw.write)
    )

  lazy val file = {
    val f = new File(s"$filePrefix.in")
    //println(f.getAbsolutePath())
    val fileContent = Source.fromFile(f)
    fileContent.getLines()
  }


}
