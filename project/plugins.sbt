logLevel := Level.Warn

resolvers += Resolver.typesafeRepo("releases")

resolvers += "Era7 maven releases" at "https://s3-eu-west-1.amazonaws.com/releases.era7.com"

addSbtPlugin("ohnosequences"     % "sbt-s3-resolver" % "0.16.0")
addSbtPlugin("com.typesafe.sbt"  % "sbt-git"         % "0.9.3")
addSbtPlugin("org.scalariform"   % "sbt-scalariform" % "1.8.0")
addSbtPlugin("de.heikoseeberger" % "sbt-header"      % "1.5.1")
