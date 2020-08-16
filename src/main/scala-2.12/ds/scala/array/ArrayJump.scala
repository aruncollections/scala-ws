package ds.scala.array

object ArrayJump extends App {
  println("Win: " + jump(List(1, 2, 0, 2, 1, 2,10), 0))

  def jump(list: List[Int], index: Int): Int = {
    list match {
      case l: List[Int] => {
        val head = l(index)
1/**/
        val indexUntil = head + index
        println(s"h: $head, nextIndex: $index, indexUntil: $indexUntil")

        if (indexUntil < (l.length - 1) && head != 0) {
          jump(l, indexUntil)
        } else if (indexUntil == (l.length - 1)) {
          0
        } else {
          -1
        }
      }

      case _ => -2
    }
  }

}
