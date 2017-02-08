/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericDeser.util;

/**
 *
 * @author abhi2
 */
public class Second {

    private int IntValue;
    private double DoubleValue;
    private boolean BooleanValue;

    public Second() {
        genericDeser.util.Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                genericDeser.util.Logger.DebugLevel.CONSTRUCTOR);
        this.IntValue = 0;
        this.DoubleValue = 0;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.IntValue;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.DoubleValue) ^ (Double.doubleToLongBits(this.DoubleValue) >>> 32));
        hash = 97 * hash + (this.BooleanValue ? 1 : 0);
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
        final Second other = (Second) obj;
        if (this.IntValue != other.IntValue) {
            return false;
        }
        if (Double.doubleToLongBits(this.DoubleValue) != Double.doubleToLongBits(other.DoubleValue)) {
            return false;
        }
        if (this.BooleanValue != other.BooleanValue) {
            return false;
        }
        return true;
    }

    public int getIntValue() {
        return IntValue;
    }

    public void setIntValue(int IntValue) {
        this.IntValue = IntValue;
    }

    public double getDoubleValue() {
        return DoubleValue;
    }

    public void setDoubleValue(double DoubleValue) {
        this.DoubleValue = DoubleValue;
    }

    public boolean isBooleanValue() {
        return BooleanValue;
    }

    public void setBooleanValue(boolean BooleanValue) {
        this.BooleanValue = BooleanValue;
    }

    @Override
    public String toString() {
        return "Second{" + "IntValue=" + IntValue + ", DoubleValue=" + DoubleValue + ", BooleanValue=" + BooleanValue + '}';
    }

}
