name := "internal-proxy-hack"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

// Jsonp support
resolvers += "julienrf.github.com" at "http://julienrf.github.com/repo-snapshots/"

libraryDependencies += "julienrf" %% "play-jsonp-filter" % "1.1-SNAPSHOT"

play.Project.playScalaSettings
