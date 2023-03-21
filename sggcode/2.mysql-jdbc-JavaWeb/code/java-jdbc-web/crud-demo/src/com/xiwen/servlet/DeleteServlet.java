package com.xiwen.servlet; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -18:59
 * @Version: 1.0
 */

import com.xiwen.service.SoldierService;
import com.xiwen.service.impl.SoldierServiceImpl;
import com.xiwen.utils.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteServlet")
public class DeleteServlet extends ViewBaseServlet {
    private SoldierService soldierService = new SoldierServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean f = soldierService.delete(Integer.parseInt(id));
        if (f) {
            response.sendRedirect(request.getContextPath() + "/index.html");
        } else {
            request.setAttribute("mgs", "删除失败!");
            processTemplate("deleteServlet", request, response);
        }

    }
}
