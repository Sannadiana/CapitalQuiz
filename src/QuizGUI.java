import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class constructs the layout of the GUI while handles the user input and exception handling
 */

public class QuizGUI extends Application  {
    private int count = 0;
    private Label countLable;
    private Button myButton;

    private Label qns = new Label("What is name of the capital in ");
    private Label coment = new Label("Thanks for participating your score is ");

    private Label country;

    private Image image;
    private ImageView imageView;
    private QuizController quiz = new QuizController();


    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String text = "/"+(quiz.getAll().size()+1);
        countLable = new Label(count + text);
        country = new Label("Brasil");
        myButton = new Button("Answer");
        myButton.setDefaultButton(true);

        TextField userText = new TextField();
        image = new Image("brasil.jpg");
        imageView = new ImageView(image);

        imageView.setFitHeight(300);
        imageView.setFitWidth(400);

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setMinSize(600,500);
        pane.setVgap(10);
        pane.setHgap(10);

        pane.add(myButton,1,10);
        pane.add(countLable,0,11);
        pane.add(userText, 0,10);
        pane.add(qns, 0,1);
        pane.add(country,0,7);
        pane.add(imageView, 0,2);


        Scene scene = new Scene(pane,600,500);
        primaryStage.setTitle("QuizApp");
        primaryStage.setScene(scene);


        myButton.setOnAction((event) -> {

            if(userText.getText().toLowerCase().equals(quiz.getCurrentQns().getCapital().toLowerCase())){
                count++;
                countLable.setText(Integer.toString(count) + text);
            }

            try{
                quiz.getNextQns();
                Image img = new Image(quiz.getCurrentQns().getPhotoPath());
                imageView.setImage(img);
                country.setText(quiz.getCurrentQns().getCountry());
                userText.clear();
            }
            catch(Exception e){
                // Avsluttning scene
                GridPane pane2 = new GridPane();
                pane2.setPadding(new Insets(10,10,10,10));
                pane2.setMinSize(600,500);

                Image image2 = new Image("thank-you.jpg");
                imageView = new ImageView(image2);

                pane2.add(coment, 0,11);
                pane2.add(countLable,1,11);
                pane2.add(imageView, 0,2);

                Scene scene2 = new Scene(pane2,600,500);
                primaryStage.setTitle("Takk for deltakelsen");

                primaryStage.setScene(scene2);
            }

        });



        primaryStage.show();

    }



}

