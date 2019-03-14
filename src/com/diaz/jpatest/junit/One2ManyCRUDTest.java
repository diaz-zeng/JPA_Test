package com.diaz.jpatest.junit;

import com.diaz.jpatest.entity.Customer;
import com.diaz.jpatest.entity.LinkMan;
import com.diaz.jpatest.utils.JPAUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @author Diaz
 * @since 2019/1/8 10:22
 */
public class One2ManyCRUDTest {

    public EntityManager entityManager;
    public EntityTransaction transaction;

    @Before
    public void before() {
        entityManager = JPAUtils.getEntityManger();
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    @Test
    public void save() {
        Customer customer = new Customer();
        customer.setName("Tom");
        LinkMan linkMan = new LinkMan();
        linkMan.setName("Tom`LinkMan #1");
        customer.getLinkMans().add(linkMan);
        linkMan.setCustomer(customer);
        entityManager.persist(customer);
    }


    @Test
    public void update() {
        Customer customer = entityManager.find(Customer.class, 5L);
        LinkMan linkMan = new LinkMan();
        linkMan.setName("Tom`LinkMan #2");
        customer.getLinkMans().add(linkMan);
        linkMan.setCustomer(customer);
//        entityManager.persist(linkMan);
        entityManager.merge(customer);
    }

    @Test
    public void get(){
        Customer customer = entityManager.find(Customer.class,5L);
        customer.getLinkMans().forEach(System.out::println);
    }

    @Test
    public void delete(){
        entityManager.remove(entityManager.find(Customer.class,5L));
    }

    @After
    public void after() {
        transaction.commit();
    }
}
