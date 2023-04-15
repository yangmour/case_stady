package com.xiwen.controller;

import com.xiwen.bean.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/15 -13:56
 * @Version: 1.0
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("toIndexPage")
    public String toIndexPage() {
        return "index";
    }

    /**
     * get请求保存
     * post请求正常
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "requestBodyTest", method = {RequestMethod.GET, RequestMethod.POST})
    public String requestBodyTest(@RequestBody String body) {
        System.out.println("body = " + body);
        return "success";
    }

    @RequestMapping(value = "requestHttpEntityTest", method = {RequestMethod.GET, RequestMethod.POST})
    public String requestHttpEntityTest(HttpEntity<String> entity) {
        System.out.println("headers = " + entity.getHeaders());
        System.out.println("body = " + entity.getBody());
        return "success";
    }

    /**
     * @ResponseBody 将当前方法的返回值直接写给请求发送者
     * 位置：
     * 类上：当前类的所有方法的返回值都是响应数据
     * 方法上： 当前方法的返回值是响应数据
     * 注意：和Thymeleaf毫无关系
     */
    @ResponseBody
    @RequestMapping(value = "responseBodyTest", method = {RequestMethod.GET, RequestMethod.POST})
    public String responseBodyTest() {
        return "<h2 style='color:red'>success<h2>";
    }

    @ResponseBody
    @RequestMapping(value = "downLoad", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<byte[]> downLoadTest(HttpServletRequest httpServletRequest) {

        //获取上下文
        ServletContext servletContext = httpServletRequest.getServletContext();
        //动态获取服务器上的路径
        String realPath = servletContext.getRealPath("/upload");
//        String fileName = "day1.txt";
//        String fileName = "wm.jpg";
        String fileName = "面试.mp4";
        FileInputStream fileInputStream = null;
        ResponseEntity<byte[]> responseEntity = null;
        System.out.println(realPath);
        try {
            fileInputStream = new FileInputStream(realPath + "/" + fileName);

            byte[] bytes = new byte[fileInputStream.available()];

            fileInputStream.read(bytes);

            String encode = URLEncoder.encode(fileName, "UTF-8");
            System.out.println(encode);
            MultiValueMap<String, String> headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename=" + encode);
            responseEntity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return responseEntity;
    }

    @RequestMapping("userJson")
    @ResponseBody
    public User userJsonTest() {
        User user = new User(1000, "admin", "root");
        System.out.println(user);
        return user;
    }

    @RequestMapping("upload")
    public String uploadTest(
            String desc,
            @RequestParam("abc") MultipartFile[] abc,
            @RequestParam("file") MultipartFile[] files, HttpServletRequest httpServletRequest) throws IOException {
        System.out.println("介绍" + desc);
        for (MultipartFile file : abc) {
            if (!file.isEmpty()) {
                upload(file, httpServletRequest);
            }
        }

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                upload(file, httpServletRequest);
            }
        }
        return "success";
    }

    private void upload(MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {
        //后去文件名称
        String originalFilename = System.currentTimeMillis() + file.getOriginalFilename();
        //写入到服务器的文件夹路径
        String realPath = httpServletRequest.getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        file.transferTo(new File(realPath, originalFilename));
    }

    @RequestMapping("/aa/bb/cc")
    public String uploadTest() {
        System.out.println("/aa/bb/cc");
        return "success";
    }
}
