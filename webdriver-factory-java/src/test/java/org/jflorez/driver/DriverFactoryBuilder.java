package org.jflorez.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public class DriverFactoryBuilder {
	
	public static DriverFactory getFactory(String browser) throws Exception{
		try {
			DriverFactory driverFactory = factoryClasses.entrySet()
			        .stream()
			        .filter(e -> e.getKey().contains(browser.toLowerCase()))
			        .findFirst()
			        .get()
			        .getValue().getConstructor().newInstance();
			return driverFactory;
		} catch (Exception e) {
			throw new Exception("Driver factory "+browser+ " not supported");
		}
	}
	
	public static DriverFactory getFactory(String browser, String gridUrl) throws Exception {
		return new RemoteDriverFactory(browser, gridUrl);
	}
	
	private static final Map<String, Class<? extends DriverFactory>> factoryClasses = loadFactoryClasses();
	
	private static Map<String, Class<? extends DriverFactory>> loadFactoryClasses() {
		var factoryClasses = new HashMap<String, Class<? extends DriverFactory>>();
		Reflections reflections = new Reflections(DriverFactoryBuilder.class.getPackageName());
		Set<Class<? extends DriverFactory>> subTypes = reflections.getSubTypesOf(DriverFactory.class);
		for (var type : subTypes) {
			factoryClasses.put(type.getName().toLowerCase(), type);
		}
		return factoryClasses;
	}

}
