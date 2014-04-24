package com.springinaction.jdbc.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class JdbcExampleMain.
 */
public class JdbcExampleMain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("jdbc-example.xml");
		try {
		final JdbcExampleDAO jdbcExampleDAO = (JdbcExampleDAO) context.getBean("jdbcExampleDAO");
		Test test = new Test();
		test.setId(3);
		test.setName("Alexei Sayle");
		jdbcExampleDAO.insertARow(test);
		System.out.println(jdbcExampleDAO.readRowByIdWithRowMapper(10));
		} finally {
			context.close();
		}
	}
	
}
