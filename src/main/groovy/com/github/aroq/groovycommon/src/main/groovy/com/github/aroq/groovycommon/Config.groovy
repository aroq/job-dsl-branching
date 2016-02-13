package com.github.aroq.groovycommon
/**
 * Created by alex on 26.06.15.
 */


@Singleton
class Config {

    def config = [:]

    def addParams(parameters, overwrite = false) {
        parameters.each() { param, value ->
            if (overwrite || !config.containsKey(param)) {
                config[param] = value
            }
        }
    }
}
