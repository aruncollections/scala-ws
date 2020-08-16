package ds.scala

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.annotation.tailrec

/**
  * Created by arunprasath on 5/12/17.
  */
object Fibonacci extends App {

  var result = new ArrayBuffer[Int]()


  //println("fibonocci " + fib(2, 3, 6))

  def fib(x: Int, y: Int, count: Int) = {
    //println(result)
    compute(x, y, count - 2)
    result
  }

  def compute(prev: Int, next: Int, count: Int) {
    result ++= List(prev, next)
    val sum = prev + next

    //println(prev, next, count)

    if (count != 0) {
      //println("count : " + count)
      compute(sum, sum + next, count - 2)
    }

  }

  println(fibo(9))


  def fibo(x: Int): BigInt = {
    val y = fibHelper(x)
    println(y)
    y
  }

  @tailrec
  def fibHelper(x: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = x match {
    case 0 => prev
    case 1 => next
    case _ => println(prev, next); fibHelper(x - 1, next, (next + prev))
  }
}
