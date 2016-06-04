package com.github.aroq.groflow.jobdsl

import com.github.aroq.groflow.common.commands.Command
import groovy.json.JsonSlurper

/**
 * Created by Aroq on 04/06/16.
 */
class ProjectsTriggers extends Command {

    def perform() {
        log "Projects list path: ${config.projectsJsonPath}"
        JsonSlurper.newInstance().parseText(new File(config.projectsJsonPath).text)
    }

}
