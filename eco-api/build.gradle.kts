dependencies {
    // Adventure
    compileOnly("net.kyori:adventure-platform-bukkit:4.1.0")

    // Other
    compileOnly("org.spigotmc:spigot-api:1.21.4-R0.1-SNAPSHOT")
    compileOnly("commons-lang:commons-lang:2.6")
    compileOnly("net.dmulloy2:ProtocolLib:5.1.0")
    compileOnly("com.google.code.gson:gson:2.8.8")
}

group = "com.willfp"
version = rootProject.version

java {
    withJavadocJar()
}

tasks {
    build {
        dependsOn(publishToMavenLocal)
    }
}

publishing {
    publications {
        create<MavenPublication>("shadow") {
            from(components["java"])
            artifactId = "eco"
        }
    }

    publishing {
        repositories {
            maven {
                name = "expx"
                url = uri("https://maven.pkg.github.com/expxx/eco")
                credentials {
                    username = System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}
