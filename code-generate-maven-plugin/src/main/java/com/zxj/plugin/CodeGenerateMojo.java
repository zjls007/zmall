package com.zxj.plugin;

import com.zxj.resolver.CodeGenerateResolver;
import com.zxj.util.GenerateConfig;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


@Mojo( name = "genCode", defaultPhase = LifecyclePhase.GENERATE_SOURCES )
public class CodeGenerateMojo extends AbstractMojo {

    @Parameter( defaultValue = "${project.basedir}/src/main/resources/code-generate.properties", property = "configFile", required = true )
    private File configFile;

    @Parameter( defaultValue = "${project.basedir}", property = "baseDir", required = true )
    private File baseDir;

    @Parameter( defaultValue = "${project.name}", property = "name", required = true )
    private String name;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        // maven插件会在所有子模块中执行一遍，这里控制只执行哪个模块
        if (!name.equals("zmall")) {
            return;
        }
        Properties p = new Properties();
        try {
            p.load(new InputStreamReader(new FileInputStream(configFile), "UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("加载配置文件出错", e);
        }
        GenerateConfig.init(p);
        CodeGenerateResolver resolver = new CodeGenerateResolver(p, baseDir);
        resolver.generate();
    }

}
