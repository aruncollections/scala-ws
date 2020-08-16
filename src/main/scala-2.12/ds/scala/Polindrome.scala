package ds.scala

/**
  * Created by arunprasath on 6/11/17.
  */
object Polindrome extends App {

  println("is it ? " + isPolindrome("1234554321"))

  def isPolindrome(s: String) : Boolean = {
    val str = s.toList

    str match  {
      case head::Nil => true;
      case head::tail if !tail.isEmpty => println(head, tail); if(!head.equals(tail.last)) false  else isPolindrome(tail.init.mkString);
      case Nil => true
    }

  }

  def poisPolindrome2(): Boolean = {
    val s = "anutforajaroftuna"
    val end = s.length - 1

    for (start <- 0 to end) {
      if (start <= end && s(start) == s(end - start)) {
        println(true)
      } else
        return false
    }

    true
  }
}


