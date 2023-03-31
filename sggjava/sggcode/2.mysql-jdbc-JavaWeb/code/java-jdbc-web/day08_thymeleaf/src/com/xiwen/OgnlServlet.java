package com.xiwen; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -15:08
 * @Version: 1.0
 */

import com.xiwen.bean.Computer;
import com.xiwen.bean.Employees;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OgnlServlet", value = "/thymeleafOgnlTest")
public class OgnlServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employees> employees = new ArrayList<>();
        employees.add(new Employees(1, "李小龙", 20, 50000D, "中国", new Computer(101, "联想", 1000D)));
        employees.add(new Employees(2, "叶问", 20, 20000D, "中国", new Computer(102, "小米", 2000D)));
        employees.add(new Employees(3, "洪金宝", 20, 60000D, "中国", new Computer(103, "华为", 6000D)));

        request.setAttribute("list", employees);

        Map<String, Employees> map = new HashMap<>();
        map.put("m1", new Employees(1, "李小龙", 20, 50000D, "中国", new Computer(101, "联想", 1000D)));
        map.put("m2", new Employees(2, "叶问", 20, 20000D, "中国", new Computer(102, "小米", 2000D)));
        map.put("m3", new Employees(3, "洪金宝", 20, 60000D, "中国", new Computer(103, "华为", 6000D)));

        request.setAttribute("map", map);
        processTemplate("ognlDemo", request, response);
    }
}
