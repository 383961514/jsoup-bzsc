package com.mt.oaut;

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mysql.jdbc.Connection;

import JDBC.db.Utils;
import JDBC.mainMethod.Method;
import JDBC.model.StatModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: xgr01
 * Date: 13-12-30
 * Time: 上午11:10
 * To change this template use File | Settings | File Templates.
 */
public class JSoupTest {
    public static void main(String args[]) throws IOException,  ClassNotFoundException, SQLException {
        String baseUrl = "http://www.bzjw.com/standard/";
        String ajaxUrl = "http://www.bzjw.com/include/getinfo.asp?info_x=stdsort&class_x=GB%B9%FA%B1%EA&order_x=" ;

        Document baseDoc = getDoc("http://www.bzjw.com/standard/showstd.asp?id_x=1");
        System.out.println(baseDoc.select(".sort_title_ul li").text());
//       
       
        for(int i=1;i<13;i++){
            String aUrl =ajaxUrl+i;
            System.out.println(aUrl);
            Document ajaxDoc = getDoc(aUrl);
            System.out.println(ajaxDoc.select("a").text());
           
            for(Element e : ajaxDoc.select("a")){
                System.out.println(baseUrl+e.attr("href"));
                Document picDoc = getDoc(baseUrl+e.attr("href"));
                Elements eles = picDoc.select(".detail_l .detail .top .l");
                String sqName = eles.get(0).child(0).text();
                String oldName = eles.get(0).child(1).text();
                String usName = eles.get(0).child(2).text();
                
                Elements piceles = picDoc.select(".detail_l .detail .box");
                String srcImage = piceles.get(0).child(0).attr("src");
                System.out.println("");
                String imageName = new Date().getTime() + ""; 
                getImg(srcImage, imageName);
                
                StatModel model = new StatModel();
                model.setSqName(sqName);
                model.setOldName(oldName);
                model.setUsName(usName);
                model.setImageName(imageName);
                model.setSrcImage(srcImage);
               
                Method.insert(model);
                
                
                
                
            } 
        }
//        for
    }

    private static void getImg(String img, String name){
        try {
            //根据String形式创建一个URL对象，
            URL url = new URL(img);
            //实列一个URLconnection对象，用来读取和写入此 URL 引用的资源
            URLConnection con = url.openConnection();
            //获取一个输入流
            InputStream is = con.getInputStream();
            //实列一个输出对象
            FileOutputStream fos = new FileOutputStream("../image/"+name+".jpg");
            //一个byte[]数组，一次读取多个字节
            byte[] bt = new byte[1024];
            //用来接收每次读取的字节个数
            int b = 0;
            //循环判断，如果读取的个数b为空了，则is.read()方法返回-1，具体请参考InputStream的read();
            while ((b = is.read(bt)) != -1) {
                //将对象写入到对应的文件中
                fos.write(bt, 0, b);
            }
            //刷新流
            fos.flush();
            //关闭流
            fos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Document getDoc(String url){
        try {
            Document doc = Jsoup
                    .connect(url)
                    .timeout(30000)
                    .get();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    /**
     * 从字符串中获取数字
     * @param id
     * @return
     */
    private static int getNum(String id){
        String str=id.trim();
        String str2="";
        if(str != null && !"".equals(str)){
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>=48 && str.charAt(i)<=57){
                    str2+=str.charAt(i);
                }
            }

        }
        System.out.println(Integer.parseInt(str2));
        return Integer.parseInt(str2);
    }

}
