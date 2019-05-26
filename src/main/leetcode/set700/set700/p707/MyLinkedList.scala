package p707

class MyLinkedList() {

  var head: Node = null
  var tail: Node = null
  /** Initialize your data structure here. */


  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  def get(index: Int): Int = {
    def loop(node: Node, i: Int): Int = {
      if (node == null) {
        -1
      } else if (i == index) {
        node.value
      } else {
        loop(node.next, i + 1)
      }
    }

    loop(head, 0)
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  def addAtHead(`val`: Int) {
    if (head == null) {
      head = new Node(`val`)
      tail = head
    } else {
      val newHead = new Node(`val`)
      newHead.next = head
      head.prev = newHead
      head = newHead
    }
  }

  /** Append a node of value val to the last element of the linked list. */
  def addAtTail(`val`: Int) {
    if (tail == null) {
      tail = new Node(`val`)
      head = tail
    } else {
      val newTail = new Node(`val`)
      tail.next = newTail
      newTail.prev = tail
      tail = newTail
    }
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  def addAtIndex(index: Int, `val`: Int) {
    if (index == 0 && head == null) {
      addAtHead(`val`)
    } else if (index > 0) {
      def loop(node: Node, i: Int): Unit = {
        if (node != null) {
          if (i < index) {
            loop(node.next, i + 1)
          } else {
            val prev = node.prev
            val cur = new Node(`val`)
            prev.next = cur
            cur.prev = prev
            cur.next = node
            node.prev = cur
          }
        } else if (i == index) {
          addAtTail(`val`)
        }
      }

      loop(head, 0)
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  def deleteAtIndex(index: Int) {
    def loop(node: Node, i: Int): Unit = {
      if (node != null) {
        if (i < index) {
          loop(node.next, i + 1)
        } else {
          val prev = node.prev
          val next = node.next
          if (prev == null && next == null) {
            // the head & tail
            head = null
            tail = null
          } else if (prev == null) {
            // the head
            next.prev = null
            head = next
          } else if (next == null) {
            // the tail
            prev.next = null
            tail = prev
          } else {
            // a internal node
            prev.next = next
            next.prev = prev
          }
          node.next = null
          node.prev = null
        }
      }
    }

    loop(head, 0)
  }

  class Node(val value: Int, var prev: Node, var next: Node) {
    def this(value: Int) = this(value, null, null)
  }

}


object Main {
  def main(args: Array[String]): Unit = {
    val list = new MyLinkedList()
    println(list.get(0))
    list.addAtIndex(1, 2)
    println(list.get(0))
    println(list.get(1))
    list.addAtIndex(0, 1)
    println(list.get(0))
    println(list.get(1))
  }
}
