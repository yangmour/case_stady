package com.xiwen.servlet; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -18:25
 * @Version: 1.0
 */

import com.xiwen.bean.Soldier;
import com.xiwen.service.SoldierService;
import com.xiwen.service.impl.SoldierServiceImpl;
import com.xiwen.utils.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowSoldierServlet", value = "/index.html")
public class ShowSoldierServlet extends ViewBaseServlet {
    private SoldierService soldierService = new SoldierServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Soldier> list = soldierService.getAll();
        request.setAttribute("items", list);
        processTemplate("index", request, response);

    }
}
