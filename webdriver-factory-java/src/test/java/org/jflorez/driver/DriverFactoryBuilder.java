package org.jflorez.driver;

import java.util.Map;
import java.util.stream.Collectors;

import org.reflections.Reflections;

public class DriverFactoryBuilder {

	
	public static DriverFactory getFactory(String browser) {
		try {
			return factoryClasses.entrySet()
			        .stream()
			        .filter(e -> e.getKey().toLowerCase().contains(browser.toLowerCase()))
			        .findFirst()
			        .orElseThrow()
			        .getValue().getConstructor().newInstance();

		} catch (Exception e) {
			throw new RuntimeException("Driver factory "+browser+ " not supported");
		}
	}

	public static DriverFactory getFactory(String browser, String gridUrl) {
		return new RemoteDriverFactory(browser, gridUrl);
	}

	private static final Map<String, Class<? extends DriverFactory>> factoryClasses = new Reflections(
			DriverFactoryBuilder.class.getPackageName())
				.getSubTypesOf(DriverFactory.class)
				.stream()
				.collect(Collectors.toMap(type -> type.getName().toLowerCase(), type -> type));

}
