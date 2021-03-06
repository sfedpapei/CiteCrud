package org.citecrud.integration;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration (locations ={"/persistence-beans.xml"})
public class HibernateConfigurationTests extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testHibernateConfiguration() {
		assertNotNull(sessionFactory);
	}

}
