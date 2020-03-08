package mybiz.scala.ds.tree

/**
  * Created by arunprasath on 6/11/17.
  */
object Closure {
  def main(args: Array[String]) {
    println( "multiplier(1) value = " +  multiplier(1) )
    println( "multiplier(2) value = " +  multiplier(2) )
  }
  var factor = 3
  val multiplier = (i:Int) => i * factor
  factor = 4;

}
