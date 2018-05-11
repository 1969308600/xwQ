package com.mybatis.web.test.freemaker;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class test2 {
	
	public static void main(String[] args) {
		createHtmlFromStringList();
	}
	/**
     * 根据String模板生成HTML，模板中存在List循环
     */
    public static void createHtmlFromStringList() {
        BufferedInputStream in = null;
        FileWriter out = null;
        try {
            //模板文件
            File file = new File("d://test.html");
            //构造输入流
            in = new BufferedInputStream(new FileInputStream(file));
            int len;
            byte[] bytes = new byte[1024];
            //模板内容
            StringBuilder content = new StringBuilder();
            while((len = in.read(bytes)) != -1) {
                content.append(new String(bytes, 0, len, "utf-8"));
            }
            
            //构造Configuration
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            //构造StringTemplateLoader
            StringTemplateLoader loader = new StringTemplateLoader();
            //添加String模板
            loader.putTemplate("test", content.toString());
            //把StringTemplateLoader添加到Configuration中
            configuration.setTemplateLoader(loader);
            
            //构造Model
            Classes classes = new Classes();
            classes.setClassId("23");
            classes.setClassName("实验一班");
            List<User> users = new ArrayList<User>();
            User user = new User("tom", "kkkkk", 29, "北京");
            users.add(user);
            User user2 = new User("Jim", "hhhh", 22, "上海");
            users.add(user2);
            User user3 = new User("Jerry", "aaaa", 25, "南京");
            users.add(user3);
            classes.setUsers(users);
            //获取模板
            Template template = configuration.getTemplate("test");
            //构造输出路
            out = new FileWriter("d://result.html");
            //生成HTML
            template.process(classes, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if(null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

}
