package ru.spbu.arts.java.exam;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.io.File;
import java.net.URI;
import java.util.List;

public class exam_2020 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageChooser chooser = new ImageChooser();
        chooser.setAvailableFormats("*.png", "*.gif", "*.jpg", "*.jpeg"); // ��������� ������� ��� FileChooser.
        Label placeHolder = new Label("Image not selected"); // ���� ����������� �� �������, ����� ���������� ������ ���������.
        BorderPane root = new BorderPane(); // �������� ���������, � ���� ���������� ������ ��� ������ � ���� �����������.
        root.setCenter(placeHolder); // ��� ��� ����������� �� ������� ���������� ����� '����������� �� �������'
        ImageView imageView = new ImageView(); // ������ ��������� ���������� ��������� �����������.
        Button button = new Button("Select an image"); // ������ ��� ������ �����������.
        BorderPane.setAlignment(button, Pos.CENTER); // ������������ ������ �� ��������.
        root.setTop(button); // ���������� ������ � ���������.
        button.setOnAction((event) -> { // ���������� ������� ��� ������� ������.
            Image image = chooser.openImage(); // �������� �����������.
            if (image != null) {
                imageView.setImage(image); // ��������� �����������.
                imageView.setFitWidth(100.0); // ��������� ������ � 100.0.
                imageView.setFitHeight(100.0); // ��������� ������ � 100.0.
                root.setCenter(imageView); // ���������� ����������� � ���������.
            }
            else
                root.setCenter(placeHolder); // ���� ����������� �� �������, ����� ���������� '����������� �� �������'
        });
        Scene scene = new Scene(root, 640.0, 480.0); // �������� �����.
        primaryStage.setScene(scene); // ��������� �����.
        primaryStage.setTitle("ImageChooser");
        primaryStage.show(); // ���������� ����.
    }
}

// ����� ��� ������ �����������.
class ImageChooser {
    private final FileChooser chooser;
    private final List<ExtensionFilter> filters; // ������� ������ �� �� �����������.
    public ImageChooser() {
        chooser = new FileChooser();
        filters = chooser.getExtensionFilters();
    }

    // ����� ��� ������ �����������.
    public Image openImage() {
        File file = chooser.showOpenDialog(null); // ��������� ����.
        if (file != null) {
            URI uri = file.toURI(); // ����������� ���� � URI.
            return new Image(uri.toString());
        }
        return null; // ���� ����������� �� �������, ����� ���������� null.
    }

    // ����� ��� �������� ��������.
    public void setAvailableFormats(String ... formats) {
        filters.clear(); // ������� ��� ������� �������.
        if (formats != null && formats.length > 0) { // ���� ���� ��� ��������.
            ExtensionFilter filter =
                    new ExtensionFilter(String.join(", ", formats), formats);
            filters.add(filter);
        }
    }
}


