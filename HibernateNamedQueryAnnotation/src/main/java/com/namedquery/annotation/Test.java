package com.namedquery.annotation;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		TypedQuery query = session.getNamedQuery("findEmployeeByName");
		query.setParameter("name", "izhar");
		List resultList = query.getResultList();
		Iterator iterator = resultList.iterator();
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);

		}
		session.close();
	}

}
