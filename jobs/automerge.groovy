import com.github.aroq.druflow.commands.AutoMergeJobDSLCreator
import com.github.aroq.groovycommon.Common
import com.github.aroq.groovycommon.Config

config = Config.instance.config

Config.instance.addParams(System.properties)

// Determine current environment.
try {
    BUILD_NUMBER
    config.environment = 'jenkins'
} catch (MissingPropertyException mpe) {
    config.environment = 'local'
    def configFile = new File(config.rootDir + '/config/config.groovy')

}

config.rootDir = Common.instance.rootDir()
println config.environment
println config.rootDir
println System.properties

Config.instance.addParams(ConfigSlurper.newInstance(config.environment).parse(configFile.text))

(new AutoMergeJobDSLCreator(componentName: 'automerge', scriptObject: this)).execute()

