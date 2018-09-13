# Webdriver Factory

This project aims to provide my solution to creating instances of Selenium WebDriver classes for different browsers using the Factory pattern.
The browser type is specified in an environment variable and the factory classes create the appropiate instance of WebDriver.

This project assumes that the diver executable for a given browser is already in the PATH environment variable.

The initial implementation is done in Java. Other languajes (C#, and Python, for now) will follow.

The follwing mandatory environment variables must be set before running the sample tests:
* Environment = https://www.google.com
* Browser = Chrome
* ImplicitWait = 3
