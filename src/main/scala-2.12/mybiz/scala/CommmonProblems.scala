package mybiz.scala

import scala.collection.mutable
import scala.concurrent.Await

/**
  * Created by arunprasath on 5/23/17.
  *
  * http://blog.thedigitalcatonline.com/blog/2015/04/07/99-scala-problems-02-find-last-nth/
  *
  * http://aperiodic.net/phil/scala/s-99/
  *
  */
object CommmonProblems extends App {


  println(reverse(1 to 10 toList))
  //println(sum((1 to 10).toList, 0))


  def reverse[A](l: List[A]): List[A] = l match {
    case h :: tail => {
      println(h);
      reverse(tail) ::: List(h)
    }
    case Nil => Nil
  }

  def penultimate[A](l: List[A]): A = l match {
    case h :: List(t) => {
      println("h::List");
      h
    }

    case _ :: tail => {
      println("_::tail");
      penultimate(tail)
    }

    case _ => throw new NoSuchElementException
  }

  def sum(list: List[Int], acc: Int): Int = {
    list match {
      case Nil => println("Nil"); acc
      case head :: tail => println(tail, acc + head); sum(tail, acc + head)
      case _ => println("_ "); 0
    }
  }

  // println("Substring : " + substring("testing", 2,4))

  def substring(input: String, start: Int, end: Int): String = {
    val res = for (c <- 0 until input.length if c >= start && c <= end)
      yield input(c)

    res.mkString
  }

  //println("Contains: " + contains("playscala", "la1"))

  def contains(str: String, sub: String): Boolean = {
    try {
      if (!find(str, sub))
        contains(str.substring(1), sub)
      else
        true
    } catch {
      case _: Throwable => false
    }
  }

  def find(str: String, sub: String): Boolean = {
    println(str, sub)
    import scala.util.control.Breaks._
    var i = 0;

    sub toList match {
      case s => {
        for (c <- s) {
          if (!(sub(i) == str(i))) {
            println("return false ", sub(i), str(i))
            return false
          } else {
            println("return true ", sub(i), str(i))
          }

          i += 1
        }

        true
      }
    }
  }

  def twoSum(target: Int, list: List[Int]): (Option[Int], Option[Int]) = {
    import scala.util.control.Breaks._

    var index1 = None: Option[Int]
    var index2 = None: Option[Int]

    (index1, index2) match {
      case (None, None) =>
        breakable {
          for {num <- list
               next <- list.tail} {
            if (num < next && (num + next) == target) {
              index1 = Some(num)
              index2 = Some(next)
              break
            }
          }
        }

        twoSum(target, list.tail)
    }
  }


  import scala.concurrent.ExecutionContext.Implicits.global

}