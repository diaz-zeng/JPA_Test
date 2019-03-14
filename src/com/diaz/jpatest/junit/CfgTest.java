package com.diaz.jpatest.junit;

import com.diaz.jpatest.utils.JPAUtils;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Diaz
 * @since 2019/1/8 10:00
 */
public class CfgTest {
    @Test
    public void test_Conn(){
        JPAUtils.getEntityManger().unwrap(Session.class).doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println(connection);
            }
        });
    }
}
