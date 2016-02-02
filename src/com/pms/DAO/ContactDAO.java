package com.pms.DAO;

import org.hibernate.Session;

import com.pms.model.ContactInfo;

public class ContactDAO {
	public boolean addContact(ContactInfo contact) {
		Session session = DbConnectionManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(contact);
		return true;
	}
}
