package mybiz.scala

import org.scalatest.FunSuite

class MyFunSuite extends FunSuite {

  test("check list size ") {
    assert(List.empty.size == 0)
  }

  test("Throws exception") {
    assertThrows[NoSuchElementException](List.empty.head)
  }
}
