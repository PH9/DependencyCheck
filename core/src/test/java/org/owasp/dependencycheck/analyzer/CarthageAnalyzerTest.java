package org.owasp.dependencycheck.analyzer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.owasp.dependencycheck.BaseTest;
import org.owasp.dependencycheck.analyzer.exception.AnalysisException;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for CartgageAnalyzer.
 *
 * @author Wasith Theerapattrathamrong
 */
public class CarthageAnalyzerTest extends BaseTest {

    /**
     * The analyzer to test.
     */
    private CarthageAnalyzer cartAnalyzer;

    /**
     * Correctly setup the analyzer for testing.
     *
     * @throws Exception thrown if there is a problem
     */
    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        cartAnalyzer = new CarthageAnalyzer();
        cartAnalyzer.initialize(getSettings());
        cartAnalyzer.setFilesMatched(true);
        cartAnalyzer.prepare(null);
    }

    /**
     * Cleanup the analyzer's temp files, etc.
     *
     * @throws Exception thrown if there is a problem
     */
    @After
    @Override
    public void tearDown() throws Exception {
        cartAnalyzer.close();
        cartAnalyzer = null;

        super.tearDown();
    }

    /**
     * Test of getName method, of class SwiftPackageManagerAnalyzer.
     */
    @Test
    public void testSPMGetName() {
        assertThat(cartAnalyzer.getName(), is("Carthage Analyzer"));
    }

    /**
     * Test of supportsFiles method, of class CarthageAnalyzer.
     */
    @Test
    public void testCarthageSupportsFiles() {
        assertThat(cartAnalyzer.accept(new File("Carthage.resolved")), is(true));
    }

    /**
     * Test of analyze method, of class CarthageAnalyzer.
     *
     * @throws AnalysisException is thrown when an exception occurs.
     */
    @Test
    public void testCartfileResolvedAnalyzer() throws AnalysisException {

    }
}