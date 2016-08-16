package test.vadim.gradle

import org.gradle.api.Plugin;
import org.gradle.api.Project
import groovyx.gpars.GParsPool

/**
 * Created by Administrator on 9.08.2016.
 */
public class GradlePlugin implements Plugin<Project> {


    @Override
    void apply(Project project) {
        println ' plugin started'

        // create extension to get external cify parameters
        project.extensions.create('cify', PluginExtension)

        // define plugin task
        project.task('run', type: PluginTask)

        println ' plugin finished'
    }


}
