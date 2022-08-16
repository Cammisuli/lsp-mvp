package dev.nrwl.lspmvp

import com.intellij.openapi.application.PreloadingActivity
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.util.EnvironmentUtil
import org.wso2.lsp4intellij.IntellijLanguageClient
import org.wso2.lsp4intellij.client.languageserver.serverdefinition.ProcessBuilderServerDefinition
import org.wso2.lsp4intellij.requests.Timeouts
import java.util.*

private val LOG = logger<Preloader>()

class Preloader : PreloadingActivity() {
    override fun preload(indicator: ProgressIndicator) {
        val newTimeouts: MutableMap<Timeouts, Int> = EnumMap(org.wso2.lsp4intellij.requests.Timeouts::class.java)
        newTimeouts[Timeouts.INIT] = 1500000
        newTimeouts[Timeouts.COMPLETION] = 1000
        IntellijLanguageClient.setTimeouts(newTimeouts)

        val process = ProcessBuilder("/bin/bash", "-c", "nxls --stdio").apply {
            val processEnv = environment()
            LOG.info("PROCESS ENV BEFORE: $processEnv")

            val env = EnvironmentUtil.getEnvironmentMap()
            processEnv["PATH"] = env["PATH"]
            LOG.info("PROCESS ENV AFTER: $processEnv")
        }


        IntellijLanguageClient.addServerDefinition(
            ProcessBuilderServerDefinition("project.json,workspace.json", process)
        )
    }
}