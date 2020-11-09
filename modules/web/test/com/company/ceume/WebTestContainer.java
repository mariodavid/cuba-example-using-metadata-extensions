package com.company.ceume;

import com.haulmont.cuba.web.testsupport.TestContainer;

import java.util.ArrayList;
import java.util.Arrays;

public class WebTestContainer extends TestContainer {

    public WebTestContainer() {
        appComponents = new ArrayList<>(Arrays.asList(
                "com.haulmont.cuba",
                "de.diedavids.cuba.metadataextensions"
        ));
        appPropertiesFiles = Arrays.asList(
                "de/diedavids/cuba/metadataextensions/web-app.properties",
                "com/company/ceume/web-app.properties",
                "com/haulmont/cuba/web/testsupport/test-web-app.properties"
        );
    }

    public static class Common extends WebTestContainer {

        // A common singleton instance of the test container which is initialized once for all tests
        public static final WebTestContainer.Common INSTANCE = new WebTestContainer.Common();

        private static volatile boolean initialized;

        private Common() {
        }

        @Override
        public void before() throws Throwable {
            if (!initialized) {
                super.before();
                initialized = true;
            }
            setupContext();
        }

        @Override
        public void after() {
            cleanupContext();
            // never stops - do not call super
        }
    }
}