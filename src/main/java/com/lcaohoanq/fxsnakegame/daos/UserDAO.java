package com.lcaohoanq.fxsnakegame.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Persistence;
import jakarta.persistence.StoredProcedureQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Deprecated
public class UserDAO {

    private static UserDAO instance;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JFXSGPU");

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public int insertMail(String email, String phoneNumber, String firstName, String lastName,
        String password) {
        EntityManager entityManager = getEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = null;
        int rowsAffected = 0;
        try {
            transaction = session.beginTransaction();
            StoredProcedureQuery query = session.createStoredProcedureQuery(
                    "proc_insert_user_new")
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(5, String.class, ParameterMode.IN);

            query.setParameter(1, email);
            query.setParameter(2, phoneNumber);
            query.setParameter(3, firstName);
            query.setParameter(4, lastName);
            query.setParameter(5, password);
            rowsAffected = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return rowsAffected;
    }
}
