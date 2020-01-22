package com.pj2r.dsame.intro

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class SumOfDigitsTests extends AnyFunSuite {
  val inputs = List(
    (12345, 15), 
    (1, 1),
    (0, 0), 
    (-123, 6), 
  );

  inputs.foreach({
    case (input, output) => {
      test(s"Sum of digit value of ${input} is ${output}") {
        assertResult(output)(SumOfDigits.sum(input))
      }
    }
  })

  test("More scenarios") (pending)
}