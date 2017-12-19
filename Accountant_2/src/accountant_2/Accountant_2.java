
package accountant_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Accountant_2 extends Application{

    /**
     *
     * @param args
     */
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Accountant_2_Form.fxml"));
        primaryStage.setTitle("Счетоводител 2.0");
        primaryStage.getIcons().add(new Image(Accountant_2.class.getResourceAsStream("accountant.png")));
        primaryStage.setScene(new Scene(root, 580, 400));
        primaryStage.show();
        
    }
    
}
