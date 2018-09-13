package com.jflorez.environment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnvironmentVariables {

	private static final EnvironmentVariables instance = new EnvironmentVariables();

	private final String environmentKey = "Environment";
	private final String browserKey = "Browser";
	private final String remoteBrowserKey = "RemoteBrowser";
	private final String gridURLKey = "GridURL";
	private final String implicitWaitKey = "ImplicitWait";

	private final List<String> mandatoryVariables = Arrays.asList(environmentKey, browserKey, implicitWaitKey);

	private EnvironmentVariables() {
		var missingEnvironmentVariables = mandatoryVariables.stream()
				.filter(v -> !System.getenv().containsKey(v))
				.collect(Collectors.toList());

		if (!missingEnvironmentVariables.isEmpty()) {
			throw new RuntimeException(
					"Mandatory environment variables not set:\n" + String.join("\n", missingEnvironmentVariables));
		}

	}

	public static EnvironmentVariables getInstance() {
		return instance;
	}

	public String getEnvironment() {
		return System.getenv(environmentKey);
	}

	public String getBrowser() {
		return System.getenv(browserKey);
	}

	public String getRemoteBrowser() {
		return System.getenv(remoteBrowserKey) == null ? "Chrome" : System.getenv(remoteBrowserKey);
	}

	public int getImplicitWait() {
		return Integer.parseInt(System.getenv(implicitWaitKey));
	}

	public String getGridURL() {
		return System.getenv(gridURLKey) == null ? "" : System.getenv(gridURLKey);
	}

}
