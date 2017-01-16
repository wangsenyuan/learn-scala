package com.me.learn.bdd

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{Matchers, PropSpec}

import scala.collection.BitSet
import scala.collection.immutable.{HashSet, TreeSet}

/**
  * Created by wangsenyuan on 16/01/2017.
  */

class SetSpec extends PropSpec with TableDrivenPropertyChecks with Matchers {

  val examples =
    Table(
      "set",
      BitSet.empty,
      HashSet.empty[Int],
      TreeSet.empty[Int]
    )

  property("an empty Set should have size 0") {
    forAll(examples) { set =>
      set.size should be(0)
    }
  }

  property("invoking head on an empty set should produce NoSuchElementException") {
    forAll(examples) { set =>
      a[NoSuchElementException] should be thrownBy {
        set.head
      }
    }
  }
}
