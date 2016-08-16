package test.vadim.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by Administrator on 16.08.2016.
 */
class FinalTask extends DefaultTask {

    String taskName


    @TaskAction
    startFinalTaskAction(){
    println 'FinalTask ' + taskName + ' started.. ' + new Date().toString()

    // do some work here
    try{
        // printout plugin external parameter glue
        println 'taskName='+ taskName + ' ,param glue=' + project.cify.glue

        Thread.sleep(3000)
    }
    catch (Exception e){}

    println 'FinalTask ' + taskName + ' finished.. ' + new Date().toString()
}

}
