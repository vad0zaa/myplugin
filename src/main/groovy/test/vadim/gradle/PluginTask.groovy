package test.vadim.gradle

import groovyx.gpars.GParsPool
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by Administrator on 9.08.2016.
 */
public class PluginTask extends DefaultTask {

   @TaskAction
    def goAhead() {

       println '..PluginTask  started...'
       println '...PluginTask - cify threads : ' + project.cify.threads

       // create features list
       List features = []
       for(def i=0 ; i < project.cify.threads ; i++) {
           features.add('featureNr_' + i)
       }

       // create taskpool
       List tasksPool = []
       features.each { String feature ->
           project.task(feature, type: FinalTask){
                taskName = feature
           }
           tasksPool.add(project.tasks[feature])
       }

       // run tasks in parallel
       GParsPool.withPool( project.cify.threads ) {
           tasksPool.eachParallel { FinalTask task ->
               try {
                   println ' GPars - start parallel task '
                   task.startFinalTaskAction()
               } catch (all) {
                   println ('FAILED '+ all)
               }
           }
       }

        println '..PluginTask  finished...'
    }
}
