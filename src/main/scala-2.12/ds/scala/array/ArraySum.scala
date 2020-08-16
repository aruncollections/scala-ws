package ds.scala.array

import scala.util.Try

object ArraySum extends App {
  val a = List(9,9,9,9)
  val b = List(0,0,0,1)

  val maxLength = if (a.length > b.length) a.length else b.length
  val result = Array.ofDim[Int](maxLength)
  var carry = 0

  for (i <- 0 until maxLength reverse) {
    val x = a(i)
    val y = Try(b(i)).getOrElse(0)

    val sum = x + y + carry

    if (sum >= 10) {
      carry = sum / 10
      result(i) = sum % 10
    } else {
      carry = 0
      result(i) = sum
    }
  }

  if (carry != 0) {
    List(carry) ++ result.toList foreach print
  } else {
    result foreach print
  }
}
