package com.jflorez.driver;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.reflections.Reflections;

public class DriverFactoryBuilder {

	public static DriverFactory getFactory(String browser) {

		Optional<Entry<String, Class<? extends DriverFactory>>> o = factoryClasses.entrySet().stream()
				.filter(e -> e.getKey().contains(browser.toLowerCase())).findFirst();
		if (o.isPresent()) {
			try {
				return o.get().getValue().getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				throw new RuntimeException("Driver factory " + browser + " not supported",e);
			}
		} else {
			return new LocalDriverFactory(browser);
		}

	}

	public static DriverFactory getRemoteFactory(String browser, String gridURL) {
		return new RemoteDriverFactory(browser, gridURL);
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
