package com.pj2r.dsame.intro

import org.scalatest.funsuite.AnyFunSuite
import com.pj2r.dsame.strings.Trie
import org.scalatest.BeforeAndAfter

class TrieTests extends AnyFunSuite with BeforeAndAfter {
  val trie = Trie()
  val trieKeys = Array("a");//, "all", "als", "as", "test")
  val keysNotInTries = Array();//"alll", "c", "asl", "sa", "test ")

  before {
    for (key <- trieKeys)
      trie.insert(key)
  }

  trieKeys.foreach({
    case (input) => {
      test(s"Trie has key - ${input}") {
        assert(trie.search(input));
      }
    }
  })

  keysNotInTries.foreach({
    case (input) => {
      test(s"Trie does not contain key - ${input}") {
        assert(!trie.search(input));
      }
    }
  })
}