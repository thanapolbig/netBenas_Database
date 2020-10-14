/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tstulate file, choose Tools | Tstulates
 * and open the tstulate in the editor.
 */
package javaapplication2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ASUS
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student stu1 = new Student(1, "Jack", 2.00);
       Student stu2 = new Student(2, "Marry", 3.00);
       StudentTable.insertStudent(stu1);
       StudentTable.insertStudent(stu2);
//       Student stu;
//       stu = StudentTable.findStudentById(1);
//       if (stu != null) {
//           stu.setName("Jack");
//           StudentTable.removeStudent(stu1);
//           StudentTable.updateStudent(stu);
//       }
       //List<Student> stuList = StudentTable.findStudentByName("Marry"); 
//       List<Student> stuList = StudentTable.findAllStudent();
//       printAllStudent(stuList);
    }
       
    public static void printAllStudent(List<Student> StudentList) {
        for(Student stu : StudentList) {
           System.out.print(stu.getId() + " ");
           System.out.print(stu.getName() + " ");
           System.out.println(stu.getGpa()+ " ");
       }
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
    
}
