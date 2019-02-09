package set300.set330.p332


object Solution {

  import scala.collection.mutable

  def findItinerary(tickets: Array[Array[String]]): List[String] = {
    val graph = mutable.Map.empty[String, mutable.PriorityQueue[String]]

    for {
      ticket <- tickets
      from = ticket(0)
      to = ticket(1)
    } {
      if (!graph.contains(from)) {
        graph(from) = new mutable.PriorityQueue[String]()(Ordering.String.reverse)
      }
      graph(from).enqueue(to)
    }

    def visit(from: String): List[String] = {
      var res = List.empty[String]
      while (graph.contains(from) && graph(from).size > 0) {
        res = visit(graph(from).dequeue()) ++ res
      }
      from :: res
    }

    visit("JFK")
  }

  def getCities(tickets: Array[Array[String]]) = {
    tickets.flatten.toSet.toArray
  }

  def findItinerary1(tickets: Array[Array[String]]): List[String] = {
    val cities = getCities(tickets).sorted
    var graph = Map.empty[String, Int].withDefaultValue(0)

    for {
      ticket <- tickets
      key = s"${ticket(0)}->${ticket(1)}"
    } {
      if (graph.contains(key)) {
        graph += key -> (graph(key) + 1)
      } else {
        graph += key -> 1
      }
    }

    val n = tickets.length

    def go(cur: String, path: String, used: Map[String, Int]): Option[String] = {
      if (path.length == 3 * (n + 1)) {
        Some(path)
      } else {
        var ans = Option.empty[String]
        var i = 0
        while (i < cities.size && ans.isEmpty) {
          val city = cities(i)
          val key = s"${cur}->${city}"
          if (used(key) < graph(key)) {
            ans = go(city, path + city, used + (key -> (used(key) + 1)))
          }
          i += 1
        }
        ans
      }
    }

    val res = go("JFK", "JFK", Map.empty[String, Int].withDefaultValue(0))
    res match {
      case None => Nil
      case Some(x) => x.grouped(3).toList
    }
  }
}
