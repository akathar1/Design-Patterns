/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.util;

/**
 *
 * @author abhi2
 */
public class Logger {
    



	public static enum DebugLevel {
		CONSTRUCTOR, RUN, ENTRY
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 2:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 1:
			debugLevel = DebugLevel.RUN;
			break;
		case 0:
			debugLevel = DebugLevel.ENTRY;
			break;
		}
	}

	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}
       

        @Override
	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}


