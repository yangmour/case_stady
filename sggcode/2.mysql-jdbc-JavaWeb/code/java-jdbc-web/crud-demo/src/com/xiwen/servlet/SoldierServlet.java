package com.xiwen.servlet; /**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/22 -13:57
 * @Version: 1.0
 */

import com.xiwen.bean.Soldier;
import com.xiwen.service.SoldierService;
import com.xiwen.service.impl.SoldierServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SoldierServlet", value = "/soldierServlet")
public class SoldierServlet extends BaseServlet {

    private SoldierService soldierService = new SoldierServiceImpl();

    protected void showSoldiers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Soldier> list = soldierService.getAll();
        request.setAttribute("items", list);
        processTemplate("show", request, response);
    }

    protected void toSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("save", request, response);
    }

    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Soldier soldier = new Soldier();
        try {
            BeanUtils.populate(soldier, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean f = soldierService.saveSoldier(soldier);
        if (f) {
            response.sendRedirect(request.getContextPath() + "/soldierServlet?method=showSoldiers");
        } else {
            request.setAttribute("mgs", "保存失败!");
            processTemplate("save", request, response);
        }
    }

    protected void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String soldierId = request.getParameter("soldierId");
        Soldier soldier = soldierService.getById(soldierId);
        request.setAttribute("soldierId", soldier.getSoldierId());
        request.setAttribute("soldierName", soldier.getSoldierName());
        request.setAttribute("soldierWeapon", soldier.getSoldierWeapon());
        processTemplate("update", request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Soldier soldier = new Soldier();
        try {
            BeanUtils.populate(soldier, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean f = soldierService.update(soldier);
        if (f) {
            response.sendRedirect(request.getContextPath() + "/soldierServlet?method=showSoldiers");
        } else {
            request.setAttribute("mgs", "保存失败!");
            processTemplate("save", request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean f = soldierService.delete(Integer.parseInt(id));
        if (f) {
            response.sendRedirect(request.getContextPath() + "/soldierServlet?method=showSoldiers");
        } else {
            request.setAttribute("mgs", "删除失败!");
            processTemplate("deleteServlet", request, response);
        }
    }
}
