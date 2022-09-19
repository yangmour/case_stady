package com.xiwen1.transaction;

import com.xiwen1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class ConnectionTest {

    @Test
    public void test1() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }

}
