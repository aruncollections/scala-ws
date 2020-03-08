/**
  * Created by arunprasath on 6/12/17.
  */
object GetPairsCount extends App {


  println(getPair(9, List(10, 20, 20, 10, 10, 30, 50, 10, 20)))

  def getPair(total: Int, list: List[Int]): Int = {
    val socksMap = list.map(_.toString).groupBy((n) => n).mapValues(_.size)
    println(socksMap)

    var sum = 0

    for ((k, v) <- socksMap) {
      (v) match {
        case v: Int if v % 2 == 0 => sum += v / 2
        case v: Int if v > 1 && v % 2 == 1 => sum += v / 2
        case _ => println()
      }

    }

    sum
  }


}
