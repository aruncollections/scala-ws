package mybiz.scala.ds.tree

import scala.collection.mutable
import scala.io.Source

/**
  * Created by arunprasath on 6/10/17.
  */
object NumWords extends App {

  type MutableMap = Map[String, Int]


  wordCound()

  def wordCound(): Unit = {
    try {
      val content = Source.fromFile("/Users/arunprasath/Desktop/Mail Draft.txt").getLines()

      val map = mutable.HashMap

      val result = content.flatMap(_.split(" +")).foldLeft(Map.empty[String, Int]) {
        (countMap, word) => countMap + (word -> (countMap.getOrElse(word, 0) + 1))
      }

      // result.foreach(println)

      result.toSeq.sortBy(_._1).toSeq.map( x => "" + x._1 + " - " + x._2 + ";").foreach(println)

      /*val content = Source.fromFile("/Users/arunprasath/Desktop/Mail Draft.txt").getLines()
      countWords(content.flatMap(_.split("\\s+")).toList, mutable.Map.empty[String, Int]).foreach(println)
      //content.toList.sorted.foreach(println _)

      //val result1 = content.flatMap(_.split("\\s+")).toList.groupBy((word: String) => word).mapValues(_.length)
      //result1.foreach(println)*/

    } catch {
      case e: Throwable => println("IO issue " + e)
    }
  }


  def countWords(line: List[String], argMap: mutable.Map[String, Int]): mutable.Map[String, Int] = {

    line match {
      case head :: tail => {
        //println(head, tail)
        argMap.getOrElse(head, 0);
        argMap.put(head, (argMap.getOrElse(head, 0) + 1))
        //println(argMap)
        countWords(tail, argMap)
      }
      case Nil => println("Nil")
    }

    argMap
  }


  def testImplicit() {
    import utils.StringImprovements
    println("1 0 ".toOptionInt.getOrElse(0))
  }

}

package object utils {

  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)

    def toOptionInt: Option[Int] = {
      try {
        s match {
          case x: String => Some(x.trim.toInt)
          case _ => None
        }
      } catch {
        case _: Throwable => None
      }
    }
  }

}



