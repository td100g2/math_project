
package accountant_2;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

/**
 *
 * @author georgi
 */
public class Controller {
    
    @FXML
    private RadioButton planOneYear;
    @FXML
    private RadioButton planSixMonths;
    @FXML
    private RadioButton planOneMonth;
    @FXML
    private TextField txLihva;
    @FXML
    private TextField txVnoska;
    @FXML
    private TextField txResult;
    @FXML
    private DatePicker txNachalnaData;
    @FXML
    private DatePicker txKraynaData;
    @FXML
    private Button btCalculate;
    
    int timePlan = 0;
    
    @FXML
    public void calculateButtonClicked() {
        txResult.setText(getResult() + " лв.");
    }
    
    @FXML
    public void planOneYearClicked() {
        timePlan = 0;
    }
    
    @FXML
    public void sixMonthsClicked() {
        timePlan = 1;
    }
    
    @FXML
    public void planOneMonthClicked() {
        timePlan = 2;
    }
    
    public int getNumberOfMonths() {
        
	LocalDate inDate = txNachalnaData.getValue();
	LocalDate fnDate = txKraynaData.getValue();
		
	Period diff = Period.between(inDate, fnDate);
	int years = diff.getYears();
	int months = diff.getMonths();
        int result = 0;
		
	if(fnDate.getDayOfMonth() >= inDate.getDayOfMonth()) {
		result = years * 12 + months;
	} else {
		result = years * 12 + months - 1;
	}
        
        return result;
    }
    
    public String getResult() {
	double k = Double.parseDouble(txVnoska.getText());
	double p = 0;
	double n = 0;
	double result = 0;
        DecimalFormat df = new DecimalFormat("#.##");
		
	switch (timePlan) {
	case 0:
            p = Double.parseDouble(txLihva.getText());
            n = getNumberOfMonths();
            break;
	case 1:
            p = Double.parseDouble(txLihva.getText()) / 2;
            n = getNumberOfMonths() * 2;
            break;
	case 2:
            p = Double.parseDouble(txLihva.getText()) / 4;
            n = getNumberOfMonths() * 4;
            break;
	default:
		break;
	}

	if(timePlan == 0 && n >= 12) {
            result = k * Math.pow((1+(p/100)), (n / 12));
	} else if(timePlan == 1 && n >= 6) {
            result = k * Math.pow((1+(p/100)), (n / 12));
	} else if(timePlan == 2 && n >= 1) {
            result = k * Math.pow((1+(p/100)), (n / 12));
	} else { result = k; }
		
	return df.format(result);
	}
    
}
