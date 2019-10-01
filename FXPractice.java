import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class FXPractice extends Application {


  public void start(Stage stage){
    Text words = new Text(750, 750, "Shapes and Colors");
    Rectangle box = new Rectangle(1000, 500, 200, 50);
    Circle circle = new Circle(500, 200, 100);
    Ellipse ellipse = new Ellipse(500, 500, 200, 100);

    box.setStroke(Color.BLUE);
    box.setFill(Color.BLUE);
    circle.setStroke(Color.WHITE);
    circle.setFill(Color.WHITE);
    ellipse.setStroke(Color.RED);
    ellipse.setFill(Color.RED);
    words.setFill(Color.GREEN);


    Group root = new Group(box, circle, ellipse, words);
    Scene scene = new Scene(root, 400, 150, Color.LIGHTBLUE);

    stage.setTitle("FXPractice");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args){
    launch(args);
  }
}
