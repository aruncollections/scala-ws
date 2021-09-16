package ds.array

import scala.collection.mutable

object SubSequences extends App {
  val in = (1 to 5).toList

  val result = mutable.ListBuffer[List[Int]]()

  for (i <- 0 until in.length) {
    var sub = List[Int]()
    for (j <- i until in.length) {
      sub = sub :+ in(j)
      // println(sub)
      result += sub
    }
  }

  println("res: " + result)
}
