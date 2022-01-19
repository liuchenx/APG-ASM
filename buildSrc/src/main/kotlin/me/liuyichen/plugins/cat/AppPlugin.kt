package me.liuyichen.plugins.cat

import com.android.build.api.instrumentation.FramesComputationMode
import com.android.build.api.instrumentation.InstrumentationScope
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AppPlugin : Plugin<Project> {


    override fun apply(project: Project) {

        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)
        androidComponents.onVariants { variant ->

         //   variant.transformClassesWith(AppClassVisitorFactory::class.java, InstrumentationScope.PROJECT) {}
         //   variant.setAsmFramesComputationMode(FramesComputationMode.COPY_FRAMES)
        }
    }
}