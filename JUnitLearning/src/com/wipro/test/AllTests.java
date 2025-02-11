package com.wipro.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestStringConcat.class,
    TestSort.class,
    TestCheckPresence.class
})
public class AllTests {
    // To remember -> The class remains empty,
    // being used only as a holder for the above annotations
}