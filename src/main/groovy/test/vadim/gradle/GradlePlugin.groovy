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

        project.extensions.create('pluginParameters', PluginExtension)

        project.task('myTask', type: PluginTask)

        println 'plugin parameters - parameter threads ='+ project.pluginParameters.threads

        List tasksPool = []


        for (def i = 0; i< project.pluginParameters.threads ; i++) {
            tasksPool.add(project.tasks['myTask'])
        }

        GParsPool.withPool( project.pluginParameters.threads ) {

            tasksPool.eachParallel { PluginTask task ->

                try {
                    task.myTask()
                } catch (all) {
                    println ('FAILED '+ all)
                }
            }
        }

        println ' plugin finished'
    }
}
