plugins {
//    javaLibrary
    java
//    mavenPublish
}


dependencies {
}


//tasks.javadoc {
//    // 出力先のディレクトリを指定（オプション）
//    destinationDir = file("$buildDir/docs/javadoc")
//}

//publishing {
//    publications {
//        create<MavenPublication>("mavenJava") {
//            from(components["java"])
//            groupId = "com.example"
//            artifactId = "your-library-name"
//            version = "1.0.0"
//        }
//    }
//    // 公開先のリポジトリの設定
//    repositories {
//        maven("https://oss.sonatype.org/service/local/staging/deploy/maven2/") {
//            credentials {
//                username = project.findProperty("ossrhUsername") as? String ?: System.getenv("OSSRH_USERNAME")
//                password = project.findProperty("ossrhPassword") as? String ?: System.getenv("OSSRH_PASSWORD")
//            }
//        }
//    }
//}
