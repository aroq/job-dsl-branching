package com.github.aroq.druflow.commands

import com.github.aroq.groovycommon.commands.Command

/**
 * Created by Aroq on 10/02/16.
 */
abstract class JobDSLCreator extends Command {

    def componentName

    protected def componentConfig

    def scriptObject

    def loadConfig() {
        if (config.environment == 'jenkins') {
            return scriptObject.readFileFromWorkspace("project.config/${componentName}.groovy")
        }
        else {
            def configFile = new File(rootDir(), "project.config/${componentName}.groovy")
            if (configFile.exists()) {
               return configFile.text
            }
        }
    }

    abstract def createJob(params)
}
