package me.liuyichen.plugins.cat

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class AppMethodVisitor(mv: MethodVisitor): MethodVisitor(Opcodes.ASM7, mv) {

    override fun visitCode() {
        super.visitCode()

        mv.visitVarInsn(Opcodes.ALOAD, 0)
        mv.visitLdcInsn("Hello Cat")
        mv.visitInsn(Opcodes.ICONST_0)
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "android/widget/Toast", "makeText", "(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;", false)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "android/widget/Toast", "show", "()V", false)

    }

    override fun visitMaxs(maxStack: Int, maxLocals: Int) {
        mv.visitMaxs(maxStack + 1, maxLocals)
    }
}