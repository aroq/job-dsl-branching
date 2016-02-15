package com.github.aroq.groflow.jobdsl.git.commands

import com.github.aroq.groflow.common.commands.Command

/**
 * Created by Aroq on 10/02/16.
 */
class GitLabBranchList extends Command {

    def pattern

    def perform() {
        def gitlabBranches = new groovy.json.JsonSlurper().parseText(new URL("${config.gitlabAddress}/api/v3/projects/${config.projectID}/repository/branches?private_token=${config.privateToken}").text).name
        gitlabBranches.findAll { it.value =~ pattern }
    }

}
