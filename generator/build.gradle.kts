plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))

    // https://mvnrepository.com/artifact/org.freemarker/freemarker
    implementation("org.freemarker:freemarker:2.3.32")

    // https://mvnrepository.com/artifact/org.modeshape/modeshape-common
    implementation("org.modeshape:modeshape-common:5.4.1.Final")

    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.7.3")
}