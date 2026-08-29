
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.Date;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class TimeClock extends Application {

    private static int STAGE_WIDTH = 300;
    private static int STAGE_HEIGHT = 300;
    private static int DEFAULT_SIZE = 20;
    private Label currentTime;
    
    private Button smallerButton;
    private Button largerButton;
    
    private double fontSizeFactor = 1;
    
    @Override
    public void start(Stage primaryStage) {
          
        currentTime = new Label((new Date()).toString());
        currentTime.setFont(new Font("Times New Roman", DEFAULT_SIZE));
        BorderPane root = new BorderPane();
        root.setCenter(currentTime);
        Scene scene = new Scene(root, STAGE_WIDTH, STAGE_HEIGHT);
        
        smallerButton = new Button("Smaller");
        largerButton = new Button("Larger");
        
        HBox buttons = new HBox();
        buttons.getChildren().addAll(smallerButton, largerButton);
        
        root.setBottom(buttons);
        
        class LargerFontListener implements EventHandler<ActionEvent>
            {
                @Override
                public void handle (ActionEvent event) {
                    fontSizeFactor = 1.25 * fontSizeFactor;
                    currentTime.setFont(new Font("Times New Roman",
                        (int) (DEFAULT_SIZE * fontSizeFactor)));
                }
            }
        
        EventHandler<ActionEvent> largerListener = new LargerFontListener();
        largerButton.setOnAction(largerListener);

        smallerButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                    fontSizeFactor = 0.8 * fontSizeFactor;
                    currentTime.setFont(new Font("Times New Roman",
                        (int) (DEFAULT_SIZE * fontSizeFactor)));
            }
        });

        AnimationTimer clock = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                
                if (now - lastUpdate >= 1_000_000_000L) {
                    currentTime.setText((new Date()).toString());
                    lastUpdate = now;
                }
            }
        };
        clock.start();

        primaryStage.setTitle("Time Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
