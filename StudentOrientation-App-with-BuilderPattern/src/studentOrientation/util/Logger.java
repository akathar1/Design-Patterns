/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentorientation.util;

/**
 *
 * @author abhi2
 *
 */
public class Logger {

    public static enum DebugLevel {
        CONSTRUCTOR, SETTINGACTIVITYCONTENTS, RESULTDISPLAY
    };

    private static DebugLevel debugLevel;

    public static void setDebugValue(int levelIn) {
        
        switch (levelIn) {
            /*case 4:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 3:
			debugLevel = DebugLevel.RUN;
			break;*/
            case 2:
                debugLevel = DebugLevel.RESULTDISPLAY;
                break;
            case 1:
                debugLevel = DebugLevel.SETTINGACTIVITYCONTENTS;
                break;
            case 0:
                debugLevel = DebugLevel.CONSTRUCTOR;
                break;

        }
    }
    
   

    public static void setDebugValue(DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    public static void writeMessage(String message, DebugLevel levelIn) {
        if (levelIn == debugLevel) {
            System.out.println(message);
        }
    }

    public static void writeResultMessage(String message, DebugLevel levelIn) {
        if (levelIn == debugLevel) {
            System.out.print(message);
        }
    }

    public static DebugLevel getDebugLevel() {
        return debugLevel;
    }

    public static void setDebugLevel(DebugLevel debugLevel) {
        Logger.debugLevel = debugLevel;
    }

    @Override
    public String toString() {
        return "Debug Level is " + debugLevel;
    }
}
