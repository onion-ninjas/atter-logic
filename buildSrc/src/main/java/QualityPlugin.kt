package com.quality

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class QualityPlugin : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        rootProject.tasks.maybeCreate("projectCodestyle").apply {
            group = "ci"
            description = "Runs code style checks agains the whole project"
        }

        configureDetekt()
    }

    private fun Project.configureDetekt() {
        pluginManager.apply(DetektPlugin::class.java)

        extensions.configure(DetektExtension::class.java) {
            it.reports.html { enabled = false }
            it.reports.xml { enabled = false }
            it.config.setFrom(rootProject.file("buildSrc/build/resources/main/detekt.yml"))
            it.input.from("src")
        }
        tasks.named("detekt", Detekt::class.java) {
            it.exclude(".*/resources/.*", ".*/build/.*")
        }
        rootProject.tasks.named("projectCodestyle") {
            it.dependsOn("$path:detekt")
        }
    }
}
