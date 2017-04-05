package codechef.easy.ankparen

import org.scalatest.FlatSpec

/**
  * Created by wangsenyuan on 04/04/2017.
  */
class RegularStrSpec extends FlatSpec {

  "()" should "be regular" in {
    assert(Main.isRegular("()"))
  }

  "())" should "be irregular" in {
    assert(!Main.isRegular("())"))
  }
}
