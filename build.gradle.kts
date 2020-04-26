group = "com.solera"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

plugins {
	kotlin("jvm") version "1.3.72"
	application
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	implementation("com.google.guava:guava:29.0-jre")
	implementation("com.github.freva:ascii-table:1.1.0")
	
	testImplementation(platform("org.junit:junit-bom:5.6.2"))
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testImplementation("org.junit.jupiter:junit-jupiter-engine")
	testImplementation("org.assertj:assertj-core:3.15.0")
}

tasks {
	compileKotlin {
		kotlinOptions.jvmTarget = "1.8"
	}
	compileTestKotlin {
		kotlinOptions.jvmTarget = "1.8"
	}
	test {
		useJUnitPlatform()
	}
	jar {
		manifest {
			attributes["Main-Class"] = "com.solera.MainProgramKt"
		}
	}
}

application {
	mainClassName = "com.solera.MainProgramKt"
}