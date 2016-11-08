package temperatureconversion;

/**
 *
 * @author Chris Gonzalez 
 */
public class TemperatureConversionManager {
    public final double getConvertedTemperature(double temperatureToConvert, 
            TemperatureConverterStrategy temperatureConverter){
        return temperatureConverter
                .getConvertedTemperature(temperatureToConvert);
    }
}
