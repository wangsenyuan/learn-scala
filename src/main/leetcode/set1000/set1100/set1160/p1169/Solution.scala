package set1000.set1100.set1160.p1169

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Sorting

object Solution {
  def invalidTransactions(transactions: Array[String]): List[String] = {
    val txs = transactions.map(Transaction(_))

    Sorting.quickSort(txs)(Ordering.by(_.time))

    val tgs = txs.groupBy(_.name)

    val buf = ListBuffer.empty[Transaction]

    for {
      tg <- tgs
    } {
      //      val name = tg._1
      val ts = tg._2

      var j = 0
      var i = 0

      val cities = mutable.Map.empty[String, Int].withDefaultValue(0)

      val added = mutable.Set.empty[Int]

      while (i < ts.length) {
        val t = ts(i)
        if (t.amount > 1000) {
          buf += t
          added += i
        }
        cities(t.city) += 1

        while (j < i && ts(i).time - ts(j).time > 60) {
          cities(ts(j).city) -= 1
          if (cities(ts(j).city) == 0) {
            cities.remove(ts(j).city)
          }
          j += 1
        }

        if (cities.size > 1) {
          for {
            k <- j to i
            if !added(k)
          } {
            added += k
            buf += ts(k)
          }
        }

        i += 1
      }
    }

    buf.map(_.toString).toList
  }

  case class Transaction(name: String, time: Int, amount: Int, city: String) {
    override def toString: String = {
      s"$name,$time,$amount,$city"
    }
  }

  object Transaction {
    def apply(str: String): Transaction = {
      val ss = str.split(",")
      Transaction(ss(0), ss(1).toInt, ss(2).toInt, ss(3))
    }
  }

}
