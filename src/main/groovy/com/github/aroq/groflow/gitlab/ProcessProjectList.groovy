package com.github.aroq.groflow.gitlab

/**
 * Created by Aroq on 10/02/16.
 */
class ProcessProjectList extends GitLabCommand {

    String namePattern = 'config'

    def perform() {
        executeCommand('projectList').each { project ->
            def projectID = URLEncoder.encode(project.path_with_namespace, "UTF-8").replaceAll("\\.", '%2E')
            try {
                executeCommand('branchList', [namePattern: namePattern, projectID: projectID]).each { branch ->
                    println "${project}"

                }
            }
            catch (RuntimeException e) {
            }
        }
    }

}
