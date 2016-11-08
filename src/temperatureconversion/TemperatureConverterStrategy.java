package temperatureconversion;

/**
 *
 * @author Chris Gonzalez
 */
public interface TemperatureConverterStrategy {

    public abstract double getConvertedTemperature(double temperatureToConvert);
}
