package org.agoenka.xmlhammer;

import org.agoenka.xmlhammer.service.Merger;
import org.agoenka.xmlhammer.service.Splitter;
import org.junit.Test;

/**
 * Authored by agoenka on 8/20/2016.
 */
public class MergerTest {

    @Test
    public void testMerge() throws Exception {
        String fileName = "Company.xml";
        String parentElementName = "Employees";
        Splitter.init("src/test/resources/examples/", "in/", "out/");
        Splitter.split(fileName, parentElementName);
        Merger.init("src/test/resources/examples/", "out/", "in/");
        Merger.merge("Employee", parentElementName, 1, 2);
    }

    @Test
    public void testMergeOutOfBounds() throws Exception {
        Merger.init("src/test/resources/examples/", "out/", "in/");
        Merger.merge("Employee", "Employees", 1, 5);
    }

}
