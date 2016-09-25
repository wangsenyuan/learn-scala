package com.me.learn.implicits

/**
  * Created by senyuanwang on 16/9/25.
  */
package object payroll {

  sealed trait PreTaxDeductions

  sealed trait PostTaxDecutions

  sealed trait Final

  case class Employee(
                       name: String,
                       annualSalary: Float,
                       taxRate: Float,
                       insurancePremiumsPerPayPeriod: Float,
                       _401DeductionRate: Float,
                       postTaxDeductions: Float
                     )

  case class Pay[Step](employee: Employee, netPay: Float)

  object Payroll {
    def start(employee: Employee): Pay[PreTaxDeductions] = {
      Pay[PreTaxDeductions](employee, employee.annualSalary / 26.0F)
    }

    def minusInsurance(pay: Pay[PreTaxDeductions]): Pay[PreTaxDeductions] = {
      val newNet = pay.netPay - pay.employee.insurancePremiumsPerPayPeriod
      pay copy (netPay = newNet)
    }

    def minus401k(pay: Pay[PreTaxDeductions]): Pay[PreTaxDeductions] = {
      val newNet = pay.netPay - (pay.employee._401DeductionRate * pay.netPay)
      pay copy (netPay = newNet)
    }

    def minusTax(pay: Pay[PreTaxDeductions]): Pay[PostTaxDecutions] = {
      val newNet = pay.netPay - pay.employee.taxRate * pay.netPay
      pay copy (netPay = newNet)
    }

    def minusFinalDeductions(pay: Pay[PostTaxDecutions]): Pay[Final] = {
      val newNet = pay.netPay - pay.employee.postTaxDeductions
      pay copy (netPay = newNet)
    }
  }

  object Pipleline {

    implicit class toPiped[V](value: V) {
      def |>[R](f: V => R) = f(value)
    }

  }

}
