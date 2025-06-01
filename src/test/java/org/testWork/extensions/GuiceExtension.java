package org.testWork.extensions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import di.TestModule;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class GuiceExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Object testInstance = context.getRequiredTestInstance();
        Injector injector = Guice.createInjector(new TestModule());
        injector.injectMembers(testInstance);
    }
}
