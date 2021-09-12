# angles-cucumberjvm


### Maven dependency
Simply add the following dependency to your POM:
``` xml
<dependency>
  <groupId>com.github.angleshq</groupId>
  <artifactId>angles-cucumberjvm</artifactId>
  <version>1.0.31</version>
</dependency>
```

### Cucumber Setup
Extend the step definition file with: 
```java
public class StepDef extends AnglesCucumberAdapter {}
```

Include `AnglesCucumber2Adapter` as a plugin in the *run with* class if you run through `Maven`
```java
@CucumberOptions(plugin = { "com.github.angleshq.angles.listeners.cucumber.AnglesCucumberAdapter"})   
```
Inside the `step definition` class, you need to include an empty `@Before` method to allow instantiation of the `Angles` reporter.

```java
@Before
    public static void initilizeAnglesAdapter() {
}
```
