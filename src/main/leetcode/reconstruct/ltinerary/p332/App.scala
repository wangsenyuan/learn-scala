package reconstruct.ltinerary.p332

import java.util

import scala.collection.mutable

/**
  * Created by senyuanwang on 16/2/5.
  */
object App extends App {

  def visit(targets: mutable.Map[String, mutable.PriorityQueue[String]], from: String): List[String] = {
    var list = List.empty[String]
    while (targets.contains(from) && targets(from).size > 0) {
      list = visit(targets, targets(from).dequeue()) ++ list
    }
    from :: list
  }

  def findItinerary(tickets: List[(String, String)]): List[String] = {
    var targets = mutable.Map.empty[String, mutable.PriorityQueue[String]]

    for {
      (from, to) <- tickets
    } {
      if (!targets.contains(from)) {
        targets += (from -> new mutable.PriorityQueue[String]())
      }
      targets(from) += to
    }
    visit(targets, "JFK")
  }

  val tickets = List(("JFK", "KUL"), ("JFK", "NRT"), ("NRT", "JFK"))
  println(findItinerary(tickets))
}
