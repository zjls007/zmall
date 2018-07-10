package com.zxj.util;

import com.zxj.resolver.NameResolver;

import java.io.File;

/**
 * Created by zxj on 2017/5/3.
 */
public class PathUtil {

    public static String basePath;

    public static String getModelPath(String basePath, String tableName) {
        // 和枚举生成共用基础路径
        PathUtil.basePath = basePath;
        GenerateConfig generateConfig = GenerateConfig.getInstance();
        StringBuilder path = new StringBuilder();
        path.append(basePath);
        if (generateConfig.modelTargetProject != null && !generateConfig.modelTargetProject.isEmpty()) {
            backDir(path, generateConfig.modelTargetProject);
        }
        if (generateConfig.modelPackage != null && !generateConfig.modelPackage.isEmpty()) {
            backDir(path, generateConfig.modelPackage.replaceAll("\\.", "/"));
        }
        path.append(File.separator);
        path.append(NameResolver.getJavaClassName(tableName));
        path.append(".java");
        return path.toString();
    }

    public static String getEnumPath(String enumName) {
        GenerateConfig generateConfig = GenerateConfig.getInstance();
        StringBuilder path = new StringBuilder();
        path.append(basePath);
        if (generateConfig.modelTargetProject != null && !generateConfig.modelTargetProject.isEmpty()) {
            backDir(path, generateConfig.modelTargetProject);
        }
        if (generateConfig.enumpackage != null && !generateConfig.enumpackage.isEmpty()) {
            backDir(path, generateConfig.enumpackage.replaceAll("\\.", "/"));
        }
        path.append(File.separator);
        path.append(enumName);
        path.append(".java");
        return path.toString();
    }

    public static String getDaoPath(String basePath, String tableName) {
        GenerateConfig generateConfig = GenerateConfig.getInstance();
        StringBuilder path = new StringBuilder();
        path.append(basePath);
        if (generateConfig.daoTargetProject != null && !generateConfig.daoTargetProject.isEmpty()) {
            backDir(path, generateConfig.daoTargetProject);
        }
        if (generateConfig.daoPackage != null && !generateConfig.daoPackage.isEmpty()) {
            backDir(path, generateConfig.daoPackage.replaceAll("\\.", "/"));
        }
        path.append(File.separator);
        path.append(NameResolver.getJavaClassName(tableName));
        path.append("DAO.java");
        return path.toString();
    }

    public static String getServicePath(String basePath, String tableName) {
        GenerateConfig generateConfig = GenerateConfig.getInstance();
        StringBuilder path = new StringBuilder();
        path.append(basePath);
        if (generateConfig.serviceTargetProject != null && !generateConfig.serviceTargetProject.isEmpty()) {
            backDir(path, generateConfig.serviceTargetProject);
        }
        if (generateConfig.servicePackage != null && !generateConfig.servicePackage.isEmpty()) {
            backDir(path, generateConfig.servicePackage.replaceAll("\\.", "/"));
        }
        path.append(File.separator);
        path.append("I");
        path.append(NameResolver.getJavaClassName(tableName));
        path.append("Service.java");
        return path.toString();
    }

    public static String getServiceImplPath(String basePath, String tableName) {
        GenerateConfig generateConfig = GenerateConfig.getInstance();
        StringBuilder path = new StringBuilder();
        path.append(basePath);
        if (generateConfig.providerTargetProject != null && !generateConfig.providerTargetProject.isEmpty()) {
            backDir(path, generateConfig.providerTargetProject);
        }
        if (generateConfig.providerPackage != null && !generateConfig.providerPackage.isEmpty()) {
            backDir(path, generateConfig.providerPackage.replaceAll("\\.", "/"));
        }
        path.append(File.separator);
        path.append(NameResolver.getJavaClassName(tableName));
        path.append("ServiceImpl.java");
        return path.toString();
    }

    public static String getMapperPath(String basePath, String tableName) {
        GenerateConfig generateConfig = GenerateConfig.getInstance();
        StringBuilder path = new StringBuilder();
        path.append(basePath);
        if (generateConfig.mapperTargetProject != null && !generateConfig.mapperTargetProject.isEmpty()) {
            backDir(path, generateConfig.mapperTargetProject);
        }
        if (generateConfig.mapperPackage != null && !generateConfig.mapperPackage.isEmpty()) {
            backDir(path, generateConfig.mapperPackage.replaceAll("\\.", "/"));
        }
        path.append(File.separator);
        path.append(tableName);
        path.append(".xml");
        return path.toString();
    }

    public static String getTestPath(String basePath, String tableName) {
        GenerateConfig generateConfig = GenerateConfig.getInstance();
        StringBuilder path = new StringBuilder();
        path.append(basePath);
        if (generateConfig.testTargetProject != null && !generateConfig.testTargetProject.isEmpty()) {
            backDir(path, generateConfig.testTargetProject);
        }
        if (generateConfig.testPackage != null && !generateConfig.testPackage.isEmpty()) {
            backDir(path, generateConfig.testPackage.replaceAll("\\.", "/"));
        }
        path.append(File.separator);
        path.append(NameResolver.getJavaClassName(tableName));
        path.append("ServiceTest.java");
        return path.toString();
    }

    /**
     * 目录..的时候退掉一个目录
     * @param path
     * @param add
     */
    public static void backDir(StringBuilder path, String add) {
        String temp = path.toString();
        if (temp.endsWith("\\")) {
            temp = temp.substring(0, temp.length() - 1);
        }
        if (add.startsWith("/")) {
            add = add.substring(1);
        }
        if (add != null && add.startsWith("../")) {
            add = add.replace("../", "");
            if (temp.lastIndexOf("\\") != -1) {
                temp = temp.substring(0, temp.lastIndexOf("\\"));
            }
        }
        path.delete(0, path.length());
        path.append(String.format("%s/%s", temp, add));
    }

    public static void main(String[] args) {
        StringBuilder path = new StringBuilder("E:\\56top\\saas\\saas-basic");
        backDir(path, "../saas-basic-model/src/main/java");
        backDir(path, "com/zxj/saas/basic/model/po");
        System.out.println(path.toString());
    }

}
