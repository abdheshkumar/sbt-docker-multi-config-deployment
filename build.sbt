import NativePackagerHelper._

name := "my-app"
libraryDependencies += "com.typesafe" % "config" % "1.3.0"

enablePlugins(JavaAppPackaging)
enablePlugins(AshScriptPlugin)
dockerBaseImage := "openjdk:8-jre-alpine"
//javaOptions will be copied in /opt/docker/conf/application.ini
javaOptions in Universal ++= {
val confFile = buildEnv.value match {
    case BuildEnv.Developement => "application.conf"
    case BuildEnv.Test         => "test.conf"
    case BuildEnv.Stage        => "stage.conf"
    case BuildEnv.Production   => "prod.conf"
  }
Seq(
  s"-Dconfig.file=/opt/docker/conf/$confFile"
)
}

//Docker plugin depends on universal plugin so It will map configuration to /opt/docker/conf
/*mappings in Universal += {
  // logic like this belongs into an AutoPlugin
  val confFile = buildEnv.value match {
    case BuildEnv.Developement => "application.conf"
    case BuildEnv.Test         => "test.conf"
    case BuildEnv.Stage        => "stage.conf"
    case BuildEnv.Production   => "prod.conf"
  }
  ((resourceDirectory in Compile).value) -> "conf"
}*/
// copy configuration files to config directory
mappings in Universal ++= contentOf("src/main/resources").map{ case(f,name)=>f -> s"conf/$name"}

