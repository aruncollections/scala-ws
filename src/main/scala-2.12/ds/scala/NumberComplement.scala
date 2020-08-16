package ds.scala

import scala.annotation.tailrec

/**
  * Created by arunprasath on 5/1/17.
  */
object NumberComplement extends App {

  println("Test1: " + getIntegerComplement(100))
  println("Test2: " + getIntegerComplement(50))

  // Curried while function for custom while loop
  @tailrec
  def myWhile(testCondition: => Boolean)(codeBlock: => Unit) {
    if (testCondition) {
      codeBlock
      myWhile(testCondition)(codeBlock)
    }
  }

  def getIntegerComplement(n: Int) = {
    var mask: Int = 1

    myWhile(mask < n) {
      //println(mask)
      mask = (mask << 1) | 1
    }

    ~n & mask;
  }

}
