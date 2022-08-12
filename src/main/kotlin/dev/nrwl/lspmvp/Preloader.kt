package dev.nrwl.lspmvp

import com.intellij.openapi.application.PreloadingActivity
import com.intellij.openapi.progress.ProgressIndicator
import org.wso2.lsp4intellij.IntellijLanguageClient
import org.wso2.lsp4intellij.client.languageserver.serverdefinition.RawCommandServerDefinition
import org.wso2.lsp4intellij.requests.Timeouts




class Preloader: PreloadingActivity() {
    override fun preload(indicator: ProgressIndicator) {
        println("Activated")
        val newTimeouts: MutableMap<Timeouts, Int> = HashMap()
        newTimeouts[Timeouts.INIT] = 20000000
        newTimeouts[Timeouts.COMPLETION] = 1000
        IntellijLanguageClient.setTimeouts(newTimeouts)

        IntellijLanguageClient.addServerDefinition(RawCommandServerDefinition("project.json,workspace.json", arrayOf("nxls", "--stdio")))
//
//        node --inspect /Users/jon/.config/nvm/16.15.1/bin/nxls --stdio
//                IntellijLanguageClient.addServerDefinition(RawCommandServerDefinition("project.json,workspace.json", arrayOf("node", "--inspect-brk", "/Users/Jon/.config/nvm/16.15.1/bin/nxls", "--stdio")))
//
    }
}