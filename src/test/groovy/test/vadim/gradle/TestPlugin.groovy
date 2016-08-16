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

        // publish plugin into local repo
        runUploadArchivesTask()

        // start plugin task

        String pluginTask = "run"
        String dir = "./folderforplugintest"

        GradleConnector connector = GradleConnector.newConnector();
        connector.forProjectDirectory(new File(dir));
        ProjectConnection connection = connector.connect();

        try {

            BuildLauncher launcher = connection.newBuild();
            launcher.forTasks(pluginTask);
            launcher.setStandardOutput(System.out);
            launcher.setStandardError(System.err);
            launcher.run();

        } finally {
            connection.close();
        }
    }

    public void runUploadArchivesTask() {

        String pluginTask = "uploadArchives"
        String dir = "."

        GradleConnector connector = GradleConnector.newConnector();
        connector.forProjectDirectory(new File(dir));
        ProjectConnection connection = connector.connect();

        try {

            BuildLauncher launcher = connection.newBuild();
            launcher.forTasks(pluginTask);
            launcher.setStandardOutput(System.out);
            launcher.setStandardError(System.err);
            launcher.run();

        } finally {
            connection.close();
        }
    }

}
