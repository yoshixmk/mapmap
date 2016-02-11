package com.mycompany.myproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import ch.qos.logback.classic.Level;
import de.agilecoders.wicket.core.Bootstrap;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see com.mycompany.myproject.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here

		// if you want to customize bootstrap:
		//BootstrapSettings settings = new BootstrapSettings();
		//settings.setXXX(...);
		// best place to do this is in Application#init()
		Bootstrap.install(this);

    	//logback test
    	Logger logger = LoggerFactory.getLogger("sampleLogger");
    	logger.info("Hello Logback!!");

        ch.qos.logback.classic.Logger log = (ch.qos.logback.classic.Logger)logger;
        //log.setLevel(Level.TRACE); // traceレベルが出せるようにする

        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");

        logger.info("{} {}", "HOGE", "FUGA");
        Integer smile = 2525;
        logger.info("{} {}", "HOGE", smile);

        try {
            throw new Exception("test exception");
        } catch (Exception e) {
            logger.info("error", e);
        }
	}
}
