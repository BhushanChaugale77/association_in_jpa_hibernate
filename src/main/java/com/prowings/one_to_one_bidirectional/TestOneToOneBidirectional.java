package com.prowings.one_to_one_bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.dao.HibernateUtil;

 
public class TestOneToOneBidirectional {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee employee = new Employee();
		
		employee.setName("Ram");
		employee.setSalary(777777);
		
		Account account = new Account();
		
		account.setAccountName("Savings");
		account.setAccountNo(9977755);
		
		employee.setAccount(account);
//		account.setEmployee(employee);
		
		
		session.save(employee);
		session.save(account);
		
		tx.commit();

		session.close();
		
		int accId = account.getId();
		int empId = employee.getId();
		
		Session session2 = sessionFactory.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		Employee retrivedEmp = session2.get(Employee.class, empId); 
		
		System.out.println(retrivedEmp.getId());
		System.out.println(retrivedEmp.getName());
		System.out.println(retrivedEmp.getSalary());
		System.out.println(retrivedEmp.getAccount().getAccountNo());
		
		Account retrivedAcc = session2.get(Account.class, accId);
		
		System.out.println(retrivedAcc.getId());
		System.out.println(retrivedAcc.getAccountName());
		System.out.println(retrivedAcc.getAccountNo());
		System.out.println(retrivedAcc.getEmployee().getName());
		
		
		tx2.commit();
		session2.close();
		
		
		sessionFactory.close();
		
		
		
		
	}
	
}
