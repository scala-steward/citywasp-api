organization := "citywasp"
name := "citywasp-api"

val Akka = "2.6.13"
val AkkaHttp = "10.2.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream"     % Akka,
  "com.typesafe.akka" %% "akka-http"       % AkkaHttp,
  "de.heikoseeberger" %% "akka-http-circe" % "1.35.3",
  "org.scalatest"     %% "scalatest"       % "3.2.6" % "test"
)

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

scalafmtOnCompile in ThisBuild := true
