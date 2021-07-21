# Angles-testng

To configure the client, see the main [Angles-Java-Client Read Me](../README.md).

### Maven dependency
Simply add the following dependency to your POM:
``` xml
<dependency>
  <groupId>com.github.angleshq</groupId>
  <artifactId>angles-testng</artifactId>
  <version>1.0.27</version>
</dependency>
```

### Implementing
Extend your base/test class with:
``` java
MyTests extends AnglesTestngBaseTest {
...
}
```

### Assertions

Once you extend the Angles base test, you will have access to the doAssert object, which wraps the TestNG Assert methods (and a few more.)
```java
doAssert.assertEquals(expected, actual, "info about assertion");
```
