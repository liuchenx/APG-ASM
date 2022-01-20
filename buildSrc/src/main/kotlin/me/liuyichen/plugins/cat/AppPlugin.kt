package me.liuyichen.plugins.cat

import com.android.build.api.instrumentation.FramesComputationMode
import com.android.build.api.instrumentation.InstrumentationScope
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AppPlugin : Plugin<Project> {


    override fun apply(project: Project) {

        val catExt = project.extensions.create("cat", AppExt::class.java)
        project.afterEvaluate {
            println("Cat extension app name: ${catExt.app}")
        }
        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)
        androidComponents.onVariants { variant ->
            if (variant.name.capitalize() == "Debug") {
                variant.transformClassesWith(AppClassVisitorFactory::class.java, InstrumentationScope.PROJECT
                ) {
                    it.appName = catExt.app ?: throw Exception("not found app class path")
                }
                variant.setAsmFramesComputationMode(FramesComputationMode.COPY_FRAMES)
            }
        }
    }
}