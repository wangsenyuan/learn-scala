package set300.set340.p347


/**
  * Created by wangsenyuan on 5/3/16.
  */
object Solution extends App {

  def topKFrequent1(nums: Array[Int], k: Int): List[Int] = {
    val grouped = nums.groupBy(identity).mapValues(_.size).toList
    grouped.sortBy(_._2).reverse.map(_._1).take(k)
  }

  import scala.collection.mutable

  def topKFrequent(nums: Array[Int], k: Int): List[Int] = {
    val cnt = nums.groupBy(identity).mapValues(_.size)
    val que = new mutable.PriorityQueue[Int]()(
      Ordering.by(cnt).reverse
    )

    for {
      (num, _) <- cnt
    } {
      que.enqueue(num)
      if (que.size > k) {
        que.dequeue()
      }
    }

    que.dequeueAll
  }
}
