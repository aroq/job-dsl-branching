import com.github.aroq.druflow.commands.AutoMergeJobDSLCreator
import com.github.aroq.groovycommon.Common
import com.github.aroq.groovycommon.Config

config = Config.instance.config

Config.instance.addParams(System.properties)

// Determine current environment.
try {
    WORKSPACE
    config.environment = 'jenkins'
    config.build = build
} catch (MissingPropertyException mpe) {
    config.environment = 'local'
}

config.rootDir = Common.instance.rootDir()
println config.environment
println config.rootDir
println System.properties

def configFile = new File(config.rootDir + '/config/config.groovy')
Config.instance.addParams(ConfigSlurper.newInstance(config.environment).parse(configFile.text))

(new AutoMergeJobDSLCreator(componentName: 'automerge', scriptObject: this)).execute()

