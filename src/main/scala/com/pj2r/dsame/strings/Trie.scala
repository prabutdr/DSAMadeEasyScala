package com.pj2r.dsame.strings

class Trie {
  val root = Node()

  /**
    * To insert a key into a Trie
    *
    * @param key
    */
  def insert(key: String): Unit = {
    var cNode = root
    for (ch <- key) {
      if (cNode(ch) == null) 
        cNode(ch) = Node()
    
      cNode = cNode(ch)
    }

    cNode.isEnd = true
  }

  /**
    * To search a key in Trie
    *
    * @param key
    * @return
    */
  def search(key: String): Boolean = {
    var cNode = root
    for (ch <- key) {
      println(ch + ": " + cNode)
      cNode = cNode(ch)
      if (cNode(ch) == null) return false
    }

      println(cNode)
    cNode != null && cNode.isEnd
  }

  class Node {
    val children = Array.ofDim[Node](Node.alphabetSize)
    var isEnd = false

    def apply(ch: Char): Node = {
      val index = (ch.toInt - 'a') % 26
      children(index)
    }

    def update(ch: Char, child: Node): Unit = {
      children((ch.toInt - 'a') % 26) = child
    }

    override def toString(): String = {
      val buffer = new StringBuilder("Node(");
      for (i <- 0 until Node.alphabetSize) {
        if (children(i) != null) 
          buffer.append(('a' + i).toChar).append(", ").append(if (children(i).isEnd) "" else "*")
      }
      buffer.append(")")
      buffer.toString()
    }
  }

  object Node {
    val alphabetSize = 26

    def apply(): Node = new Node
  }
}

object Trie {
  def apply(): Trie = new Trie
}