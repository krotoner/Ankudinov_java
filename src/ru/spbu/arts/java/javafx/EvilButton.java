package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EvilButton extends Application {

    String[] answers = new String[]{"Не думаю что стоит нажимать эту кнопку",
            "Пожалуйста, не нажимайте больше эту кнопку это опасно",
            "Не будь дураком не нажимай на нёё",
            "Прошу отановись и не нажимай",
            "Я предупреждал что не стоит нажимать"};
    int count;

    Button button = new Button("");

    Image image = new Image("C:\\Users\\krot\\IdeaProjects\\Java\\src\\other\\aa6fbcb1955f8215ffa11a5ba8dad545.jpg");
    ImageView picture = new ImageView(image);

    @Override
    public void start(Stage stage) throws Exception {

        VBox root = initInterface();
        stage.setScene(new Scene(root));

        stage.setTitle("Кнопка");
        stage.show();

        button.addEventHandler(ActionEvent.ACTION, event -> {
            if (count < 4) {
                count ++;
                button.setText(answers[count]);
            } else {
                picture.setVisible(true);
                button.setVisible(false);
            }
        });
    }

    private VBox initInterface() {
        count = 0;

        button.setText(answers[count]);

        picture.setFitHeight(300);
        picture.setFitWidth(300);
        picture.setVisible(false);

        VBox root = new VBox(button, picture);
        root.setAlignment(Pos.CENTER);

        return root;
    }
}
