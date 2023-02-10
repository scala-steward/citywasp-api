val Tapir = "1.2.8"
val Circe = "0.14.3"
val Ciris = "3.1.0"

lazy val citywasp = project
  .in(file("."))
  .settings(sonatypeProfileName := "lt.dvim")
  .aggregate(api, cli)

lazy val api = (project in file("api"))
  .settings(
    name := "citywasp-api",
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.tapir" %% "tapir-core"           % Tapir,
      "com.softwaremill.sttp.tapir" %% "tapir-json-circe"     % Tapir,
      "com.softwaremill.sttp.tapir" %% "tapir-sttp-client"    % Tapir,
      "com.softwaremill.sttp.tapir" %% "tapir-refined"        % Tapir,
      "io.circe"                    %% "circe-generic"        % Circe,
      "io.circe"                    %% "circe-generic-extras" % Circe,
      "org.scalameta"               %% "munit"                % "0.7.29" % Test
    )
  )
  .enablePlugins(AutomateHeaderPlugin)

lazy val cli = (project in file("cli"))
  .settings(
    name := "citywasp-cli",
    libraryDependencies ++= Seq(
      "is.cir"                        %% "ciris"               % Ciris,
      "is.cir"                        %% "ciris-refined"       % Ciris,
      "org.typelevel"                 %% "cats-effect"         % "3.4.6",
      "com.softwaremill.sttp.client3" %% "http4s-backend"      % "3.8.11",
      "org.http4s"                    %% "http4s-blaze-client" % "0.23.13"
    )
  )
  .dependsOn(api)
  .enablePlugins(AutomateHeaderPlugin, JavaAppPackaging)

inThisBuild(
  Seq(
    organization := "lt.dvim.citywasp",
    scalaVersion := "2.13.10",
    scalacOptions += "-Ymacro-annotations",
    scalafmtOnCompile := true,
    scalafixOnCompile := true,
    scalafixDependencies ++= Seq(
      "com.nequissimus" %% "sort-imports" % "0.6.0"
    ),
    startYear := Some(2015),
    organizationName := "github.com/2m/citywasp-api/graphs/contributors",
    licenses += ("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt")),
    homepage := Some(url("https://github.com/2m/citywasp-api")),
    developers := List(
      Developer(
        "contributors",
        "Contributors",
        "https://gitter.im/2m/general",
        url("https://github.com/2m/citywasp-api/graphs/contributors")
      )
    ),
    versionScheme := Some("semver-spec")
  )
)
