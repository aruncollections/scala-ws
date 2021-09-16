object RemoveDuplicates extends App {
  //removeDuplicates(Array(1, 1, 1, 2, 3, 3, 4, 4, 4, 5))
  removeDuplicates(Array(1, 1, 1, 2, 3, 3, 3, 6))

  def removeDuplicates(array: Array[Int]): Unit = {
    var slow = 0
    var fast = 0

    while (fast < array.size) {
      val value = array(fast)
      //println(s"\t value $value, fast $fast")
      while (fast < array.size && value == array(fast)) {
        fast = fast + 1
      }

      array(slow) = value
      slow = slow + 1
      // println(array.mkString(","))
    }

    while(slow < array.size) {
      array(slow) = 0
      slow = slow + 1
    }

    println(array.mkString(","))
  }
}