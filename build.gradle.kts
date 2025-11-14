
plugins {
    id("com.gtnewhorizons.gtnhconvention")
}

// HexCraft Configuration
version = "1.7.10-0.13.2"
group = "com.celestek.hexcraft"
base {
    archivesName = "HEXCraft"
}

// HexCraft Dependencies
dependencies {
    compileOnly("team.chisel:Chisel:2.9.5.12:deobf")
    compileOnly("codechicken:ForgeMultipart:1.7.10-1.2.0.347:dev")
    compileOnly("codechicken:CodeChickenCore:1.7.10-1.0.7.47:dev")
    compileOnly("codechicken:NotEnoughItems:1.7.10-1.0.5.120:dev")
    compileOnly("ic2:IC2Classic:1.2.1.8:dev")
    compileOnly("coloredlightscore:ColoredLightsCore:1.3.7.d524c02:deobf")
    compileOnly("com.gregoriust.gregtech:gregtech_1.7.10:6.13.01:dev")
}

// Spotless never works anyways...
project.plugins.withId("com.diffplug.spotless") {
    project.extensions.configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        java {
            target("none")
        }
    }
}

