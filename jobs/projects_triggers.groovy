import com.github.aroq.groflow.common.Common
import com.github.aroq.groflow.common.Config
import com.github.aroq.groflow.jobdsl.ProjectsTriggers

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

    config.baseFolder = baseFolder
    config.triggersFolder = triggersFolder
} catch (MissingPropertyException mpe) {
    config.environment = 'local'
    conf = new File(config.rootDir, configFilePath).text
}

Config.instance.addParams(ConfigSlurper.newInstance(config.environment).parse(conf))

def projects = (new ProjectsTriggers()).execute()
projects.each { project ->
    job("${config.baseFolder}/${config.triggersFolder}/${project.key}") {
        scm() {
            git {
                remote {
                    url(project.value)
                }
                branch("*/master")
            }
        }
    }
}

