package ds.scala

/**
  * Created by arunprasath on 5/1/17.
  */


object BalancedString extends App {

  println("Testing 1: " + isBalanced("""[some][][][][](()br)(test).(y){testing{}}""".toList))
  println("Testing 2: " + isBalanced("""[some][][][][(()br)test).(y){testing{}}""".toList))
  println("Testing 3: " + isBalanced("""[some]{}(test)""".toList))
  println("Testing 4: " + isBalanced("""[some]{})test(""".toList))
  println("Testing 5: " + isBalanced("".toList))

  //println(braces(Array("{}()", "{[}]")).toList)
  println(braces(Array("{[xyz]}")).toList)

  // Using functional code without build in collections
  def isBalanced(chars: List[Char]): Boolean = {
    def check(chars: List[Char], braceCount: Int, squareBracketCount: Int, bracketCount: Int): Boolean = {
      //println(s"${braceCount}, ${squareBracketCount}, ${bracketCount}")

      if (chars.isEmpty) return braceCount == 0 && squareBracketCount == 0 && bracketCount == 0

      chars.head match {
        case '{' => check(chars.tail, braceCount + 1, squareBracketCount, bracketCount)
        case '}' => (braceCount + bracketCount + squareBracketCount) > 0 && check(chars.tail, braceCount - 1, squareBracketCount, bracketCount)
        case '[' => check(chars.tail, braceCount, squareBracketCount + 1, bracketCount)
        case ']' => (braceCount + bracketCount + squareBracketCount) > 0 && check(chars.tail, braceCount, squareBracketCount - 1, bracketCount)
        case '(' => check(chars.tail, braceCount, squareBracketCount, bracketCount + 1)
        case ')' => (braceCount + bracketCount + squareBracketCount) > 0 && check(chars.tail, braceCount, squareBracketCount, bracketCount - 1)
        case _ => check(chars.tail, braceCount, squareBracketCount, bracketCount)
      }
    }

    check(chars, 0, 0, 0)
  }


  def braces(values: Array[String]): Array[String] = {
    val result = scala.collection.mutable.ArrayBuffer[String]()

    def isBalanced(chars: String): Boolean = {
      val stack = scala.collection.mutable.Stack[Char]()

      for(v <- chars) {
        println(stack)

        v match {
          case '{' | '[' | '(' => stack.push(v)

          case ']' =>
            if (stack.isEmpty || stack.pop() != '[')
              return false

          case ')'=>
            if (stack.isEmpty || stack.pop() != '(')
              return false

          case '}'=>
            if (stack.isEmpty || stack.pop() != '{')
              return false

          case _ => Unit
        }
      }

      stack.isEmpty
    }

    values.map { isBalanced(_) }.map {v :Boolean => if(v == true) "YES" else "NO" }.toArray
  }

}

