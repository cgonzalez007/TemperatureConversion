package temperatureconversion;

import java.text.DecimalFormat;

/**
 * This is the "worker" class that does the actual conversions. This
 * particular class of type TemperatureConverterStrategy converts 
 * Fahrenheit to Celsius.
 * @author Chris Gonzalez Version 1.0 11/08/2016 
 */
public class FahrenheitToCelsiusConverter implements TemperatureConverterStrategy{
    private static final double MINIMUM_INPUT = -1000000;
    private static final double MAXIMUM_INPUT = 1000000;
    private static final String INVALID_INPUT_MESSAGE = 
            "Error: Please enter an acceptable measure.";
    /**
     * This method overrides from the interface TemperatureConverterStrategy.
     * This method takes a double representing the Fahrenheit temperature
     * measure to convert, and converts it to a measure in Celsius.
     * @author Chris Gonzalez Version 1.0 11/08/2016
     * @param temperatureToConvert temperature measure to be converted
     * @return  converted temperature measure
     * @throws IllegalArgumentException when there is an invalid input
     */
    @Override
    public final double getConvertedTemperature(double temperatureToConvert) 
        throws IllegalArgumentException{
        if(temperatureToConvert < MINIMUM_INPUT || temperatureToConvert > 
                 MAXIMUM_INPUT){
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        double convertedTemperature = (temperatureToConvert - 32) / 1.8;
        DecimalFormat df = new DecimalFormat("##.0");
        return Double.parseDouble(df.format(convertedTemperature));
    }
    
}
