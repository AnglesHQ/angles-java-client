package angles.listeners.junit;

import angles.basetest.AbstractAnglesTestCase;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static angles.util.AnglesReporterUtils.*;

public class AnglesJUnit5Extension extends AbstractAnglesTestCase implements AfterEachCallback, BeforeEachCallback {

    String suiteName, methodName;
    public AnglesJUnit5Extension() {
        super();
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        if (extensionContext.getExecutionException().isPresent()) {
            getAnglesReporter().fail("Test failed", "", "",
                    extensionContext.getExecutionException().get().getMessage());
        } else {
            getAnglesReporter().pass("Test passed", "", "", "");
        }
        getAnglesReporter().saveTest();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        suiteName = context.getParent().get().getDisplayName();
        methodName = context.getDisplayName();
        getAnglesReporter().startTest(suiteName, methodName);
    }
}