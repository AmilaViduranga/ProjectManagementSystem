package com.pms.model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Group group = new Group();
		group.setGroupId("1");
		
		

		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory();
		Session sesscion = sf.openSession();
		sesscion.beginTransaction();
		sesscion.save(group);
		sesscion.getTransaction().commit();
	}

}
