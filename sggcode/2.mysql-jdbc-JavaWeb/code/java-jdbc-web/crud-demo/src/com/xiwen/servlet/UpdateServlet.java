package com.xiwen.servlet;

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

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 19:20
 * @Version: 1.0
 */
@WebServlet(value = "/updateServlet")
public class UpdateServlet extends ViewBaseServlet {
    private SoldierService soldierService = new SoldierServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        String soldierId = request.getParameter("soldierId");


        if (method == null) {
            Soldier soldier = new Soldier();

            try {
                BeanUtils.populate(soldier, request.getParameterMap());
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean f = soldierService.update(soldier);
            if (f) {
                response.sendRedirect(request.getContextPath() + "/index.html");
            } else {
                request.setAttribute("mgs", "保存失败!");
                processTemplate("save", request, response);
            }
        } else if ("update".equals(method)) {
            Soldier soldier = soldierService.getById(soldierId);
            request.setAttribute("soldierId", soldier.getSoldierId());
            request.setAttribute("soldierName", soldier.getSoldierName());
            request.setAttribute("soldierWeapon", soldier.getSoldierWeapon());
            processTemplate("update", request, response);
        }


    }
}