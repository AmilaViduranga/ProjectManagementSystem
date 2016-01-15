package com.im.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory();
	}
}
