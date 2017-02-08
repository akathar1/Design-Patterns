/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericDeser.util;

import java.util.Objects;

/**
 *
 * @author abhi2
 */
public class First {

    private int intValue;
    private float FloatValue;
    private short ShortValue;
    private String StringValue;

    public First() {
         genericDeser.util.Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                genericDeser.util.Logger.DebugLevel.CONSTRUCTOR);
        this.intValue = 0;
        this.FloatValue = 0;
        this.ShortValue = 0;
        this.StringValue = null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.intValue;
        hash = 37 * hash + Float.floatToIntBits(this.FloatValue);
        hash = 37 * hash + this.ShortValue;
        hash = 37 * hash + Objects.hashCode(this.StringValue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final First other = (First) obj;
        if (this.intValue != other.intValue) {
            return false;
        }
        if (Float.floatToIntBits(this.FloatValue) != Float.floatToIntBits(other.FloatValue)) {
            return false;
        }
        if (this.ShortValue != other.ShortValue) {
            return false;
        }
        if (!Objects.equals(this.StringValue, other.StringValue)) {
            return false;
        }
        return true;
    }

   
    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public float getFloatValue() {
        return FloatValue;
    }

    public void setFloatValue(float FloatValue) {
        this.FloatValue = FloatValue;
    }

    public short getShortValue() {
        return ShortValue;
    }

    public void setShortValue(short ShortValue) {
        this.ShortValue = ShortValue;
    }

    public String getStringValue() {
        return StringValue;
    }

    public void setStringValue(String StringValue) {
        this.StringValue = StringValue;
    }

    @Override
    public String toString() {
        return "First{" + "intValue=" + intValue + ", FloatValue=" + FloatValue + ", ShortValue=" + ShortValue + ", StringValue=" + StringValue + '}';
    }

}
