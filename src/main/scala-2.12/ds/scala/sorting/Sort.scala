package ds.scala.sorting

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Sort extends App {

  test

  def test = {
    val random = scala.util.Random
    val list = (1 to 100).toList.map{x => random.nextInt(100)}
    println(s"Sorting: $list")

    println(bubble(mutable.ArrayBuffer(list: _*)))
    println(mergeSort(list))
  }



  def bubble(l: mutable.ArrayBuffer[Int]): mutable.ArrayBuffer[Int] = {
    val size = l.size - 1

    var swapped = false

    for {i <- 0 until l.length - 1} {

      if (l(i) > l(i + 1)) {
        swapped = true
        val temp = l(i)
        l(i) = l(i + 1)
        l(i + 1) = temp
      }
    }

    if (swapped) {
      bubble(l)
    } else {
      l
    }
  }


  def mergeSort(list: List[Int] ): List[Int] = {
    list match {
      case Nil => List()
      case x::Nil => List(x)
      case  x =>
        val (left, right) = (list.splitAt(list.length/2))
        val l = mergeSort(left)
        val r = mergeSort(right)
        merge(l, r)

    }
  }

  def merge(l1: List[Int], l2: List[Int], result: List[Int] = List.empty): List[Int] = {
    //println(l1, l2, result)
    (l1, l2) match {
      case (x, Nil) =>  result ++ x
      case (Nil, x) =>  result ++ x
      case (x::xTail, y::yTail) =>
          if(x < y ) {
            merge(xTail, l2, result ++ List[Int](x))
          } else {
            merge(l1, yTail, result ++ List[Int](y))
          }
    }
  }
}
