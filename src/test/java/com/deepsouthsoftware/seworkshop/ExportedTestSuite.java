package com.deepsouthsoftware.seworkshop;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ExportedTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestFindSpeakerFlow.class);
		suite.addTestSuite(TestFindKioskFlow.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
