plugins {
    java
}

dependencies {
    implementation(project(":core"))

    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.7.3")

}
