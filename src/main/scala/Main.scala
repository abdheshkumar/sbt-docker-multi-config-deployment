import com.typesafe.config.ConfigFactory

object Main extends App {

  val config = ConfigFactory.load
  val env = config.getString("hello")
  val from = config.getString("from")

  println(s"This package runs in $env and get from application.conf $from")

}
