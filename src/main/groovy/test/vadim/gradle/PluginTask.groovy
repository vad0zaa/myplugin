package test.vadim.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by Administrator on 9.08.2016.
 */
public class PluginTask extends DefaultTask {

    @TaskAction
    public void myTask() {
        println ' myTask started...'
        println 'param1 : ${project.pluginParameters.parameterOne}'
        println 'param2 : ${project.pluginParameters.parameterTwo}'
    }
}
