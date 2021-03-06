import com.github.aroq.groflow.jobdsl.git.commands.AutoMergeJobDSLCreator
import com.github.aroq.groflow.common.Common
import com.github.aroq.groflow.common.Config

config = Config.instance.config

Config.instance.addParams(System.properties)
configFilePath = 'config/config.groovy'

def conf

config.rootDir = Common.instance.rootDir()
config.workspace = config.rootDir

// Determine current environment.
try {
    BUILD_NUMBER
    config.environment = 'jenkins'
    conf = readFileFromWorkspace(configFilePath)

    config.gitlabAddress = gitlabAddress
    config.projectID = projectID
    config.privateToken = privateToken
} catch (MissingPropertyException mpe) {
    config.environment = 'local'
    conf = new File(config.rootDir, configFilePath).text
}

Config.instance.addParams(ConfigSlurper.newInstance(config.environment).parse(conf))

println config.environment
println config.rootDir
println System.properties


(new AutoMergeJobDSLCreator(componentName: 'automerge', scriptObject: this)).execute()

