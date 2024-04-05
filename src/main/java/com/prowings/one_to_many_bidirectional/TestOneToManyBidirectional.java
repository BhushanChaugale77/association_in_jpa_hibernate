package com.prowings.one_to_many_bidirectional;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.dao.HibernateUtil;

public class TestOneToManyBidirectional {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Account account1 = new Account();
		account1.setAccountName("Savings");
		account1.setAccountNumber(77077);
		
		Account account2 = new Account();
		account2.setAccountName("Current");
		account2.setAccountNumber(99099);
		
		Account account3 = new Account();
		account3.setAccountName("Salary");
		account3.setAccountNumber(55055);

		Set<Account> setOfAcc = new HashSet<Account>();
		setOfAcc.add(account1);
		setOfAcc.add(account2);
		setOfAcc.add(account3);
		
		Employee employee = new Employee();
		employee.setName("Ram");
		employee.setSalary(999999);
		employee.setAccount(setOfAcc);
		
		session.persist(employee);
		
		
		tx.commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		session2.delete(employee);
		
		tx2.commit();
		session2.close();
		
		sessionFactory.close();
		
	}
	
}
