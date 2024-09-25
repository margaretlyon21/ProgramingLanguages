package edu.uc.cs3003.medava;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Transporter {
    //instance initializer
    {
        goods = new ArrayList<Shippable>();
    }

    //medicine transporter
    private String mTransporterName;
    public String getTransporterName() {
        return mTransporterName;
    }

    //instantiate temp limits
    private double mLowTemperature, mHighTemperature;

    //constructor
    public Transporter(String transporterName, double lowTemp, double highTemp) {
        mTransporterName = transporterName;
        mLowTemperature = lowTemp;
        mHighTemperature = highTemp;
    }

    //list of things it will transport
    private List<Shippable> goods;

    //loader function
//    public boolean load(Object itemToLoad) {
//        try {
//            Method isTemperatureRangeAcceptableMethod = itemToLoad.getClass().getMethod("isTemperatureRangeAcceptable",
//                    Double.class, Double.class);
//            boolean resultOfMethodCall = (boolean) isTemperatureRangeAcceptableMethod.invoke(itemToLoad,
//                    Double.valueOf(mLowTemperature), Double.valueOf(mHighTemperature));
//            if (resultOfMethodCall) {
//                goods.add(itemToLoad);
//            }
//            return resultOfMethodCall;
//        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
//                 | InvocationTargetException e) {
//            return false;
//        }
//    }

    //unload function
    //public Object unload() {
        //return goods.remove(0);
    //}

    //Check if empty transporter function
    public boolean isEmpty() {
        return goods.isEmpty();
    }

    //unload and load pt 2
    public Shippable unload() {
        return goods.remove(0);
    }

    public boolean load(Shippable itemToLoad) {
        if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
            return goods.add(itemToLoad);
        }
        return false;
    }

    //function to ship goods
    public void ship() {
        // Do some shipping!
    }
}