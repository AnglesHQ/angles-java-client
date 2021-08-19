# angles-java-client


### Maven dependency
The Angles java client allows various Java Test Execution frameworks to take advantage of the Angles Dashboard.

At the moment we provide libraries for the following the following java execution frameworks:
- [TestNG](./angles-testng/README.md)
- [Junit5](./angles-junit5/README.md)
- [CucumberJVM](./angles-cucumberjvm/README.md)

If your own java test execution framework is not in the list, you are able to use the Angles Java client directly by adding the [angles-java-core](./angles-java-core/README.md) as a dependency.


### Configuring the clients
Please ensure you set the following system variables (e.g. as part of the maven-surefire-plugin):
```
<systemPropertyVariables>
    <angles.enabled>true</angles.enabled>
    <angles.url>http://127.0.0.1:3000</angles.url>
    <angles.runName>SampleRunName</angles.runName>
    <angles.team>SampleTeamName</angles.team>
    <angles.component>SampleComponent</angles.component>
    <angles.environment>SampleEnvironmentName</angles.environment>
    <!-- optional -->
    <angles.phase></angles.phase>
</systemPropertyVariables>
```

### Log4j2 Appender 
Add the appender to your log4j2 configuration file:
```
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="INFO" packages="com.github.angleshq.angles.listeners.log4j2.AnglesLog4j2LogAppender">
    <Appenders>
        <AnglesLog4j2LogAppender name="AnglesLog4j2LogAppender"/>
    </Appenders>
    <Loggers>
        <Root level="debug">
            <AppenderRef ref="AnglesLog4j2LogAppender"/>
        </Root>
    </Loggers>
</Configuration>
```
Please bear in mind that this appender standalone will not be able to push logs to your Angles Dashboard and requires this to be coupled with a test execution framework like JUnit5 or Testng. i.e. This plugin will not create new runs/builds.
