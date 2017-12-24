import org.scalatest._

class PriceCalculatorSpec extends FunSpec with Matchers {

  val pricePoints = Set(3, 5, 9)

  describe("A price calculator") {
    describe("passed a product A and some price points") {
      val actual = Product("A", 6889, 6885, 6905, None)
      val expected = Product("A", 6889, 6885, 6905, Some(6889))
      it("should return the product") {
        PriceCalculator.calculatePrice(actual, pricePoints) shouldEqual expected
      }
    }

    describe("passed a product B and some price points") {
      val actual = Product("B", 7197, 7192, 7198, None)
      val expected = Product("B", 7197, 7192, 7198, Some(7195))
      it("should return the product") {
        PriceCalculator.calculatePrice(actual, pricePoints) shouldEqual expected
      }
    }

    describe("passed a product C and some price points") {
      val actual = Product("C", 6997, 6996, 6998, None)
      val expected = Product("C", 6997, 6996, 6998, Some(0))
      it("should return the product") {
        PriceCalculator.calculatePrice(actual, pricePoints) shouldEqual expected
      }
    }

    describe("passed a product D and some price points") {
      val actual = Product("D", 6854, 6854, 6854, None)
      val expected = Product("D", 6854, 6854, 6854, Some(0))
      it("should return the product") {
        PriceCalculator.calculatePrice(actual, pricePoints) shouldEqual expected
      }
    }

    describe("passed a product E and some price points") {
      val actual = Product("E", 6897, 6885, 6905, None)
      val expected = Product("E", 6897, 6885, 6905, Some(6895))
      it("should return the product") {
        PriceCalculator.calculatePrice(actual, pricePoints) shouldEqual expected
      }
    }

    describe("passed a product and a price points") {
      val actualProduct = Product("A", 255, 245, 299, None)
      val expectedProduct = Product("A", 255, 245, 299, Some(255))
      it("should return the product with a new price based on the price points") {
        PriceCalculator.calculatePrice(actualProduct, Set(5)) shouldEqual expectedProduct
      }
    }
  }
}
