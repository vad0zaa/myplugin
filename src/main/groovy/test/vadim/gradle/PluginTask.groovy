package test.vadim.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by Administrator on 9.08.2016.
 */
public class PluginTask extends DefaultTask {

   @TaskAction
    public void myTask() {

        Date startDate = new Date();

        println ' myTask  started...'
        println 'start date : ' + startDate.toString()
/*
        println 'param1 : ' + project.pluginParameters.parameterOne
        println 'param2 : ' + project.pluginParameters.parameterTwo
        println 'param threads : ' + project.pluginParameters.threads*/

        // do some work here
        try{
            Thread.sleep(2000)
        }
        catch (Exception e){}

        Date finishDate = new Date();
        println 'finish date : ' + finishDate.toString()
        println ' myTask  finished...'

    }
}
