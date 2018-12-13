package set000.set060.p065

object Solution {
  def isNumber(s: String): Boolean = {
    if (s.isEmpty) {
      false
    } else {
      var state: State = State0
      var i = 0
      val n = s.length
      while (i < n && state != Fail) {
        state = state.next(s(i))
        i += 1
      }
      state != Fail && state.end
    }
  }

  trait State {
    def next(c: Char): State

    def end: Boolean = true
  }

  case object State0 extends State {
    override def next(c: Char): State = {
      if (c == ' ') {
        State1
      } else if (c == '+' || c == '-') {
        State2
      } else if (c.isDigit) {
        State3
      } else if (c == '.') {
        State9
      } else {
        Fail
      }
    }

    override def end: Boolean = false
  }

  case object Fail extends State {
    override def next(c: Char): State = Fail

    override def end: Boolean = true
  }

  case object State1 extends State {
    override def next(c: Char): State = {
      if (c == ' ') {
        State1
      } else if (c == '+' || c == '-') {
        State2
      } else if (c.isDigit) {
        State3
      } else if (c == '.') {
        State9
      } else {
        Fail
      }
    }

    override def end: Boolean = false
  }

  case object State2 extends State {
    override def next(c: Char): State = {
      if (c.isDigit) {
        State3
      } else if (c == '.') {
        State9
      } else {
        Fail
      }
    }

    override def end: Boolean = false
  }

  case object State3 extends State {
    override def next(c: Char): State = {
      if (c.isDigit) {
        State3
      } else if (c == '.') {
        State4
      } else if (c == 'e') {
        State5
      } else if (c == ' ') {
        State6
      } else {
        Fail
      }
    }
  }

  case object State4 extends State {
    override def next(c: Char): State = {
      if (c.isDigit) {
        State4
      } else if (c == ' ') {
        State6
      } else if (c == 'e') {
        State5
      } else {
        Fail
      }
    }
  }

  case object State5 extends State {
    override def next(c: Char): State = {
      if (c.isDigit) {
        State7
      } else if (c == '+' || c == '-') {
        State8
      } else {
        Fail
      }
    }

    override def end: Boolean = false
  }

  case object State6 extends State {
    override def next(c: Char): State = {
      if (c == ' ') {
        State6
      } else {
        Fail
      }
    }
  }

  case object State7 extends State {
    override def next(c: Char): State = {
      if (c.isDigit) {
        State7
      } else if (c == ' ') {
        State6
      } else {
        Fail
      }
    }
  }

  case object State8 extends State {
    override def next(c: Char): State = {
      if (c.isDigit) {
        State7
      } else {
        Fail
      }
    }

    override def end: Boolean = false
  }

  case object State9 extends State {
    override def next(c: Char): State = {
      if (c.isDigit) {
        State4
      } else {
        Fail
      }
    }

    override def end: Boolean = false
  }

}
