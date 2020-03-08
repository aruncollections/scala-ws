package mybiz.scala.ds.tree

import scala.annotation.tailrec

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  // @tailrec /* This is not tail-recursive!!... */
  def size_bad(t: Tree[Int]): Int =
    t match {
      case Leaf(a) => 1
      case Branch(a, b) => size_bad(a) + size_bad(b) + 1
    }

  def size(t: Tree[Int]): Int = {
    print("tree: " + t)
    @tailrec
    def inner_size(l: List[Tree[Int]], acc: Int): Int = {
      println(s"List: $l")

      l match {
        case Nil => acc
        case Leaf(v) :: ls => println("leaf : ", v, ls); inner_size(ls, acc + 1)
        case Branch(a, b) :: ls => println(s"branch: a: $a, b: $b, ls: $ls"); inner_size(a :: b :: ls, acc + 1)
      }
    }


    inner_size(List(t), 0)
  }
}


object TreeTest extends App {
  val example =
    Branch(
      Branch(
        Branch(
          Leaf(1),
          Leaf(3)),
        Branch(
          Branch(
            Leaf(4),
            Leaf(5)),
          Leaf(7))), Leaf(0))

   /* Branch(
      Branch(
        Branch(
          Leaf(1),
          Leaf(3)),
        Branch(
          Branch(
            Leaf(4),
            Leaf(5)),
          Leaf(7))),
      Branch(
        Branch(
          Branch(
            Leaf(9),
            Branch(
              Leaf(10),
              Leaf(3))),
          Leaf(0)),
        Leaf(2)))*/

  println(example)
  // println("sum (baad):"+ Tree.size_bad(example))
  println("sum (good):"+ Tree.size(example))
}