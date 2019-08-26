package set0000.set500.set590.p599

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution {
  def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
    val ii = mutable.Map.empty[String, Int]

    for {
      i <- list1.indices
      word = list1(i)
      if(!ii.contains(word))
    } {
      ii(word) = i
    }

    var best = Int.MaxValue
    for {
      i <- list2.indices
      word = list2(i)
      if(ii.contains(word))
      j = ii(word)
    } {
      best = best min (i + j)
    }

    if(best == Int.MaxValue) {
      Array()
    } else {
      val res = ArrayBuffer.empty[String]
      for {
        i <- list2.indices
        word = list2(i)
        if(ii.contains(word))
        j = ii(word)
        if(i + j == best)
      } {
        res += word
      }
      res.toArray
    }
  }
}
