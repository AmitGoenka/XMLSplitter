package org.agoenka.xmlhammer.util;

import java.io.File;

import static org.agoenka.xmlhammer.util.CommonUtils.isNotEmpty;

/**
 * Authored by agoenka on 8/13/2016.
 */
public interface FileUtils {

    static boolean hasXMLExtension (String name) {
        return name != null && (name.endsWith(".xml") || name.endsWith(".XML"));
    }

    static String lintDirectoryName (String dir) {
        return missingTrailingSlash(dir) ? dir + "/" : dir;
    }

    static boolean missingTrailingSlash (String dir) {
        return dir != null && !dir.trim().equals("") && (!dir.trim().endsWith("/") || !dir.trim().endsWith("\\"));
    }

    static int fileCount(String srcDir, String fileNamePrefix) {
        int count = 0;
        if (isNotEmpty(srcDir)) {
            File dir = new File(srcDir);
            if (dir.exists() && dir.isDirectory()) {
                File[] files = dir.listFiles((d, n) -> n.contains(fileNamePrefix));
                if (files != null) count = files.length;
            }
        }
        return count;
    }

}
