package com.me.learn.implicits.payroll

/**
  * Created by senyuanwang on 16/9/25.
  */
object CalculatePayroll2 {

  def main(args: Array[String]): Unit = {
    import Pipleline._
    import Payroll._

    val e = Employee("Jim", 100000.0f, 0.25f, 200f, 0.10f, 0.05f)

    val pay = start(e) |>
      minus401k |>
      minusInsurance |>
      minusTax |>
      minusFinalDeductions

    val twoWeekGross = e.annualSalary / 26.0f
    val twoWeekNet = pay.netPay
    val percent = twoWeekNet * 100 / twoWeekGross

    println(s"For ${e.name}, the gross vs. net pay every 2 weeks is:")
    println(f"  $$${twoWeekGross}%.2f vs. $$${twoWeekNet}%.2f or ${percent}%.1f%%")
  }
}
