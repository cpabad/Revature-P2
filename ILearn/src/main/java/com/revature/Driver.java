package com.revature;

import com.revature.util.HibernateSessionFactory;

public class Driver {
	
	public static void main(String[] args) {
		
		//Testing if we successfully map our models to the tables in the database. 
		HibernateSessionFactory.getSession();
	}

}
