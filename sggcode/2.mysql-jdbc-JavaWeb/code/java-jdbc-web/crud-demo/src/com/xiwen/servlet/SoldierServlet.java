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
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "SoldierServlet", value = "/soldierServlet")
public class SoldierServlet extends BaseServlet {

    private SoldierService soldierService = new SoldierServiceImpl();

    protected void showSoldiers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<Integer, Soldier> soldierMap = (Map<Integer, Soldier>) request.getServletContext().getAttribute("soldiers");
        List<Soldier> list = null;

        if (soldierMap != null) {
            System.out.println("从缓存中获取");
            list = soldierMap.values().stream().collect(Collectors.toList());
        } else {
            System.out.println("在数据库查询获取");
            list = soldierService.getAll();
            soldierMap = list.stream().collect(Collectors.toMap(Soldier::getSoldierId, s -> s));
            //设置全局共享域
            ServletContext servletContext = request.getServletContext();
            servletContext.setAttribute("soldiers", soldierMap);
        }
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
        Map<Integer, Soldier> soldierMap = (Map<Integer, Soldier>) request.getServletContext().getAttribute("soldiers");
        if (soldierMap != null) {
            System.out.println("缓存中保存了一份");
            soldierMap.put(soldier.getSoldierId(), soldier);
        }
        if (f) {
            response.sendRedirect(request.getContextPath() + "/soldierServlet?method=showSoldiers");
        } else {
            request.setAttribute("mgs", "保存失败!");
            processTemplate("save", request, response);
        }
    }

    protected void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String soldierId = request.getParameter("soldierId");
        Soldier soldier = null;
        Map<Integer, Soldier> soldierMap = (Map<Integer, Soldier>) request.getServletContext().getAttribute("soldiers");
        if (soldierMap != null) {
            soldier = soldierMap.get(Integer.parseInt(soldierId));
        } else {
            soldier = soldierService.getById(soldierId);

        }
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
        Map<Integer, Soldier> soldierMap = (Map<Integer, Soldier>) request.getServletContext().getAttribute("soldiers");
        if (soldierMap != null) {
            soldierMap.put(soldier.getSoldierId(), soldier);
        }
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
        Map<Integer, Soldier> soldierMap = (Map<Integer, Soldier>) request.getServletContext().getAttribute("soldiers");
        if (soldierMap != null) {
            soldierMap.remove(Integer.parseInt(id));
        }
        if (f) {
            response.sendRedirect(request.getContextPath() + "/soldierServlet?method=showSoldiers");
        } else {
            request.setAttribute("mgs", "删除失败!");
            processTemplate("deleteServlet", request, response);
        }
    }

    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        Map<Integer, Soldier> soldierMap = (Map<Integer, Soldier>) request.getServletContext().getAttribute("soldiers");
        List<Soldier> list = null;
        if (soldierMap != null && !StringUtils.isEmpty(key)) {
            list = soldierMap.values().stream()
                    .filter(s -> s.getSoldierName().contains(key) || s.getSoldierWeapon().contains(key))
                    .collect(Collectors.toList());
            request.setAttribute("items", list);
            processTemplate("show", request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/soldierServlet?method=showSoldiers");
        }

    }
}
