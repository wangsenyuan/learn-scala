package set0000.set400.set460.p468

object Solution {
  def validIPAddress(IP: String): String = {
    if(validIpV4(IP)) {
      "IPv4"
    } else if(validIpV6(IP)) {
      "IPv6"
    } else {
      "Neither"
    }
  }

  private def validIpV4(str: String): Boolean = {
    if(str.startsWith(".") || str.endsWith(".")) {
      false
    } else {
      val ss = str.split("\\.")
      if(ss.length != 4) {
        false
      } else {
        ss.forall(validIpV4Part)
      }
    }
  }

  private def validIpV4Part(s: String): Boolean = {
    if(s.isEmpty) {
      false
    } else if(s.length > 1 && s(0) == '0') {
      false
    } else if(!s.forall(Character.isDigit)) {
      false
    } else {
      var num = 0
      for {
        i <- s.indices
      } {
        num = num * 10 + s(i) - '0'
      }
      num >= 0 && num < 256
    }
  }

  private def validIpV6(str: String): Boolean = {
    if(str.startsWith(":") || str.endsWith(":")) {
      false
    } else {
      val ss = str.split(":")
      if(ss.length != 8) {
        false
      } else {
        ss.forall(validIpV6Part)
      }
    }
  }

  private def validIpV6Part(s: String): Boolean = {
    if(s.isEmpty) {
      false
    } else if(s.length > 4) {
      false
    } else if(!(s.forall(hex(_)))) {
      false
    } else {
      true
    }
  }

  private def hex(c: Char): Boolean = {
    if(c >= '0' && c <= '9') {
      true
    } else if(c >= 'a' && c <= 'f') {
      true
    } else if(c >= 'A' && c <= 'F') {
      true
    } else {
      false
    }
  }
}
