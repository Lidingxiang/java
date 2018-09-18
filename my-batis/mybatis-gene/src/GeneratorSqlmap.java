import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class GeneratorSqlmap {
    public void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String path = new File(".").getAbsolutePath();

        String pathTarget = String.format("%s/gen/", path);
        File dirTarget = new File(pathTarget);
        if (dirTarget.exists()) {
            removeDir(dirTarget);
        }
        dirTarget.mkdir();
        path = String.format("%s/generatorConfig.xml", path);
        //path = String.format("%s/generatorConfig_iot.xml", path);
        File configFile = new File(path);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

       // String pathCopy=new File("im-api/src/main/java").getAbsolutePath();

        java.awt.Desktop.getDesktop().open(dirTarget);
    }

    public static void main(String[] args) {
        try {
            GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
            generatorSqlmap.generator();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void removeDir(File dir) {
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                removeDir(file);
            } else {
                file.delete();
            }
        }
        dir.delete();
    }
}
