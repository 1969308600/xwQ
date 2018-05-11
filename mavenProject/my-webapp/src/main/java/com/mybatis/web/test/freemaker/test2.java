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
     * ����Stringģ������HTML��ģ���д���Listѭ��
     */
    public static void createHtmlFromStringList() {
        BufferedInputStream in = null;
        FileWriter out = null;
        try {
            //ģ���ļ�
            File file = new File("d://test.html");
            //����������
            in = new BufferedInputStream(new FileInputStream(file));
            int len;
            byte[] bytes = new byte[1024];
            //ģ������
            StringBuilder content = new StringBuilder();
            while((len = in.read(bytes)) != -1) {
                content.append(new String(bytes, 0, len, "utf-8"));
            }
            
            //����Configuration
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            //����StringTemplateLoader
            StringTemplateLoader loader = new StringTemplateLoader();
            //���Stringģ��
            loader.putTemplate("test", content.toString());
            //��StringTemplateLoader��ӵ�Configuration��
            configuration.setTemplateLoader(loader);
            
            //����Model
            Classes classes = new Classes();
            classes.setClassId("23");
            classes.setClassName("ʵ��һ��");
            List<User> users = new ArrayList<User>();
            User user = new User("tom", "kkkkk", 29, "����");
            users.add(user);
            User user2 = new User("Jim", "hhhh", 22, "�Ϻ�");
            users.add(user2);
            User user3 = new User("Jerry", "aaaa", 25, "�Ͼ�");
            users.add(user3);
            classes.setUsers(users);
            //��ȡģ��
            Template template = configuration.getTemplate("test");
            //�������·
            out = new FileWriter("d://result.html");
            //����HTML
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
