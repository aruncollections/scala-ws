package ds.scala

import scala.collection.mutable.ArrayBuffer

object DeleteDuplicatesSortedArray extends App {
  //deleteDuplicatesSortedArray(Array(1, 2, 3, 3, 4, 4, 4, 5, 5, 6))
  deleteDuplicatesSortedList(ArrayBuffer(1, 2,3,4,4))

  def deleteDuplicatesSortedArray(arr: Array[Int]): Unit = {
    var current = 0

    for (i <- 0 until arr.length) {
      if (arr(i) != current) {
        current = arr(i)
      } else {
        arr(i) = 0
      }
    }

    arr foreach print
  }

  def deleteDuplicatesSortedList(arr: ArrayBuffer[Int]): Unit = {
    var current = 0

    for (i <- 0 until arr.size) {
      if (arr(i) != current) {
        current = arr(i)
      } else {
        arr.remove(i)
      }

      //print(current)
    }

    arr foreach print
  }

  // Does not work
  def deleteDuplicatesSortedArray3(arr: Array[Int]): Unit = {
    var i = 0

    for (j <- 1 until arr.length) {
      if (arr(i) != arr(j)) {
        i += 1
        arr(i) = arr(j)

      }
    }

    arr foreach print
  }

}
