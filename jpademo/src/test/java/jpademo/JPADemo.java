package jpademo;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JPADemo {

    @Test
    public void openEenConnectieNaarMysql() throws SQLException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql5-hibernate5-pu");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Cursist cursist = new Cursist(5,"Mat","InfoSupport");
        entityManager.persist(cursist);
        cursist.setNaam("TochNietMat");
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Saved object: " + cursist.toString());
    }

}
