package test.vadim.gradle

import org.gradle.api.Plugin;
import org.gradle.api.Project

/**
 * Created by Administrator on 9.08.2016.
 */
public class GradlePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println ' plugin started'

        project.extensions.create('pluginParameters', PluginExtension)

        project.task("myTask", type: PluginTask);

        println ' plugin finished'
    }
}
