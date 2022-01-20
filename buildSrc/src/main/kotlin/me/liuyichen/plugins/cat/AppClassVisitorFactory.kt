package me.liuyichen.plugins.cat


import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import com.android.build.api.instrumentation.InstrumentationParameters
import org.objectweb.asm.ClassVisitor
import org.gradle.api.Incubating



@Incubating
abstract class AppClassVisitorFactory: AsmClassVisitorFactory<AppParameters> {


    override fun createClassVisitor(classContext: ClassContext, nextClassVisitor: ClassVisitor): ClassVisitor {
        return AppClassVisitor(nextClassVisitor)
    }

    override fun isInstrumentable(classData: ClassData): Boolean {
        if (parameters.get().appName == classData.className) {
            return true
        }
        return false
    }
}