package com.example.user.myapplication;

import junit.framework.Test;
import junit.framework.TestSuite;

public class FullTestSuite extends TestSuite {
    public  static Test suite () {
        return new TestSuiteBuilder(FullTestSuite.class)
                .includeAllPackagesUngerHere().build();
    }

    public FullTestSuite(){
        super();
    }
}
