package com.zxj.resolver;

import com.zxj.model.Table;
import com.zxj.util.GenerateConfig;
import com.zxj.util.JdbcConnectionFactory;
import com.zxj.util.PathUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by zxj on 2017/5/2.
 */
public class CodeGenerateResolver {

    GenerateConfig generateConfig = GenerateConfig.getInstance();

    private Properties p;

    private JdbcConnectionFactory jdbcConnectionFactory;

    private File baseDir;

    public CodeGenerateResolver(Properties p, File baseDir) {
        this.p = p;
        this.jdbcConnectionFactory = new JdbcConnectionFactory(p);
        this.baseDir = baseDir;
    }

    public void generate() {
        try {
            MysqlDaoResolver mysqlDaoResolver = new MysqlDaoResolver(jdbcConnectionFactory);
            for (String tableName : generateConfig.tableName.split(",")) {
                Table table = mysqlDaoResolver.getTable(tableName);
                if (table.getPrimaryKeyName() == null || table.getPrimaryKeyName().equals("")) {
                    throw new RuntimeException(String.format("表【%s】必须要有主键", tableName));
                }
                ObjectResolver resolver = new ObjectResolver();
                if (generateConfig.genModel) {
                    resolver.gen(p, table, PathUtil.getModelPath(baseDir.getAbsolutePath(), tableName), "javaModel.ftl", false);
                }
                if (generateConfig.genDao) {
                    resolver.gen(p, table, PathUtil.getDaoPath(baseDir.getAbsolutePath(), tableName), "javaDao.ftl", false);
                }
                if (generateConfig.genMapper) {
                    resolver.gen(p, table, PathUtil.getMapperPath(baseDir.getAbsolutePath(), tableName), "xmlMapper.ftl", false);
                }
                if (generateConfig.genService) {
                    resolver.gen(p, table, PathUtil.getServicePath(baseDir.getAbsolutePath(), tableName), "javaService.ftl", false);
                }
                if (generateConfig.genProvider) {
                    resolver.gen(p, table, PathUtil.getServiceImplPath(baseDir.getAbsolutePath(), tableName), "javaServiceImpl.ftl", false);
                }
                if (generateConfig.genTest) {
                    resolver.gen(p, table, PathUtil.getTestPath(baseDir.getAbsolutePath(), tableName), "test.ftl", false);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        try {
            String path = "E:\\56top\\code\\archetype-2017\\src\\main\\resources\\code-generate.properties";
            p.load(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("加载配置文件出错", e);
        }

        JdbcConnectionFactory jdbcConnectionFactory = new JdbcConnectionFactory();
        MysqlDaoResolver mysqlDaoResolver = new MysqlDaoResolver(jdbcConnectionFactory);
        Table table = mysqlDaoResolver.getTable("share_company_website");
        ObjectResolver resolver = new ObjectResolver();
        resolver.gen(p, table, "D:/aaa/ShareCompanyWebsite.java", "javaModel.ftl", true);
//        resolver.gen(p, table, "D:/aaa/FinancePayReceiveDao.java", "javaDao.ftl", false);
//        resolver.gen(p, table, "D:/aaa/t_finance_pay_receive.xml", "xmlMapper.ftl", false);
        System.out.println(table);
    }

}
