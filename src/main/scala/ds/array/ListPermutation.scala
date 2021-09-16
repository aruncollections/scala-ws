package ds.array

import scala.+:
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object ListPermutation extends App {
  var result = List[List[Int]]()
  println("result: " + permutation((1 to 3).toList))

  def permutation(list: List[Int],
                  sub: ListBuffer[Int] = ListBuffer(),
                  count: Int = 1) : List[List[Int]] = {
    println(s"perm => list: $list | result: $result | sub: $sub")

    if(list.isEmpty) println("Empty list...")

    for (i <- 0 until list.size) {
      sub += list(i)
      result = result :+ sub.toList
      //println(s"\tB | i:$i, c: $count | initial list: $list |  result: $result | sub: $sub")
      permutation(list.tail, sub, count + 1)
      //result = result :+ sub.toList
      sub.remove(sub.size - 1)
      //println(s"\tA | i:$i, c: $count | initial list: $list |  result: $result | sub: $sub")
    }

    return result
  }


  /*def permutation(list: List[Int],
                  temp: mutable.ListBuffer[Int] = mutable.ListBuffer(),
                  result: mutable.ListBuffer[mutable.ListBuffer[Int]] = mutable.ListBuffer()): mutable.ListBuffer[mutable.ListBuffer[Int]] = {

    for (i <- 0 until list.size) {
      var sub = mutable.ListBuffer[Int]()
      var temp = mutable.ListBuffer[Int]()

      for (j <- i until list.size) {
        sub = sub :+ list(j)
        println(s"i: $i,  j $j, sub: $sub ")

        if(result.contains(temp)) {
          //temp = temp.init
        }

        if (j == list.length - 1) {
          temp ++= sub
          permutation(temp.init.toList, temp, result += sub)
          println()
        }
      }
    }

    return result
  }*/
}

