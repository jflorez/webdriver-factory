package org.jflorez.driver;

import java.util.Map;
import java.util.stream.Collectors;

import org.reflections.Reflections;

public class DriverFactoryBuilder {

	
	public static DriverFactory getFactory(String browser) throws Exception {
		return factoryClasses.entrySet()
				.stream()
				.filter(e -> e.getKey().contains(browser.toLowerCase()))
				.findFirst()
				.orElseThrow(() -> new Exception("Driver factory " + browser + " not supported"))
				.getValue()
				.getConstructor()
				.newInstance();
	}

	public static DriverFactory getFactory(String browser, String gridUrl) throws Exception {
		return new RemoteDriverFactory(browser, gridUrl);
	}

	private static final Map<String, Class<? extends DriverFactory>> factoryClasses = new Reflections(
			DriverFactoryBuilder.class.getPackageName())
				.getSubTypesOf(DriverFactory.class)
				.stream()
				.collect(Collectors.toMap(type -> type.getName().toLowerCase(), type -> type));

}
