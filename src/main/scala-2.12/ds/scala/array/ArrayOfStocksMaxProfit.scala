package ds.scala.array

object ArrayOfStocksMaxProfit extends App {

  maxProfit(List(10, 100, 110, 120, 90, 80, 220))

  def maxProfit(list: List[Int]): Unit = {
    var maxProfit = 0
    var minPrice = 0
    var maxPrice = 0

    for (price <- list) {
      maxProfit = Math.max(price - maxPrice, maxProfit)
      maxPrice = Math.max(price, maxPrice)
      println(s"price $price, maxprofit $maxProfit, maxprice $maxPrice")
    }

    print(maxProfit)
  }
}
