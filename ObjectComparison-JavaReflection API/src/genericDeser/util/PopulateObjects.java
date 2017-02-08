package genericDeser.util;

import genericDeser.fileOperations.FileProcessorI;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abhi2
 */
public class PopulateObjects implements PopulateObjectsI {

    private FileProcessorI fp = null;
    private String line = null;
    private String className = null;
    private String[] splitForClass;
    private int flag;
    private int noOfLines;
    List<Object> collectObjects = null;
    Map<Object, Integer> collectFirst = null;
    Map<Object, Integer> collectSecond = null;
    Map<String, Class<?>> typeMap = null;

    public PopulateObjects(FileProcessorI fpIn) {
        genericDeser.util.Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                genericDeser.util.Logger.DebugLevel.CONSTRUCTOR);
        fp = fpIn;
        noOfLines = 0;
        collectFirst = new HashMap<>();
        collectSecond = new HashMap<>();
        collectObjects = new ArrayList<>();

        typeMap = new HashMap<>();
        typeMap.put("int", Integer.TYPE);
        typeMap.put("String", String.class);
        typeMap.put("double", Double.TYPE);
        typeMap.put("boolean", Boolean.TYPE);
        typeMap.put("float", Float.TYPE);
        typeMap.put("short", Short.TYPE);

    }

    /**
     * read the input file line by line and creates objects of the respective
     * class and calls the corresponding method to set the parsed values
     */
    @Override
    public void deserObjects() {
        Class<?> cls = null;
        Object obj = null;
        Class<?>[] signature = new Class<?>[1];
        while ((line = fp.readByLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            noOfLines++;
            if (line.contains("fqn")) {

                splitForClass = line.split(":");
                className = splitForClass[1];
                className = className.trim();

                try {
                    cls = Class.forName(className);
                } catch (ClassNotFoundException ex) {
                    System.err.println("CLASS NOT FOUND EXCEPTION");
                    System.exit(1);
                }
                try {
                    obj = cls.newInstance();
                } catch (InstantiationException ex) {
                    System.err.println("InstantiationException : " + ex.getMessage());
                    System.exit(1);
                } catch (IllegalAccessException ex) {
                    System.err.println("Illegal access: " + ex.getMessage());
                    System.exit(1);
                }
                genericDeser.util.Logger.writeMessage("\n Object added to List of general objects",
                        genericDeser.util.Logger.DebugLevel.ENTRY);
                collectObjects.add(obj);
                continue;

            }
            String[] a = new String[3];
            a = getMemberDetails(line, a);
            String type = a[0];
            String var = a[1];
            String value = a[2];
            String methodName = "set" + var;

            Method meth = null;
            signature[0] = getSignatureName(a[0]);
            try {
                meth = cls.getMethod(methodName, signature);
            } catch (NoSuchMethodException e) {
                System.err.println("No such method: " + e.getMessage());
                System.exit(1);
            } catch (SecurityException e) {
                System.err.println("SecurityException: " + e.getMessage());
                System.exit(1);
            }

            Object[] params = new Object[1];
            params[0] = getParameters(methodName, value);
            try {
                Object result = meth.invoke(obj, params);
            } catch (IllegalAccessException e) {
                System.err.println("Illegal access: " + e.getMessage());
                System.exit(1);
            } catch (IllegalArgumentException e) {
                System.err.println("Illegal argument passed: " + e.getMessage());
                System.exit(1);
            } catch (InvocationTargetException e) {
                System.err.println("Invocation target exception: " + e.getMessage());
                System.err.println("Exception: " + e.getTargetException().getMessage());
                System.exit(1);
            }

        }
        storeObjects();

    }

    /**
     * to parse the read line to find type ,variable name and value
     *
     * @param line
     * @param a
     * @return array of strings
     */
    private String[] getMemberDetails(String line, String[] a) {

        Pattern p = Pattern.compile("(type|var|value)=([^,]*)");
        Matcher m = p.matcher(line);
        int i = 0;
        while (m.find()) {
            a[i] = m.group(2);
            i++;
        }
        return a;
    }

    /**
     *
     * @param type
     * @return the type class of the given type
     */
    private Class<?> getSignatureName(String type) {

        return typeMap.get(type);

    }

    /**
     * create parameter values of specific types
     *
     * @param methodName
     * @param value
     * @return object with given value
     */
    private Object getParameters(String methodName, String value) {
        Object newObj = null;

        if (methodName.contains("String")) {
            newObj = value;
        } else if (methodName.contains("Float")) {
            newObj = Float.parseFloat(value);
        } else if (methodName.contains("Short")) {
            newObj = new Short(value);
        } else if (methodName.contains("Int")) {
            newObj = new Integer(value);
        } else if (methodName.contains("Double")) {
            newObj = new Double(value);
        } else if (methodName.contains("Boolean")) {
            newObj = Boolean.valueOf(value);
        }

        return newObj;
    }

    /**
     * store objects into the data structure of respective class
     */
    private void storeObjects() {

        collectObjects.stream().forEach((temp) -> {
            if (temp instanceof First) {
                addFirstObj(temp);
            } else {
                addSecondObj(temp);
            }
        });

    }

    /**
     * keep track of First objects
     *
     * @param obj
     */
    private void addFirstObj(Object obj) {
        genericDeser.util.Logger.writeMessage("\n Object added to Map of Class First objects",
                genericDeser.util.Logger.DebugLevel.ENTRY);
        if (collectFirst.containsKey(obj)) {
            collectFirst.put(obj, collectFirst.get(obj) + 1);
        } else {
            collectFirst.put(obj, 1);
        }
    }

    /**
     * keep track of second objects
     *
     * @param obj
     */
    private void addSecondObj(Object obj) {
        genericDeser.util.Logger.writeMessage("\n Object added to Map of Class Second objects",
                genericDeser.util.Logger.DebugLevel.ENTRY);
        if (collectSecond.containsKey(obj)) {
            collectSecond.put(obj, collectSecond.get(obj) + 1);
        } else {
            collectSecond.put(obj, 1);
        }
    }

    /**
     * print the obtained results
     */
    @Override
    public void printDetails() {
        if (noOfLines == 0) {
            System.out.println("File is Empty");
        }
        genericDeser.util.Logger.writeMessage("\n Number of unique First objects : " + getUniqueFirst(),
                genericDeser.util.Logger.DebugLevel.RESULT);
        genericDeser.util.Logger.writeMessage("\n Total Number of First objects : " + getTotalFirst(),
                genericDeser.util.Logger.DebugLevel.RESULT);
        genericDeser.util.Logger.writeMessage("\n Number of unique Second objects : " + getUniqueSecond(),
                genericDeser.util.Logger.DebugLevel.RESULT);
        genericDeser.util.Logger.writeMessage("\n Total Number of Second objects : " + getTotalSecond(),
                genericDeser.util.Logger.DebugLevel.RESULT);

    }

    /**
     * get total number of FIRST objects
     *
     * @return
     */
    @Override
    public int getTotalFirst() {
        int totalFirst = 0;
        for (Map.Entry<Object, Integer> entry : collectFirst.entrySet()) {

            totalFirst = totalFirst + entry.getValue();
        }
        return totalFirst;
    }

    /**
     * get total number of SECOND objects
     *
     * @return
     */
    @Override
    public int getTotalSecond() {
        int totalSecond = 0;
        for (Map.Entry<Object, Integer> entry : collectSecond.entrySet()) {

            totalSecond = totalSecond + entry.getValue();
        }
        return totalSecond;
    }

    /**
     * get unique first objects
     *
     * @return int (number of unique objects)
     */
    @Override
    public int getUniqueFirst() {
        return collectFirst.size();
    }

    /**
     * get unique second objects
     *
     * @return int (number of unique objects)
     */
    @Override
    public int getUniqueSecond() {
        return collectSecond.size();
    }
}
