package set0000.set700.set700.p707

class MyLinkedList() {

  class Node(val value: Int) {
    var prev: Node = null
    var next: Node = null
  }

  val head = new Node(-1)
  val last = new Node(-1)

  head.next = last
  last.prev = head

  var size = 0

  /** Initialize your data structure here. */

  private def getFromBegin(index: Int): Node = {
    var i = 0
    var node = head.next
    while (i < index) {
      node = node.next
      i += 1
    }
    node
  }

  private def getFromEnd(index: Int): Node = {
    var i = size - 1
    var node = last.prev
    while (i > index) {
      node = node.prev
      i -= 1
    }
    node
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  def get(index: Int): Int = {
    if (index < 0 || index >= size) {
      -1
    } else if (index * 2 < size) {
      getFromBegin(index).value
    } else {
      getFromEnd(index).value
    }
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  def addAtHead(`val`: Int) {
    val node = new Node(`val`)
    node.next = head.next
    head.next.prev = node
    head.next = node
    node.prev = head
    size += 1
  }

  /** Append a node of value val to the last element of the linked list. */
  def addAtTail(`val`: Int) {
    val node = new Node(`val`)
    node.prev = last.prev
    last.prev.next = node
    last.prev = node
    node.next = last
    size += 1
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  def addAtIndex(index: Int, `val`: Int) {
    if (index <= size) {
      if (index <= 0) {
        addAtHead(`val`)
      } else if (index == size) {
        addAtTail(`val`)
      } else {
        val node = new Node(`val`)
        val cur =
          if (index * 2 < size) {
            getFromBegin(index)
          } else {
            getFromEnd(index)
          }
        val prev = cur.prev
        prev.next = node
        node.prev = prev
        node.next = cur
        cur.prev = node
        size += 1
      }
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  def deleteAtIndex(index: Int) {
    if (index >= 0 && index < size) {
      val node =
        if (index * 2 < size) {
          getFromBegin(index)
        } else {
          getFromEnd(index)
        }
      val prev = node.prev
      val next = node.next
      prev.next = next
      next.prev = prev
      size -= 1
    }
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
