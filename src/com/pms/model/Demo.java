package com.pms.model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member = new Member();
		
		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory();
		Session sesscion = sf.openSession();
		sesscion.beginTransaction();
		sesscion.save(member);
		sesscion.getTransaction().commit();
	}

}
