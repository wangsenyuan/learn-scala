package set700.set730.p732

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val calendar = new MyCalendarThree()
    calendar.book(10, 20) should be(1)
    calendar.book(50, 60) should be(1)
    calendar.book(10, 40) should be(2)
    calendar.book(5, 15) should be(3)
    calendar.book(5, 10) should be(3)
    calendar.book(25, 55) should be(3)
  }
}
