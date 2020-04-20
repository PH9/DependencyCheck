package org.owasp.dependencycheck.analyzer;

import org.owasp.dependencycheck.Engine;
import org.owasp.dependencycheck.analyzer.exception.AnalysisException;
import org.owasp.dependencycheck.dependency.Dependency;
import org.owasp.dependencycheck.exception.InitializationException;
import org.owasp.dependencycheck.utils.FileFilterBuilder;

import javax.annotation.concurrent.ThreadSafe;
import java.io.FileFilter;

/**
 * This analyzer is used to analyze SWIFT and Objective-C packages by collecting
 * information from Cartfile.resolved file. Carthage dependency manager see
 * https://github.com/Carthage/Carthage
 *
 * @author Wasith Theerapattrathamrong (https://twitter.com/@ph41)
 */
@Experimental
@ThreadSafe
public class CarthageAnalyzer extends AbstractFileTypeAnalyzer {

    /**
     * A descriptor for the type of dependencies processed or added by this
     * analyzer.
     */
    public static final String DEPENDENCY_ECOSYSTEM = "Carthage";

    /**
     * The file name to scan.
     */
    public static final String CARTHAGE_FILE_NAME = "Cartfile.resolved";

    /**
     * Filter that detects files named "Cartfile.resolved".
     */
    private static final FileFilter CARTHAGE_FILE_FILTER = FileFilterBuilder.newInstance().addFilenames(CARTHAGE_FILE_NAME).build();

    /**
     * The name of the analyzer.
     */
    private static final String ANALYZER_NAME = "Carthage Analyzer";

    /**
     * The phase that this analyzer is intended to run in.
     */
    private static final AnalysisPhase ANALYSIS_PHASE = AnalysisPhase.INFORMATION_COLLECTION;

    @Override
    protected FileFilter getFileFilter() {  return CARTHAGE_FILE_FILTER; }

    @Override
    protected void prepareFileTypeAnalyzer(Engine engine) throws InitializationException {
        // NO-OP
    }

    /**
     * Returns the name of the analyzer.
     *
     * @return the name of the analyzer.
     */
    @Override
    public String getName() {
        return ANALYZER_NAME;
    }

    @Override
    protected void analyzeDependency(Dependency dependency, Engine engine) throws AnalysisException {
        dependency.setEcosystem(DEPENDENCY_ECOSYSTEM);
    }

    @Override
    protected String getAnalyzerEnabledSettingKey() {
        return null;
    }

    /**
     * Returns the phase that the analyzer is intended to run in.
     *
     * @return the phase that the analyzer is intended to run in.
     */
    @Override
    public AnalysisPhase getAnalysisPhase() {
        return ANALYSIS_PHASE;
    }
}