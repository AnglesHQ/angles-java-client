# angles-java-client


### Maven dependency
The angles java client has been published to the maven repository. 

Simply add the following dependency to your POM:
``` xml
<dependency>
  <groupId>com.github.angleshq</groupId>
  <artifactId>angles-junit5</artifactId>
  <version>1.0.28</version>
</dependency>
```

### JUnit5
Extend with the `AnglesJunit5Extension` extension class in order to have the Junit test result logged into Angles. 
Optional `Angles` handled assertions are available at test level by instantiating `AnglesJunit5Assert`.

```java
@ExtendWith(AnglesJUnit5Extension.class)
```

### Using Assertions
In order to do assertions that are captured by the Angles dashboard, you can instantiate the `AnglesJUnit5Assert` at the test script level.

```java
AnglesJUnit5Assert doAssert = new AnglesJUnit5Assert();
```

The Junit5 assert object wraps the Junit5 Assertions methods.
