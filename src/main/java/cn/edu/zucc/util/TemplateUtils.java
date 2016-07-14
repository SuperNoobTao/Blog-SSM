package cn.edu.zucc.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * Created by shentao on 2016/6/12.
 */
public class TemplateUtils {

    //模版文件夹配置，单例
    private static Configuration configuration = null;
    private TemplateUtils(){

    }
    public static Configuration getConfiguration(String templateDir) throws IOException {
        if(configuration==null){
            configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(templateDir));
        }
        return configuration;
    }

    //向ftl模版中的数据替换
    public static  boolean parserTemplate(String templateDir, String ftlPath, Map<String, Object> map, OutputStream os) {
        try {
            System.out.println("向ftl模版中的数据替换"+templateDir);
            System.out.println("向ftl模版中的数据替换"+ftlPath);

            Template template = getConfiguration(templateDir).getTemplate(ftlPath, "UTF-8");
            template.process(map, new OutputStreamWriter(os, "UTF-8"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
