package com.cg.go.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	public static EntityManagerFactory getConnection() {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
    	return emf;
}
}