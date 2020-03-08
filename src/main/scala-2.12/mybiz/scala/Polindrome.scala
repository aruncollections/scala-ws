package mybiz.scala

/**
  * Created by arunprasath on 6/11/17.
  */
object Polindrome extends App {

  def isPolindrome(s: String) : Boolean = {
    val str = s.toList

    str match  {
      case head::Nil => true;
      case head::tail if !tail.isEmpty => println(head, tail); if(!head.equals(tail.last)) false  else isPolindrome(tail.init.mkString);
      case Nil => true
    }

  }

  println("is it ? " + isPolindrome("1234554321"))
}
