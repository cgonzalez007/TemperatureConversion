package temperatureconversion;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * This is the graphical user interface for this program
 *
 * @author Chris Gonzalez Version 1.0 11/08/2016
 */
public class MainWindowTesting extends JFrame implements ActionListener{
    private Container c;
    private JButton btnConvertTemperature;
    private ButtonGroup buttonGroup1;
    private JLabel lblInstruction;
    private JLabel lblConvertedTemperature;
    private JLabel lblDegreeSymbol;
    private JPanel jPanel1;
    private JRadioButton rbCelsiusToFahrenheit;
    private JRadioButton rbFahrenheitToCelsius;
    private JTextField txtTemperatureToBeConverted;
    
    /**
     * Creates new form MainWindow
     */
    public MainWindowTesting() {
        c = this.getContentPane();
        //Create components of window 
        lblInstruction = new JLabel("Temperature value to be converted:");
        lblInstruction.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblConvertedTemperature = new JLabel(" ");
        txtTemperatureToBeConverted = new JTextField(6);
        btnConvertTemperature = new JButton("Convert");
        btnConvertTemperature.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnConvertTemperature.addActionListener(this);
        rbCelsiusToFahrenheit = new JRadioButton("Celsius to Fahrenheit");
        rbFahrenheitToCelsius = new JRadioButton("Fahrenheit to Celsius");
        rbFahrenheitToCelsius.setSelected(true);
        //Create ButtonGroup and add two radio buttons into that group
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rbCelsiusToFahrenheit);
        buttonGroup1.add(rbFahrenheitToCelsius);
        jPanel1 = new JPanel();
        jPanel1.add(rbFahrenheitToCelsius);
        jPanel1.add(rbCelsiusToFahrenheit);
        jPanel1.setBorder(BorderFactory.createTitledBorder("Choose Conversion"));
        c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
        c.add(lblInstruction);
        c.add(txtTemperatureToBeConverted);
        c.add(btnConvertTemperature);
        c.add(jPanel1);
        c.add(lblConvertedTemperature);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //set to able to close when clicked on x
        setTitle("Temperature Converter"); //set title of window
        setResizable(false); // makes it so user cannot resize window
        this.setBounds(50,50,300,200); //set dimensions
        this.pack(); //remove any wasted space
        this.setVisible(true);
    }

    @Override
    public final void actionPerformed(ActionEvent e) {
        try{
            TemperatureConverterStrategy fahrenheitToCelsius = 
                new FahrenheitToCelsiusConverter();
            TemperatureConverterStrategy celsiusToFahrenheit = 
                new CelsiusToFahrenheitConverter();
            TemperatureConversionManager temperatureConversion = 
                new TemperatureConversionManager();
            if(rbCelsiusToFahrenheit.isSelected()){    
                lblConvertedTemperature.setText(temperatureConversion
                        .getConvertedTemperature(Double
                        .parseDouble(txtTemperatureToBeConverted
                        .getText()),celsiusToFahrenheit));
            }
            if(rbFahrenheitToCelsius.isSelected()){
                lblConvertedTemperature.setText(temperatureConversion
                        .getConvertedTemperature(Double
                        .parseDouble(txtTemperatureToBeConverted
                        .getText()),fahrenheitToCelsius));
            }
        }catch(NumberFormatException nf){
            JOptionPane.showMessageDialog(rootPane, "Please enter a valid value");
        }catch(IllegalArgumentException ia){
            JOptionPane.showMessageDialog(rootPane, ia.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new MainWindowTesting();
    }


}
