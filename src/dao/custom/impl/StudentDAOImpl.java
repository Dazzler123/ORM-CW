package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student); // save new student
        
//        try {
//            session.save();
//            return true;
//        } catch(Exception e) {
//            System.out.println("somthing happend");
//            return false;
//        } finally {
//            session.close();
//        }

        transaction.commit();
        session.close();

        return true;
    }
}
