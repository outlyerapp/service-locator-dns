import com.amazonaws.services.s3.model.Region

resolvers ++= Seq[Resolver](
  s3resolver.value("Outlyer Releases Resolver", s3("release.packages.outlyer.com")),
  s3resolver.value("Outlyer Snapshots Resolver", s3("snapshot.packages.outyler.com"))
)

name := "service-locator-dns"

resolvers += Resolver.hajile

libraryDependencies ++= Seq(
  Library.akkaDns,
  Library.akkaTestkit,
  Library.scalaTest % "test"
)

git.useGitDescribe := true

awsProfile:= "default"
s3region := Region.US_Standard
publishMavenStyle := false

publishTo := {
  val prefix = if (isSnapshot.value) "snapshot" else "release"
  Some(s3resolver.value("Outlyer " + prefix + " S3 bucket", s3(prefix+".packages.outlyer.com")) withIvyPatterns)
}
