package org.jflorez.environment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnvironmentVariables {

//	private static final EnvironmentVariables instance = new EnvironmentVariables();

	private static final String environmentKey = "Environment";
	private static final String browserKey = "Browser";
	private static final String gridURLKey = "GridURL";
	private static final String implicitWaitKey = "ImplicitWait";

	private static final List<String> mandatoryVariables = Arrays.asList(environmentKey, browserKey, implicitWaitKey);
	
	
	static  {
		var missingEnvironmentVariables = mandatoryVariables.stream()
				.filter(v -> !System.getenv().containsKey(v))
				.collect(Collectors.toList());

		if (!missingEnvironmentVariables.isEmpty()) {
			throw new RuntimeException(
					"Mandatory environment variables not set:\n" + String.join("\n", missingEnvironmentVariables));
		}
	}


	public static String getEnvironment() {
		return System.getenv(environmentKey);
	}

	public static String getBrowser() {
		return System.getenv(browserKey);
	}

	public static int getImplicitWait() {
		return Integer.parseInt(System.getenv(implicitWaitKey));
	}

	public static String getGridURL() {
		return System.getenv(gridURLKey);
	}

}
