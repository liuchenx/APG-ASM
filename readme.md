


基于android gradle plugin 7.0 的AsmClassVisitorFactory工具实现的apk字节码注入

#### Gradle Plugin 调试

``
set GRADLE_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
gradlew --no-daemon assembleDebug  -Dorg.gradle.debug=true -Dorg.gradle.java.home=/JAVA_HOME
``