contextParams {
    defaultContext {
        name = 'defaultContext'
        allowedCommands = []
    }
}

commands {
    gitlabBranchesList {
        className = 'com.github.aroq.groflow.gitlab.GitLabBranchList'
    }
    branchList {
        className = 'com.github.aroq.groflow.gitlab.GitLabBranchList'
    }
    projectList {
        className = 'com.github.aroq.groflow.gitlab.GitLabProjectList'
    }
    repoBranchFileList {
        className = 'com.github.aroq.groflow.gitlab.GitLabFileList'
    }
}

