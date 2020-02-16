import com.typesafe.config.ConfigFactory

object Main extends App {

  val config = ConfigFactory.load
  val env = config.getString("hello")

  println(s"This package runs in $env")

}
