package temperatureconversion;

/**
 * This is the High level module that calls the TemperatureConverterStrategy
 * objects to do conversions
 * @author Chris Gonzalez Version 1.0 11/08/2016 
 */
public class TemperatureConversionManager {
    private static final double MINIMUM_INPUT = -1000000;
    private static final double MAXIMUM_INPUT = 1000000;
    private static final String INVALID_INPUT_MESSAGE = 
            "Error: Please enter an acceptable measure.";
    /**
     * This method takes a TemperatureConverterStrategy object as an 
     * argument and a double representing the temperature measure to convert. 
     * It calls the TemperatureConverterStrategy object and calls its 
     * getConvertedTemperature() method.
     * @param temperatureToConvert Temperature measure to convert
     * @param temperatureConverter TemperatureConverterStrategy object
     * @return converted temperature from 
     * @throws IllegalArgumentException when there is an invalid input
     */
    public final String getConvertedTemperature(double temperatureToConvert, 
            TemperatureConverterStrategy temperatureConverter)throws 
            IllegalArgumentException{
        if(temperatureToConvert < MINIMUM_INPUT || temperatureToConvert > 
                 MAXIMUM_INPUT){
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        return temperatureConverter
                .getConvertedTemperature(temperatureToConvert);
    }
}
