package me.liuyichen.plugins.cat



import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class AppClassVisitor(write: ClassVisitor): ClassVisitor(Opcodes.ASM7, write) {



    override fun visitMethod(access: Int, name: String?, descriptor: String?, signature: String?, exceptions: Array<out String>?
    ): MethodVisitor {
        var methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
        if (name == "onCreate" && descriptor == "()V") {
            methodVisitor = AppMethodVisitor(methodVisitor)
        }
        return methodVisitor
    }
}