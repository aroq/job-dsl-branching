package com.github.aroq.groflow.gitlab

import com.github.aroq.groflow.common.commands.Command

/**
 * Created by Aroq on 10/02/16.
 */
class GitLabCommand extends Command {

    def gitlabRequest(String command, params = []) {
        def requestString = ([command] + params).join('/')
        new groovy.json.JsonSlurper().parseText(new URL("${config.gitlabAddress}/api/v3/${requestString}?private_token=${config.privateToken}").text)
    }

}
