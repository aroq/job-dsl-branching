import com.github.aroq.druflow.commands.AutoMergeJobDSLCreator
import com.github.aroq.groovycommon.Common
import com.github.aroq.groovycommon.Config

config = Config.instance.config

Config.instance.addParams(System.properties)
configFilePath = 'config/config.groovy'

def conf

config.rootDir = Common.instance.rootDir()

// Determine current environment.
try {
    BUILD_NUMBER
    config.environment = 'jenkins'
    conf = readFileFromWorkspace(configFilePath)
} catch (MissingPropertyException mpe) {
    config.environment = 'local'
    conf = new File(config.rootDir, configFilePath).text
}

Config.instance.addParams(ConfigSlurper.newInstance(config.environment).parse(conf))

println config.environment
println config.rootDir
println System.properties


(new AutoMergeJobDSLCreator(componentName: 'automerge', scriptObject: this)).execute()

