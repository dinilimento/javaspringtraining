package jpademo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JPADemo {

    private EntityManagerFactory emf;
    private EntityManager entityManager;

    @Before
    public void setup() {
        emf = Persistence.createEntityManagerFactory("mysql5-hibernate5-pu");
        entityManager = emf.createEntityManager();
    }


    @Test
    public void gebruikJpaOmEenCursistInDeDatabaseTeZetten() throws SQLException {

        entityManager.getTransaction().begin();
        Cursist cursist = new Cursist(1, "Timo", "NN");
        entityManager.persist(cursist);
        entityManager.getTransaction().commit();
    }


    @Test
    public void gebruikJpaOmEenCursistInDeDatabaseTeZettenEnDaarnaTeUpdaten() throws SQLException {

        entityManager.getTransaction().begin();
        Cursist cursist = new Cursist(1, "Cas", "NN");
        entityManager.persist(cursist);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        cursist.setNaam("Timo");
        entityManager.getTransaction().commit();
    }

    @Test
    public void gebruikJpaOmEenCursistInDeDatabaseTeZettenClearPCEnProbeerDaarnaTeUpdaten() throws SQLException {

        entityManager.getTransaction().begin();
        Cursist cursist = new Cursist(1, "Cas", "NN");
        entityManager.persist(cursist);
        entityManager.getTransaction().commit();

        //Hier gooien we de "persistence context" weg, de gemanagede entities worden nu un-managed
        entityManager.clear();

        entityManager.getTransaction().begin();
        //Dit wordt niet verwerkt omdat cursist un-managed is
        cursist.setNaam("Timo");
        entityManager.getTransaction().commit();
    }

    @Test
    public void gebruikJpaOmEenCursistInDeDatabaseTeZettenClearPCEnProbeerDaarnaTeUpdatenMetMerge() throws SQLException {

        entityManager.getTransaction().begin();
        Cursist cursist = new Cursist(1, "Cas", "NN");
        entityManager.persist(cursist);
        entityManager.getTransaction().commit();

        //Hier gooien we de "persistence context" weg, de gemanagede entities worden nu un-managed
        entityManager.clear();

        entityManager.getTransaction().begin();
        //Dit wordt niet verwerkt om dat cursist un-managed is
        cursist.setNaam("Timo");
        entityManager.merge(cursist);
        entityManager.getTransaction().commit();
    }

    @Test
    public void gebruikJpaOmEenCursistInDeDatabaseTeZettenClearPCEnProbeerDaarnaTeUpdatenMetMergeInDeVerkeerdeVolgorde() throws SQLException {

        entityManager.getTransaction().begin();
        Cursist cursist = new Cursist(1, "Cas", "NN");
        entityManager.persist(cursist);
        entityManager.getTransaction().commit();

        //Hier gooien we de "persistence context" weg, de gemanagede entities worden nu un-managed
        entityManager.clear();

        entityManager.getTransaction().begin();
        //Dit wordt niet verwerkt om dat cursist un-managed is
        entityManager.merge(cursist);
        cursist.setNaam("Timo");
        entityManager.getTransaction().commit();
    }

    @Test
    public void gebruikJpaOmEenCursistInDeDatabaseTeZettenWanneerDezeErAlInStaat() throws SQLException {

        entityManager.getTransaction().begin();
        Cursist cursist = new Cursist(1, "Timo", "NN");

        entityManager.persist(cursist);
        try {
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.merge(cursist);
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
        }
    }

    @Test
    public void voegCursistToeMetDiplomaZonderPersistDiploma() throws SQLException {
        entityManager.getTransaction().begin();

        List<Diploma> diplomaList = Arrays.asList(  new Diploma("Java Spring", 7.5),
                                                    new Diploma("AWS", 8));
        Cursist cursist = new Cursist(1, "Timo", "NN", diplomaList);

        entityManager.persist(cursist);
        entityManager.getTransaction().commit();

    }

    @Test
    public void voegCursistToeMetDiplomaMetPersistAlles() throws SQLException {
        entityManager.getTransaction().begin();

        List<Diploma> diplomaList = Arrays.asList( new Diploma("Java Spring", 7.5),
                new Diploma("AWS", 8));

        Cursist cursist = new Cursist(1, "Timo", "NN", diplomaList);

        entityManager.persist(cursist);
        for (Diploma diploma : diplomaList) {
            entityManager.persist(diploma);
        }

        entityManager.getTransaction().commit();

    }

    @After

    public void tearDown() {
        entityManager.close();
        emf.close();
    }

}
