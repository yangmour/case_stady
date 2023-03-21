package com.xiwen.servlet; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -18:59
 * @Version: 1.0
 */

import com.xiwen.bean.Soldier;
import com.xiwen.service.SoldierService;
import com.xiwen.service.impl.SoldierServiceImpl;
import com.xiwen.utils.ViewBaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveServlet")
public class SaveServlet extends ViewBaseServlet {
    private SoldierService soldierService = new SoldierServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method == null) {
            Soldier soldier = new Soldier();
            try {
                BeanUtils.populate(soldier, request.getParameterMap());
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean f = soldierService.saveSoldier(soldier);
            if (f) {
                response.sendRedirect(request.getContextPath() + "/index.html");
            } else {
                request.setAttribute("mgs", "保存失败!");
                processTemplate("save", request, response);
            }
        } else if ("add".equals(method)) {
            processTemplate("save", request, response);
            return;
        }


    }
}
