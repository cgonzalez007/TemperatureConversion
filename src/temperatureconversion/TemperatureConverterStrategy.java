package temperatureconversion;

/**
 * Abstract representation of what a TemperatureConverterStrategy object
 * should be able to do. 
 * @author Chris Gonzalez Version 1.0 11/08/2016 
 */
public interface TemperatureConverterStrategy {
    /**
     * Abstract method to convert and return temperature measure
     * @param temperatureToConvert Temperature value to be converted
     * @return converted temperature value
     */
    public abstract double getConvertedTemperature(double temperatureToConvert);
}
