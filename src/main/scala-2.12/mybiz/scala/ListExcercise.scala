package mybiz.scala

object ListExcercise extends App {


  //println("result ", penultimate( 1 to 10 toList))

  def penultimate[A](list: List[A]): A = {
    println(list.getClass)
    list match {
      case h :: t :: Nil => h
      case head :: penul :: tail => println(head, penul, tail); penultimate(tail)
      case _  => throw new NoSuchElementException
    }
  }


  //println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => println("ms: ", ms); flatten(ms)
    case e => println("e: ", e);List(e)
  }

  println(rotate(1 to 10 toList))

  def rotate[A](list: List[A]) : List[A] = {
    def _rotate[A](n:Int, list: List[A]) : List[A] = (n, list) match {
      case (0, l: List[_]) => l
      case (num, h::tail) => _rotate(n-1, tail :+ h)
    }

    _rotate(5, list)
  }

}
