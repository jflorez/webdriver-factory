package org.jflorez.environment;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EnvironmentVariables {

	private static EnvironmentVariables instance;

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	private final String environmentKey = "SELENIUM_URL";
	private final String browserKey = "SELENIUM_BROWSER";
	private final String gridURLKey = "SELENIUM_GRID_URL";
	private final String implicitWaitKey = "SELENIUM_WAIT";
	private final String headlessKey = "SELENIUM_HEADLESS";

	private EnvironmentVariables() {
		
		var allEnvironmentVariables = List.of(environmentKey, browserKey, implicitWaitKey, gridURLKey, headlessKey);
		logger.log(Level.FINE, "Environment variables set: {0}", System.getenv()
																	   .entrySet()
																	   .stream()
																	   .filter(e -> allEnvironmentVariables.contains(e.getKey()))
																	   .map(Object::toString)
																	   .collect(Collectors.joining("\n", "\n", "\n")));

		var missingEnvironmentVariables = List.of(environmentKey, browserKey, implicitWaitKey)
												.stream()
												.filter(v -> !System.getenv().containsKey(v))
												.collect(Collectors.toList());

		if (!missingEnvironmentVariables.isEmpty()) {
			final String message = "Mandatory environment variables not set:\n"+ String.join("\n", missingEnvironmentVariables);
			logger.log(Level.SEVERE, message);
			throw new RuntimeException(message);
		}

	}

	public static EnvironmentVariables getInstance() {
		if (instance == null) {
			instance = new EnvironmentVariables();
		}
		return instance;
	}

	public String getEnvironment() {
		return System.getenv(environmentKey);
	}

	public String getBrowser() {
		return System.getenv(browserKey);
	}

	public int getImplicitWait() {
		return Integer.parseInt(System.getenv(implicitWaitKey));
	}

	public String getGridURL() {
		return System.getenv(gridURLKey) == null ? "" : System.getenv(gridURLKey);
	}
	
	public boolean isHeadless() {
		return System.getenv(headlessKey) == null ? true : Boolean.parseBoolean(System.getenv(headlessKey));
	}

}
