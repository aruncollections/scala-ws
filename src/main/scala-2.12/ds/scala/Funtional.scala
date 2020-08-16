package ds.scala

object Funtional extends App {

  val sqrt = (x:Int) => {x*x}
  val sum = (x:Int) => {x+x}

  def lamda(a:Int)(x:Int => Int) = {
      x(a)
  }

  println(lamda(10)(sqrt))
  println(lamda(10)(sum))

  val list = 1::2::3::4::5::Nil

  val res = list.foldRight(List.empty[Int])((a,b) => {println(a,b); b.:+(a)})
  println(res)
}
