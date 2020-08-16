package ds.scala

sealed abstract class Tree[+T]

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
}

case object End extends Tree[Nothing] {
  override def toString = "."
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object TestingTree extends App {
  val tree = Node('a',
    Node('b', Node('d'), Node('e')),
    Node('c', End, Node('f', Node('g'), End)))

  println(tree)
}