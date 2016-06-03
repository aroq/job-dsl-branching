package com.github.aroq.groflow.gitlab

/**
 * Created by Aroq on 10/02/16.
 */
class GitLabBranchList extends GitLabCommand {

    def namePattern

    def projectID

    def perform() {
        def gitlabBranches = gitlabRequest('projects', [projectID, 'repository/branches'])
        if (namePattern) {
            gitlabBranches.findAll {
                it.name =~ namePattern
            }
        }
        else {
            gitlabBranches
        }
    }

}
