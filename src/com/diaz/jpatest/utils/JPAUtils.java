package com.diaz.jpatest.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Diaz
 * @since 2019/1/8 9:55
 */
public class JPAUtils {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    public static EntityManager getEntityManger() {
        return factory.createEntityManager();
    }
}
