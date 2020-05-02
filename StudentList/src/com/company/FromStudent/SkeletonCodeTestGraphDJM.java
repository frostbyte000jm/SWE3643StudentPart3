package com.company.FromStudent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class SkeletonCodeTestGraphDJM {
    SkeletonCode skeletonCode;
    File file;

    public void basicSetUp(String fn) throws Exception {
        //I already created this, so I just used it again to move the correct test files to the correct location.
        //Cleanup
        if(new File("C:\\Temp\\"+fn).exists())
            new File("C:\\Temp\\"+fn).delete();

        //Move test file from repo to Temp
        Path source = Paths.get("repo/"+fn);
        Path dest = Paths.get("C:\\Temp\\"+fn);
        Files.copy(source, dest);

        //Set Test file
        file = new File("C:\\Temp\\"+fn);
    }

    @BeforeEach
    void setUp() {
        skeletonCode = new SkeletonCode();
    }

    @Test
    void openFile01() {
        assertFalse(skeletonCode.openFile(new File("bob.fake")));
    }

    @Test
    void openFile02() throws Exception {
        /*
        This covers the following paths
        [1,2,3,5],[1,2,3,4],[1,2,3,4,6],[1,2,3,4,6,7,8],[1,2,3,4,6,7,9],[1,2,3,4,6,7,10],
        [1,2,3,4,6,7,11],[1,2,3,4,6,7,12]

        This also covers:
        [1,2,13,15,18],[1,2,13,15,17,18],[1,2,13,14,16,15,18],[1,2,13,14,16,15,17,18]
         */
        basicSetUp("Events.csv");
        assertTrue(skeletonCode.openFile(file));
    }
}