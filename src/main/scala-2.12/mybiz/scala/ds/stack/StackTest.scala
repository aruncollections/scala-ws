package mybiz.scala.ds.tree.stack


import scala.collection.mutable.Stack

object StackTest extends App {

  test

  def test = {
    val stack1 = Stack(3,4,1,5, 23,34,454,65,2,0,343)
    val stack2 = Stack[Int]()

    var (s1,s2, swapping) = sort(stack1, stack2)

    println("init: " + (s1, s2, swapping))

    while(swapping) {
      var (st1,st2, swapped) = sort(s2.reverse, s1)
      s1 = st1
      s2 = st2
      swapping = swapped
    }

    println("Res: " + s2)

  }

  def sort(s1:Stack[Int], s2:Stack[Int]) = {
    var swapped = false
    // println("\n" + (s1, s2, swapped))

    var temp:Option[Int] = None

    while(!s1.isEmpty) {
      var s1Top = s1.pop

      if(temp.isEmpty) {
        temp = Some(s1Top)

        if(!s1.isEmpty)
          s1Top  = s1.pop
      }

      if(temp.get < s1Top) {
        s2.push(temp.get)
        temp = Some(s1Top)
      } else {
        swapped = true
        s2.push(s1Top)
      }

      if(s1.isEmpty) s2.push(temp.get)

    }

    //System.exit(0)
    // println(s1, s2, swapped)
    (s1, s2, swapped)
  }

}


