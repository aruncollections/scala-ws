package ds.array

import scala.util.control.Breaks.*

object MoveZeros extends App {

  println(moveZeros(Array(1, 2, 0, 4, 0, 5, 0, 6, 1)).mkString(","))

  def moveZeros(array: Array[Int]): Array[Int] = {
    var i = 0
    var j = array.length - 1

    breakable {
      while (true) {
        while (array(i) != 0 && i < j) {
          i = i + 1
        }

        while (array(j) == 0 && i < j) {
          j = j - 1
        }

        if (i < j) {
          val temp = array(i)
          array(i) = array(j)
          array(j) = temp
        } else {
          break
        }
      }
    }

    return array;
  }

}
