package com.pms.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConfiguration {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory();
	}
}
