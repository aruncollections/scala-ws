package ds.scala

/**
  * Created by arunprasath on 5/6/17.
  */

import scala.util.control.Breaks._

object PrimeNumbers extends App {

  for (n <- 1 to 100) {
    if (isPrimeBreakable(n))
      println("isPrime " + n)
  }

  def isPrime(num: Int): Boolean = {
    if (num == 0 || num < 1 || num == 1) return true

    for (n <- 2 until num) {
      if (num % n == 0) return false;
    }

    return true;
  }

  def isPrimeBreakable(num: Int): Boolean = {
    if (num == 0 || num < 1 || num == 1) return true

    var result = true
    breakable {
      for (n <- 2 until num) {
        if (num % n == 0) {
          result = false
          break;
        }
      }

    }
    return result;
  }
}
