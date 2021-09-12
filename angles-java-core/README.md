# angles-java-core

If you want to use the Angles Java client directly or we don't have an implementation for the framework that you are using simply follow the steps below to use the Angles java client with your framework.

### Maven dependency
Add the following dependency to your Maven POM:
``` xml
<dependency>
  <groupId>com.github.angleshq</groupId>
  <artifactId>angles-java-core</artifactId>
  <version>1.0.31</version>
</dependency>
```

### Using Angles Core
If the framework you're using has hooks that can be triggered throughout the execution lifecycle then you should be able to trigger the Angles client as per the examples below. 
Most framework will at least have set-up / teardown hooks which are called before and after the tests.

```java
import org.apache.commons.lang3.builder.ToStringExclude;

public class MyBaseTest {

    private static AnglesReporterInterface anglesReporter = AnglesReporter.getInstance("http://127.0.0.1:3000/rest/api/v1.0/");

    /**
     * To be called at the very start of the test run. Please note that the team, 
     * environment and component must match values already configured using the Angles API.
     */
    @BeforeClass
    public void beforeClass() {
        // if you do ever need to disable reporting e.g. for a local run you can us this method.
        //AnglesReporter.setEnabled(false);
        anglesReporter.startBuild("Test run Name", "Environment Name", "Team Name", "Component Name");
    }

    // To be called right before the start of your test (e.g. before method)
    @BeforeMethod
    public void beforeMethod() {
        anglesReporter.startTest("Suite Name", "Test Name");
    }

    /**
     * To report your test results you can call the following methods.
     */
    @Test
    public void testExample() {
        // store a screenshot with Angles (you can also add platform details)
        ScreenshotDetails details = new ScreenshotDetails();
        details.setView("my_example_view");
        List<String> tags = new ArrayList<String>();
        tags.add("my-screenshot-tag");
        details.setTags(tags);
        details.setPath("/location/file.png");
        Screenshot screenshot = anglesReporter.storeScreenshot(details);
        anglesReporter.info("Took screenshot", screenshot.getId());
        
        // individual entries
        anglesReporter.info("Test Info");
        anglesReporter.error("Error Info");
        anglesReporter.pass("Step Details", "expected", "actual", "Information e.g. to reproduce");
        anglesReporter.fail("Step Details", "expected", "actual", "Information e.g. to reproduce");
    }
    
    // To be called when your individual test is finished.
    @AfterMethod
    public void afterMethod() {
        anglesReporter.saveTest();
    }
}

```