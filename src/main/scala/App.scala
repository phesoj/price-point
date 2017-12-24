import org.apache.spark.sql.SparkSession
import PriceCalculator._

object SparkApp {
  def main(args: Array[String]) = {
    lazy val spark = SparkSession
      .builder()
      .master("local")
      .appName("Spark SQL basic example")
      .getOrCreate()

    import spark.implicits._

    val productA = Product("A", 6889, 6885, 6905, None)
    val productB = Product("B", 7197, 7192, 7198, None)
    val productC = Product("C", 6997, 6996, 6998, None)
    val productD = Product("D", 6854, 6854, 6854, None)
    val productE = Product("E", 6897, 6885, 6905, None)

    val ds = Seq(productA, productB, productC, productD, productE).toDS()

    ds.foreach(product => println(calculatePrice(product, PricePoints)))
  }
}
