package set700.set730.p731

import org.scalatest.{FlatSpec, Matchers}

class MyCalendarTwoSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val calender = new MyCalendarTwo1
    calender.book(10, 20) should be(true)
    calender.book(50, 60) should be (true)
    calender.book(10, 40) should be (true)
    calender.book(5, 15) should be(false)
    calender.book(5, 10) should be(true)
    calender.book(25, 55) should be(true)
  }
}
