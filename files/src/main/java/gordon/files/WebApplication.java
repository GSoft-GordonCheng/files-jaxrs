package gordon.files;
/**
* @author Gordon
*/

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import redis.clients.jedis.Jedis;

public class WebApplication implements ServletContextListener {

	private JobManager 		jobManager 		= new JobManager();
	private JobProperties 	jobProperties;
	//private JobRedis 		jobRedis;
	public static Properties properties;
	//public static Jedis 		jedis;
			
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		System.out.println("Initializing..." + dateFormat.format(new Date()));
		//jobProperties = new JobProperties();
		//jobRedis = new JobRedis(jobProperties.getProperties());
		//
		//jobManager.add(jobProperties);
		//jobManager.add(jobRedis);
		//jobManager.exec();
		//
		System.out.println("Initialized..." + dateFormat.format(new Date()));
		//
		//properties = jobProperties.getProperties();
		//jedis = jobRedis.getJedis();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}
