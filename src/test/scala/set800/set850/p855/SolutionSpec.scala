package set800.set850.p855

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val examRoom = new Solution.ExamRoom(4)

    var pos = examRoom.seat()

    pos should be(0)

    pos = examRoom.seat()

    pos should be(3)

    pos = examRoom.seat()

    pos should be(1)

    pos = examRoom.seat()

    pos should be(2)

    examRoom.leave(3)

    examRoom.leave(1)

    pos = examRoom.seat()

    pos should be(1)

    examRoom.leave(2)

    pos = examRoom.seat()

    pos should be(3)
  }

  "example two" should "work" in {
    val room = new Solution.ExamRoom(10)
    var pos = room.seat()
    pos should be(0)
    pos = room.seat()
    pos should be(9)
    pos = room.seat()
    pos should be(4)
    room.leave(0)
    room.leave(4)

    room.seat() should be(0)

    room.seat() should be(4)
    room.seat() should be(2)
    room.seat() should be(6)
    room.seat() should be(1)
    room.seat() should be(3)
    room.seat() should be(5)
    room.seat() should be(7)
    room.seat() should be(8)
    room.leave(0)
    room.leave(4)
    room.seat() should be(0)
    room.seat() should be(4)

  }

  "example three" should "work" in {
    val room = new Solution.ExamRoom(10)
    room.seat() should be(0)
    room.seat() should be(9)
    room.leave(0)
    room.leave(9)
    room.seat() should be(0)
  }

  "example four" should "work" in {
    val room = new Solution.ExamRoom(9)
    room.seat() should be(0)
    room.seat() should be(8)
    room.seat() should be(4)
    room.seat() should be(2)
    room.leave(4)
    room.seat() should be(5)
    room.seat() should be(1)
    room.seat() should be(3)
    room.seat() should be(4)
    room.seat() should be(6)
    room.seat() should be(7)
    room.leave(3)
    room.seat() should be(3)
  }
}
