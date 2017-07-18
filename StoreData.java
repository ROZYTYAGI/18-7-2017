package com.employee;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;  
  
public class StoreData { 
	
	public static Session getSession()
	{
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory=cfg.buildSessionFactory();
	    Session session=factory.openSession(); 
	    return session;
	}
public static void main(String[] args) {  
      
    //creating configuration object  
    //populates the data of the configuration file  
      
    //creating seession factory object  
      
      
    //creating session object  
    //Session session = getSession();
      
    //creating transaction object  
   // Transaction t=session.beginTransaction();  
          
   /* Employee e1=new Employee();  
    e1.setId(115);  
    e1.setFirstName("sonoo");  
    e1.setLastName("jaiswal");  */
   /* Person e1=new Person();  
    e1.setId(1);  
    e1.setFirstName("sonoo");  
    e1.setLastName("jaiswal");
      
    session.persist(e1);//persisting the object  
      
    t.commit();//transaction is committed 
    
    session.close();  */
      
    //System.out.println("successfully saved"); 
    
  //Employee e= getEmployee(115);
   //System.out.println(e); 
  /*  List<Person> person= getAllPerson();
    System.out.println(person); */
    /*List<Airport> airport= getAllAirport();
    System.out.println(airport);*/
    List<Employee> employee= getAllEmployee();
    System.out.println(employee);
      
}  

public static Employee getEmployee(final int n)
{
	Employee e=null;
	Session session = getSession();
	 Transaction t=session.beginTransaction();  
	 e=(Employee)session.get(Employee.class, n);
	 t.commit();
	 session.close();
	return e;
} 
public static Airport getAirport(final int n)
{
	Airport e=null;
	Session session = getSession();
	 Transaction t=session.beginTransaction();  
	 e=(Airport)session.get(Airport.class, n);
	 t.commit();
	 session.close();
	return e;
} 


public static Person getPerson(final int n)
{
	Person e=null;
	Session session = getSession();
	 Transaction t=session.beginTransaction();  
	 e=(Person)session.get(Person.class, n);
	 t.commit();
	 session.close();
	return e;
} 
public static List<Person> getAllPerson()
{
	Session session = getSession();
	 Transaction t=session.beginTransaction(); 
	 Query query= session.createQuery("from Employee");
	 List<Person> list=query.list();
	 t.commit();
	 session.close();
	return list;
	}
public static List<Airport> getAllAirport()
{
	Session session = getSession();
	 Transaction t=session.beginTransaction(); 
	 Query query= session.createQuery("from Airport");
	 List<Airport> list=query.list();
	 t.commit();
	 session.close();
	return list;
	}
public static List<Employee> getAllEmployee()
{
	Session session = getSession();
	 Transaction t=session.beginTransaction(); 
	 Query query= session.createQuery("from Employee");
	 List<Employee> list=query.list();
	 t.commit();
	 session.close();
	return list;
	}
}


