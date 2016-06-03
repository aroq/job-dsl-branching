package com.github.aroq.groflow.gitlab

/**
 * Created by Aroq on 10/02/16.
 */
class GitLabProjectList extends GitLabCommand {

    def perform() {
        gitlabRequest('projects')
    }

}
