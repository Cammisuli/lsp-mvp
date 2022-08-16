package dev.nrwl.lspmvp

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

class Postloader : StartupActivity.DumbAware {
    override fun runActivity(project: Project) {

        

//        val process2 = with(ProcessBuilder("nxls", "--studp")) {
//            directory(File(project.basePath))
//            start()
//        }
////
//        process2.apply {
//            if(isAlive) {}
//        }

//        val builder = ProcessBuilder("/Users/jon/.config/nvm/16.15.1/bin/nxls", "--stdio")
//        builder.directory(File(project.basePath))
//
//        val process = builder.start()
//
//        if (!process.isAlive) {
//            throw IOException("Unable to start language server")
//        } else {
//            print("running" + process.pid())
//        }

//        ProcessBuilder("nxls", "--stdio").apply {
//            directory(File(project.basePath))
//            start().apply {
//                if (!isAlive) {
//                    throw IOException("Unable to start language server")
//                }
//
//                print("running " + pid())
//            }
//        }

////


    }
}