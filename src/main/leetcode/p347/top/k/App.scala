package p347.top.k

/**
  * Created by wangsenyuan on 5/3/16.
  */
object App extends App {

  def topKFrequent(nums: Array[Int], k: Int): List[Int] = {
    val list = nums.map(x => (x, 1)).toList
    val grouped = list.groupBy(_._1).mapValues(_.size).toList
    grouped.sortBy(_._2).map(_._1).take(k)
  }
}
