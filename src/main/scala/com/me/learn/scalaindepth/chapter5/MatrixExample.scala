package com.me.learn.scalaindepth.chapter5

import java.util.concurrent.{Callable, Executors}

import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps

/**
 * Created by senyuanwang on 15/6/14.
 */
object MatrixExample extends App {

  class Matrix(private val repr: Array[Array[Double]]) {
    def row(idx: Int): Seq[Double] = repr(idx)

    def col(idx: Int): Seq[Double] = {
      repr.foldLeft(new ArrayBuffer[Double]()) {
        (buf, row) =>
          buf.append(row(idx))
          buf
      }.toSeq
    }

    def rowRank = repr.length

    def colRank = if (repr.length > 0) repr(0).length else 0

    override def toString = {
      repr.foldLeft("") {
        (msg, row) => msg + "\n" + row.mkString(" | ")
      }
    }
  }

  object Matrix {
    def multiply(a: Matrix, b: Matrix)(implicit threadStrategy: ThreadStrategy = SameThreadStrategy): Matrix = {
      require(a.colRank == b.rowRank)

      val buffer = new Array[Array[Double]](a.rowRank)

      for (i <- 0 until a.rowRank) {
        buffer(i) = new Array[Double](b.colRank)
      }

      def computeValue(row: Int, col: Int): Unit = {
        val pairwiseElems = a.row(row).zip(b.col(col))
        val products = for ((x, y) <- pairwiseElems) yield x * y
        buffer(row)(col) = products.sum
      }

      val computations = for {
        i <- 0 until a.rowRank
        j <- 0 until b.colRank
      } yield threadStrategy.execute(() => computeValue(i, j))

      computations.foreach(_ ())
      new Matrix(buffer)
    }
  }


  trait ThreadStrategy {
    def execute[A](func: Function0[A]): Function0[A]
  }

  object SameThreadStrategy extends ThreadStrategy {
    override def execute[A](func: () => A): () => A = func
  }

  object ThreadPoolStrategy extends ThreadStrategy {
    val pool = Executors.newFixedThreadPool(Runtime.getRuntime.availableProcessors())

    override def execute[A](func: () => A): () => A = {
      val future = pool.submit(new Callable[A] {
        override def call(): A = {
          println("Executing function in thread: " + Thread.currentThread().getName)
          func()
        }
      })
      () => future.get()
    }
  }

  //  implicit val ts = ThreadPoolStrategy

  val x = new Matrix(Array(Array(1, 2, 3), Array(4, 5, 6)))

  val y = new Matrix(Array(Array(1), Array(1), Array(1)))

  val z = Matrix.multiply(x, y)

  println(z)
}
