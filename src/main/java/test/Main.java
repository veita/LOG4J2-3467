

package test;


import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class Main
{
	private static final Logger logger = LoggerFactory.getLogger(Main.class);


	public static void main(String[] p_args)
	{
		System.out.println(
			"Log4J " +
			org.apache.logging.log4j.Logger.class.getPackage().getImplementationVersion() +
			"\n");

		// logged with both Log4J 2.17.1 and 2.17.2
		logger.error("ERROR1");

		// code extracted from third-party library bytecode
		// actually the properties are not empty there
		PropertyConfigurator.configure(new Properties());

		// this is logger with Log4J 2.17.1 but not with 2.17.2
		logger.error("ERROR2");

		System.out.println("\nExpected output: ERROR1 and ERROR2");
	}
}
