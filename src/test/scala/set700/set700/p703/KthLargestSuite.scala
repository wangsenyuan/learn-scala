package set700.set700.p703

import junit.framework.Assert
import org.junit.Test
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers

class KthLargestSuite extends JUnitSuite with Checkers {

  @Test
  def testSample1(): Unit = {
    val nums = Array(4, 5, 8, 2)
    val k = 3
    val target = new KthLargest1(k, nums)
    var res = target.add(3)
    Assert.assertEquals(4, res)
    res = target.add(5)
    Assert.assertEquals(5, res);
    res = target.add(10)
    Assert.assertEquals(5, res)
    res = target.add(9)
    Assert.assertEquals(8, res)
    res = target.add(4)
    Assert.assertEquals(8, res)
  }

  @Test
  def testSample2(): Unit = {
    val nums = Array(1, 1)
    val k = 3
    val target = new KthLargest1(k, nums)
    var res = target.add(1)
    Assert.assertEquals(1, res)
    res = target.add(1)
    Assert.assertEquals(1, res);
    res = target.add(3)
    Assert.assertEquals(1, res)
    res = target.add(3)
    Assert.assertEquals(1, res)
    res = target.add(3)
    Assert.assertEquals(3, res)
    res = target.add(4)
    Assert.assertEquals(3, res)
    res = target.add(4)
    Assert.assertEquals(3, res)
    res = target.add(4)
    Assert.assertEquals(4, res)
  }
}
