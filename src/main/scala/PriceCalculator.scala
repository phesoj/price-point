
case class Product(name: String, originalPrice: Int, minimumPrice: Int, maximumPrice: Int, newPrice: Option[Int])

object PriceCalculator {

  val PricePoints = Set(3, 5, 9)

  def calculatePrice(product: Product, pricePoints: Set[Int]): Product = {
    val potentialPrices = getRangeOfPrices(product, pricePoints).toList.sorted
    val closestPrice = findNearestPricePoint(product.originalPrice, potentialPrices)
    product.copy(newPrice = closestPrice)
  }

  def findNearestPricePoint(originalPrice: Int, potentialPrices: List[Int]) =
   Some(potentialPrices.minBy(potentialPrice => math.abs(potentialPrice - originalPrice)))


   def getRangeOfPrices(product: Product, pricePoints: Set[Int]): Set[Int] = {
    val validPriceRange = product.minimumPrice to product.maximumPrice
    def checkRange(pricePoint: Int): Set[Int] =
      validPriceRange.map(validPrice => if (validPrice % 10 == pricePoint) validPrice else 0).toSet

    pricePoints.map(pricePoint => checkRange(pricePoint)).flatten
  }

}
