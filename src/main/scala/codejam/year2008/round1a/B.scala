package codejam.year2008.round1a

import codejam.FileOp

/**
  * Problem
  * *
  * You own a milkshake shop. There are N different flavors that you can prepare, and each flavor can be prepared "malted" or "unmalted". So, you can make 2N different types of milkshakes.
  * *
  * Each of your customers has a set of milkshake types that they like, and they will be satisfied if you have at least one of those types prepared. At most one of the types a customer likes will be a "malted" flavor.
  * *
  * You want to make N batches of milkshakes, so that:
  * *
  * There is exactly one batch for each flavor of milkshake, and it is either malted or unmalted.
  * For each customer, you make at least one milkshake type that they like.
  * The minimum possible number of batches are malted.
  * Find whether it is possible to satisfy all your customers given these constraints, and if it is, what milkshake types you should make.
  * If it is possible to satisfy all your customers, there will be only one answer which minimizes the number of malted batches.
  * *
  * Input
  * *
  * One line containing an integer C, the number of test cases in the input file.
  * For each test case, there will be:
  * One line containing the integer N, the number of milkshake flavors.
  * One line containing the integer M, the number of customers.
  * M lines, one for each customer, each containing:
  * An integer T >= 1, the number of milkshake types the customer likes, followed by
  * T pairs of integers "X Y", one for each type the customer likes, where X is the milkshake flavor between 1 and N inclusive, and Y is either 0 to indicate unmalted, or 1 to indicated malted. Note that:
  * No pair will occur more than once for a single customer.
  * Each customer will have at least one flavor that they like (T >= 1).
  * Each customer will like at most one malted flavor. (At most one pair for each customer has Y = 1).
  * All of these numbers are separated by single spaces.
  * Output
  * *
  * C lines, one for each test case in the order they occur in the input file, each containing the string "Case #X: " where X is the number of the test case, starting from 1, followed by:
  * The string "IMPOSSIBLE", if the customers' preferences cannot be satisfied; OR
  * N space-separated integers, one for each flavor from 1 to N, which are 0 if the corresponding flavor should be prepared unmalted, and 1 if it should be malted.
  * Limits
  * *
  * Small dataset
  * *
  * C = 100
  * 1 <= N <= 10
  * 1 <= M <= 100
  * *
  * Large dataset
  * *
  * C = 5
  * 1 <= N <= 2000
  * 1 <= M <= 2000
  * *
  * The sum of all the T values for the customers in a test case will not exceed 3000.
  *
  *
  *
  *
  * Created by wangsenyuan on 17/11/2016.
  */
object B extends App with FileOp {

  override val filePrefix = "src/main/scala/codejam/year2008/round1a/B-large-practice";

  case class Customer(flavor: Map[Int, Int])

  def serve(customers: Vector[Customer], batchs: Int): Option[Vector[Int]] = {
    val ans = Array.fill(batchs)(0)

    def canSatisfy(c: Customer): Boolean = {
      c.flavor.exists {
        case (t, f) => ans(t) == f
      }
    }

    def play(as: Vector[Customer]): Boolean = {
      as match {
        case Vector() => true
        case a +: left if canSatisfy(a) => play(left)
        case a +: left if a.flavor.forall(_._2 == 0) => false
        case a +: _ =>
          a.flavor.find(_._2 == 1) match {
            case None => false
            case Some((t, _)) =>
              ans(t) = 1
              play(customers)
          }
      }
    }

    if (play(customers)) {
      Some(ans.toVector)
    } else {
      None
    }
  }

  val C = file.next().toInt

  var c = 1
  while (c <= C) {
    val n = file.next().toInt
    val m = file.next().toInt
    var i = 0
    var customers = Vector.empty[Customer]
    while (i < m) {
      val line = file.next().split("\\s+").map(_.toInt)
      val gp = line.tail.grouped(2).map(x => (x(0) - 1) -> x(1)).toMap
      val customer = Customer(gp)
      customers :+= customer
      i += 1
    }

    serve(customers, n) match {
      case Some(ans) =>
        println(s"Case #$c: ${ans.mkString(" ")}")
      case None => println(s"Case #$c: IMPOSSIBLE")
    }

    c += 1
  }

}
