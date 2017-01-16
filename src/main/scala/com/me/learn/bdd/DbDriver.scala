package com.me.learn.bdd

import java.util.concurrent.ConcurrentHashMap

/**
  * Created by wangsenyuan on 16/01/2017.
  */
object DbServer {
  // Simulating a database server
  type Db = StringBuffer
  private val databases = new ConcurrentHashMap[String, Db]

  def createDb(name: String): Db = {
    val db = new StringBuffer
    databases.put(name, db)
    db
  }

  def removeDb(name: String) {
    databases.remove(name)
  }
}
