package edu.uc.cs3003.medava;

public abstract class Medicine implements Shippable {
    private String mMedicineName;

    //minimum and maximum acceptable temp - default
    public double minimumTemperature() {
        return 0.0;
    }
    public double maximumTemperature() {
        return 100.0;
    }

    //constructor
    public Medicine(String medicineName) {
        mMedicineName = medicineName;
    }

    //getter
    public String getMedicineName() {
        return mMedicineName;
    }

    //temp checker
    public boolean isTemperatureRangeAcceptable(Double lowTemperature, Double highTemperature) {
        if (this.minimumTemperature() <= lowTemperature &&
                highTemperature <= this.maximumTemperature()) {
            return true;
        }
        return false;
    }

    public abstract MedicineSchedule getSchedule();



}