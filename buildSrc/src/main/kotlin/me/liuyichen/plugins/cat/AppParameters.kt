package me.liuyichen.plugins.cat

import com.android.build.api.instrumentation.InstrumentationParameters
import org.gradle.api.tasks.Input


interface AppParameters: InstrumentationParameters {

    @get:Input
    var appName: String
}