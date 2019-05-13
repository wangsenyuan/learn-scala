package set600.set640.p649

import scala.collection.mutable.ArrayBuffer

object Solution {

  def predictPartyVictory(senate: String): String = {

    var buf = ArrayBuffer.empty[Char]

    buf.append(senate: _*)

    var back = ArrayBuffer.empty[Char]

    var finish = false

    while (!finish) {
      var i = 0
      var r = 0
      var d = 0
      back.clear()
      while (i < buf.length) {
        if (buf(i) == 'R') {
          if (d <= r) {
            // this senate should be kept
            back += 'R'
          }
          r += 1
        } else {
          if (r <= d) {
            back += 'D'
          }
          d += 1
        }

        i += 1
      }

      buf.clear()
      if (r > d) {
        // more dire need be removed
        i = 0
        while (i < back.length) {
          if (back(i) == 'R') {
            buf += 'R'
          } else if (r > d) {
            d += 1
          } else {
            buf += 'D'
          }
          i += 1
        }
      } else if (r < d) {
        // more r need be removed
        i = 0
        while (i < back.length) {
          if (back(i) == 'D') {
            buf += 'D'
          } else if (d > r) {
            r += 1
          } else {
            buf += 'R'
          }
          i += 1
        }
      } else {
        buf.appendAll(back)
      }

      i = 1
      while (i < buf.length && buf(i) == buf(0)) {
        i += 1
      }
      finish = i == buf.length
    }


    if (buf(0) == 'R') {
      "Radiant"
    } else {
      "Dire"
    }
  }
}
