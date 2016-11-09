package com.me.learn.scalaindepth.chapter17

import scala.concurrent.Future

//import scala.async.Async.{async, await}
/**
  * Created by senyuanwang on 2016/11/8.
  */
object AsyncExample {

  def recordExists(id: Long): Boolean = {
    println(s"recordExists($id)")
    Thread.sleep(1)
    id > 0
  }

  def getRecord(id: Long): (Long, String) = {
    println(s"getRecord($id)")
    Thread.sleep(1)
    (id, s"record: $id")
  }

  /*def asyncGetRecord(id: Long): Future[(Long, String)] = async {
    val
  }*/

}
