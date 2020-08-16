package ds.scala.codetest

import scala.annotation.tailrec

/**
  * Created by arunprasath on 5/1/17.
  */
object BinarySearchTree {

  //@tailrec
  def isPresent(node: Node, value: Int): Int = {
    if (value == node.data)
      1
    else if (value < node.data) {
      if (node.left == null)
        0
      else
        return isPresent(node.left, value);
    } else if (value > node.data) {
      if (node.right == null)
        0
      else
         return isPresent(node.right, value);
    }

    0;
  }

}


sealed trait Tree
case class Node(data: Int, left: Node, right: Node) extends Tree
case object EmptyNode extends Tree

