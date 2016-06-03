package com.github.aroq.groflow.gitlab

/**
 * Created by Aroq on 10/02/16.
 */
class GitLabFileList extends GitLabCommand {

    String namePattern

    String projectID

    String branch

    def perform() {
        def gitlabFiles = gitlabRequest('projects', [projectID, 'repository/tree'])
        if (namePattern) {
            gitlabFiles.findAll {
                it.name =~ namePattern
            }
        }
        else {
            gitlabFiles
        }
    }

}
