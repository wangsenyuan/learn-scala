package com.me.permutation.product

import scala.annotation.tailrec

/**
  * Created by wangsenyuan on 14/01/2017.
  */
object Main {

  class Cycle(val elems: Vector[Int]) {
    val n = elems.size
    val idx = elems.zipWithIndex.toMap

    def mapFrom(x: Int): Option[Int] = {
      idx.get(x).map(i => elems((i + 1) % n))
    }

    def size = elems.size

    override def toString: String = "(" + elems.mkString(", ") + ")"
  }

  /**
    * a=(1352),b=(256),c=(1634),
    * ab=(1356)
    * ac=(1652)(34)
    *
    * @param elems
    * @param cycles
    * @return
    */
  def permutationProduct(elems: Vector[Int], cycles: Vector[Cycle]): Vector[Cycle] = {

    def mapFrom(x: Int, cycles: Vector[Cycle]): Int = {
      cycles.foldLeft(x) {
        (x, cycle) =>
          cycle.mapFrom(x) match {
            case Some(y) => y
            case None => x
          }
      }
    }

    @tailrec
    def go(start: Int, x: Int, cycles: Vector[Cycle], elems: Vector[Int]): Cycle = {
      val y = mapFrom(x, cycles)
      if (y == start) {
        new Cycle(elems)
      } else {
        go(start, y, cycles, elems :+ y)
      }
    }

    val reversed = cycles.reverse

    val res = elems.foldLeft((Vector.empty[Cycle], Set.empty[Int])) {
      case ((cycles, checked), x) =>
        if (checked(x)) {
          (cycles, checked)
        } else {
          val cur = go(x, x, reversed, Vector(x))
          (cycles :+ cur, checked ++ Set(cur.elems: _*))
        }
    }

    res._1.filter(_.size > 1)
  }

  def main(args: Array[String]): Unit = {
    val a = new Cycle(Vector(1, 3, 5, 2))
    val b = new Cycle(Vector(2, 5, 6))
    val c = new Cycle(Vector(1, 6, 3, 4))

    val elems = Vector(1, 2, 3, 4, 5, 6)

    println(permutationProduct(elems, Vector(a, b)))
    println(permutationProduct(elems, Vector(a, c)))
  }
}
