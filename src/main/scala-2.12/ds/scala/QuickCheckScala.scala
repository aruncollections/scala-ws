package ds.scala

import scala.collection.mutable.ArrayBuffer

object QuickCheckScala extends App {
  // println(reverseRec("abc", 1))

  def reverseRec(str: String, count: Int, result: String = ""): String = {
    if (count == 0)
      return result

    if (str == null)
      return result

    println(str, count)
    reverseRec(str.substring(1, count), (count - 1), str(0) + result)
  }

  def compressTailRecursive[A](ls: List[A]): List[A] = {

    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil => result.reverse
    }

    compressR(Nil, ls)
  }


  def sum(i: Int, l: List[Int]): Int = {

    l match {
      case head :: tail => sum(i + head, tail)
      case Nil => i
    }
  }


  // println(sumToTarget(Array(1,3,4,0,0,6,7,3), 10))

  def sumToTarget(arr: Array[Int], target: Int): Tuple2[Int, Int] = {

    val map = scala.collection.mutable.Map[Int, Int]()

    for (x <- 0 until arr.length) {

      if (map.contains(arr(x))) {
        return (map(arr(x)), x)
      } else {
        val v = target - arr(x)
        map(v) = x
        println(map)
      }

    }

    return null;
  }

  //println(reverse("abcd", ""))


  def reverse(str: String, result: String): String = {

    str.toList match {
      case Nil => return result

      case head :: Nil => reverse("", head + result)

      case x :: y => reverse(y.mkString, x + result)
    }
  }


  def permutations1(s: String): List[String] = {
    def merge(ins: String, c: Char): Seq[String] =
      for (i <- 0 to ins.length) yield
        ins.substring(0, i) + c + ins.substring(i, ins.length)


    if (s.length() == 1)
      List(s)
    else
      permutations1(s.substring(0, s.length - 1)).flatMap { p =>
        merge(p, s.charAt(s.length - 1))
      }
  }

  // permutations("abc".toList).foreach(x => println(x.mkString))

  def permutations(lst: List[Char]): List[List[Char]] = lst match {
    case Nil => List(Nil)
    case x :: xs => permutations(xs) flatMap { sub =>
      ((0 to xs.length) flatMap { num =>
        List(sub, (sub.take(num)) ++ List(x) ++ (sub.drop(num))).filter(_.length == lst.size)
      }).distinct
    }
  }

}
