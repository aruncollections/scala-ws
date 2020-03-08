package mybiz.scala.codetest.stack

object Main {
  def main(args: Array[String]): Unit = {

    val stack = new Stack()
    stack.push(5)
    stack.push(4)
    stack.push(3)
    stack.push(2)
    stack.push(1)
    stack.push(12)

    stack.printStack
    println("Min: ", stack.min)

    println("popped: ", stack.pop1())
    println("Min: ", stack.min)
    stack.printStack

    println("popped: ", stack.pop1())
    println("Min: ", stack.min)
    stack.printStack
  }

  class Stack {

    private val values  = Array.ofDim[Int](10)
    private val minValues  = Array.ofDim[Int](10)
    private var top = 0
    private var minTop = 0
    private var minimum = 0


    def push(value: Int): Unit = {
      values(top) = value

      minimum = if(value < minimum ) {
        minValues(minTop) = value;
        minTop += 1
        value
      } else minimum

      top += 1
    }


    def pop(): Int = {
      top -= 1
      val popped = values(top)
      values(top) = 0

      minimum = if(popped <= minimum ) {
        println("popped ", popped)
        minTop -= 1
        minValues(minTop) = 0
        minimum = minValues(minTop - 1)
        minimum
      } else { minimum }

      println("minimum reset ", minimum)

      popped
    }

    def pop1() = {
      top -= 1
      val popped = values(top)
      values(top) = 0

      println("debug: min: ", minimum, popped, ((2 * minimum) - popped))
      minimum = if(popped <= minimum) 2 * minimum - popped else minimum

      popped
    }

    def printStack: Unit = {
      println("\nStack")
      values.foreach(x => print(x + ","))
      println("\nMin Stack")
      minValues.foreach(x => print(x + ","))
      println("\n")
    }


    def min(): Int = {
      minimum
    }
  }
}
