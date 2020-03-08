package mybiz.scala.codetest.stack


trait Comparator[T] {
  def <(v: T, v1: T): Boolean
}

object Implicits {
  implicit object comparator extends Comparator[Int] {
    override def <(v: Int, v1: Int): Boolean = v < v1
  }

  /*implicit val comparatorInt = new Comparator[Int] {
    override def <(v: Int, v1: Int): Boolean = v < v1
  }*/
}

class Node[T](val value: T, val next: Node[T], val min: T) {
  def <(value2: T)(implicit comp: Comparator[T]) = comp.<(value, value2)
}

class StackBox[T]() {

  var node: Node[T] = null

  def push(newValue: T): Unit = {
    if (node == null) {
      node = new Node(newValue, null, newValue)
    } else {
      val v = if (node.min.asInstanceOf[Int] < newValue.asInstanceOf[Int]) {
        //println(s"Finding smaller: ${node.min}, $newValue = "  + node.min)
        node.min
      } else {
        //println(s"Finding smaller: ${node.min}, $newValue = "  + newValue)
        newValue
      }

      node = new Node(newValue, node, v)
    }
  }

  def pop(): T = {
    if(node == null) {
      throw new RuntimeException()
    }

    val res = node.value
    node = node.next
    res
  }

  def peek() : T = {
    if(node == null) {
      throw new RuntimeException()
    }

    node.value
  }

  def min() : T = {
    if(node == null) {
      throw new RuntimeException()
    }

    node.min
  }

  def printStack: Unit = {
    println()
    var n = node
    while (n != null) {
      print("<-" + (n.value, n.min))
      n = n.next
    }
  }

}

object Test extends App {
  val stack = new StackBox[Int]
  stack.push(0)
  stack.push(1)
  stack.push(2)
  stack.printStack
  println("\nPop: " + stack.pop())
  println("Pop: " + stack.pop())
  println("Min: " + stack.min)
  stack.printStack
  stack.push(-2)
  stack.push(20)
  stack.push(11)
  stack.push(2)
  println()
  println("Min: " + stack.min)
  stack.printStack
  stack.push(-100)
  stack.printStack
  println("\nPop: " + stack.pop())
  stack.printStack
}