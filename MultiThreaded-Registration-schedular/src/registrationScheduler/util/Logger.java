
package util;

/**
 * 
 * @author abhi2
 *
 */
public class Logger {

	public static enum DebugLevel {
		CONSTRUCTOR, RUN, ENTRY, CONTENTS, RESULT
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 4:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 3:
			debugLevel = DebugLevel.RUN;
			break;
		case 2:
			debugLevel = DebugLevel.ENTRY;
			break;
		case 1:
			debugLevel = DebugLevel.CONTENTS;
			break;
		case 0:
			debugLevel = DebugLevel.RESULT;
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
        public static void writeResultMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.print(message);
	}

	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}
