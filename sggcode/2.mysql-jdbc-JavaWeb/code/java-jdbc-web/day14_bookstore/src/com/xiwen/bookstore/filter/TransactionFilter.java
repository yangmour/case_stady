package com.xiwen.bookstore.filter;

import com.xiwen.bookstore.util.JDBCTools;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/29 -14:25
 * @Version: 1.0
 */
@WebFilter(urlPatterns = "/order")
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //开启事务
        Connection connection = JDBCTools.getConnection();
        try {
            connection.setAutoCommit(false);
            filterChain.doFilter(servletRequest, servletResponse);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JDBCTools.close();

        }
    }

    @Override
    public void destroy() {

    }
}
