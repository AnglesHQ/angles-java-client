# angles-cucumberjvm


### Maven dependency
Simply add the following dependency to your POM:
``` xml
<dependency>
  <groupId>com.github.angleshq</groupId>
  <artifactId>angles-cucumberjvm-legacy</artifactId>
  <version>1.0.27</version>
</dependency>
```

### Cucumber 2 Setup
Extend the step definition file with: 
```java
public class StepDef extends AnglesCucumber2Adapter {}
```

Include `AnglesCucumber2Adapter` as a plugin in the *run with* class if you run through `Maven`
```java
@CucumberOptions(plugin = { "com.github.angleshq.angles.listeners.cucumber.AnglesCucumber2Adapter"})   
```
Inside the `step definition` class, you need to include an empty `@Before` method to allow instantiation of the `Angles` reporter.

```java
@Before
    public static void initilizeAnglesAdapter() {
}
```
