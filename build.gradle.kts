
plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

allprojects {
}

subprojects {

    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    dependencies {
        // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter
        testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    }

    tasks.test {
        useJUnitPlatform()
    }

//    // サブプロジェクトごとの設定
//    // coreサブプロジェクトの設定
//    project(":core") {
//        // 依存関係の設定（coreがgeneratorに依存する場合など）
//        dependencies {
//            // generatorに依存する例
//            implementation(project(":generator"))
//            // 他のライブラリや依存関係を必要に応じて追加
//        }
//    }
//
//    // generatorサブプロジェクトの設定
//    project(":generator") {
//        // 依存関係の設定（generatorがcoreに依存する場合など）
//        dependencies {
//            // coreに依存する例
//            implementation(project(":core"))
//            // 他のライブラリや依存関係を必要に応じて追加
//        }
//    }
}