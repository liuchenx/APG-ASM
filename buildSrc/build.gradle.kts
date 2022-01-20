plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("AppPlugin") {
            id = "me.liuyichen.plugins.cat"
            implementationClass = "me.liuyichen.plugins.cat.AppPlugin"
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.android.tools.build:gradle:7.0.4")
}

