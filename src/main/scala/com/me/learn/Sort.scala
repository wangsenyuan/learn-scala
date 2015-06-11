package com.me.learn

/**
 * Created by senyuanwang on 15/6/11.
 */
object Sort {

  def quickSort[T](list: List[T])(implicit ordering: Ordering[T]): List[T] = {
    list match {
      case Nil => Nil
      case h :: tail =>
        val (lt, gt) = tail.partition(ordering.compare(_, h) < 0)
        list.sorted
        quickSort(lt) ++ (h :: quickSort(gt))
    }
  }

  def bubbleSort[T](list: List[T])(implicit ordering: Ordering[T]): List[T] = {
    list match {
      case Nil => Nil
      case _ =>
        val x = list.max
        val (xs, ys) = list.partition(ordering.compare(_, x) == 0)
        bubbleSort(ys) ++ xs
    }
  }

  def insertSort[T](list: List[T])(implicit ordering: Ordering[T]): List[T] = {
    def sortAndInsert(sorted: List[T], x: T): List[T] =
      sorted match {
        case Nil => x :: Nil
        case y :: tail =>
          val cmp = ordering.compare(x, y)
          if (cmp < 0) {
            y :: sortAndInsert(tail, x)
          } else {
            x :: sorted
          }
      }

    def go(sorted: List[T], left: List[T]): List[T] =
      left match {
        case Nil => sorted.reverse
        case h :: tail =>
          go(sortAndInsert(sorted, h), tail)
      }

    go(Nil, list)
  }

  /*case class A(x: Int)

  implicit val ord =  new Ordering[A] {
    override def compare(a: A, b: A): Int = a.x - b.x
  }

  quickSort(List(A(1)))*/
}
