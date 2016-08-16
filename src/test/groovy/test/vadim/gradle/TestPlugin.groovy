package test.vadim.gradle

import org.gradle.tooling.BuildLauncher
import org.gradle.tooling.GradleConnector
import org.gradle.tooling.ProjectConnection
import org.junit.Test

/**
 * Created by Administrator on 16.08.2016.
 */
class TestPlugin {

    @Test
   public void runPluginTask() {

        String pluginTask = "run"
        String dir = "./folderforplugintest"

        GradleConnector connector = GradleConnector.newConnector();
        connector.forProjectDirectory(new File(dir));

        ProjectConnection connection = connector.connect();
        try {
            // Configure the build
            BuildLauncher launcher = connection.newBuild();
            launcher.forTasks(pluginTask);
            launcher.setStandardOutput(System.out);
            launcher.setStandardError(System.err);

            // Run the build
            launcher.run();
        } finally {
            // Clean up
            connection.close();
        }
    }
}
