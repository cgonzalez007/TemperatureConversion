package temperatureconversion;

import java.text.DecimalFormat;

/**
 *
 * @author Chris Gonzalez
 */
public class FahrenheitToCelsiusConverter implements TemperatureConverterStrategy{
    
    @Override
    public final double getConvertedTemperature(double temperatureToConvert) {
        double convertedTemperature = (temperatureToConvert - 32) / 1.8;
        DecimalFormat df = new DecimalFormat("##.0");
        return Double.parseDouble(df.format(convertedTemperature));
    }
    
}
