package com.github.aroq.groflow.jobdsl

import com.github.aroq.groflow.common.commands.Command
import groovy.json.JsonSlurper

/**
 * Created by Aroq on 04/06/16.
 */
class ProjectsTriggers extends Command {

    String projectsJsonPath

    def perform() {
        log "Projects list path: ${projectsJsonPath}"
        JsonSlurper.newInstance().parseText(new File(projectsJsonPath).text)
    }

}
