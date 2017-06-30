package com.me.work


import play.api.libs.json.{JsPath, Reads}
import play.api.libs.functional.syntax._
import scala.io.StdIn


/**
  * Created by wangsenyuan on 26/06/2017.
  */
object Recover {


  def readFullConsole() = {
    val res = new StringBuilder
    var line = StdIn.readLine()
    while (line != null && !line.isEmpty) {
      res.append(line).append("\n")
      line = StdIn.readLine()
    }
    res.toString
  }

  /**
    * {
    * "id_": "657925",
    * "rev_": 1,
    * "group_id_": "CASHIER",
    * "type_": "candidate",
    * "user_id_": null,
    * "task_id_": "657924",
    * "proc_inst_id_": null,
    * "proc_def_id_": null
    * },
    *
    */

  case class Record(id: String, groupId: String)

  implicit val recordReads: Reads[Record] = (
    (JsPath \ "id_").read[String] and (JsPath \ "group_id_").read[String]
    ) (Record.apply _)

  def main(args: Array[String]): Unit = {
    val str = readFullConsole()
    println("json read")
    import play.api.libs.json._

    val json = Json.parse(str)

    val data = json \ "data"
    val recordResult: JsResult[Seq[Record]] = data.validate[Seq[Record]]

    recordResult.foreach {
      records =>
        records.foreach {
          record =>
            println(s"update act_ru_identitylink set group_id_ = '${record.groupId}' where id_ = '${record.id}';")
        }
    }

  }
}
