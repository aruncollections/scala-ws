package ds.scala

/**
  * Created by arunprasath on 5/12/17.
  */
object Factorial extends App {

  //println("factorial: " + compute(1 to 5 toList))
  //println("factorial: " + compute(List(0)))

  println("factorial: " + factorial(5))
  println("factorial: " + factorial2(5, 1))


  def compute(list: List[Int]): Int = {
    println(list)
    list match {
      case head :: tail => println(head + " || " + tail); if(head ==0 ) 1 else head * compute(tail)
      case head :: Nil => println(head); head
      case Nil => println("Empty"); 1
    }
  }

  def factorial(num: Int): Int = {
    def compute1(x: Int, y: Int): Int = {
      if (x == 0) {
        y
      }
      else {
        compute1(x - 1, x * y)

      }
    }

    compute1(num, 1)
  }

  def factorial1(n: Int): Int = n match {
    case 0 => 1
    case _ => n * factorial(n-1)
  }


  def factorial2(n: BigInt, result: BigInt): BigInt = if (n == 0) result else factorial2(n - 1, n * result)
}
