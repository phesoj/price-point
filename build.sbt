name := "pricepoint"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  Seq(
    "org.apache.spark" %% "spark-sql" % "2.2.0",
    "org.scalatest" %% "scalatest" % "3.0.4" % "test",
    "org.scalactic" %% "scalactic" % "3.0.4"
  )
}
