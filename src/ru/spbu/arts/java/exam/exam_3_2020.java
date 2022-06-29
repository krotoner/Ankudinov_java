package ru.spbu.arts.java.exam;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class exam_3_2020 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private FileChooser fileChooser = new FileChooser();

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageChooser chooser = new ImageChooser();
        chooser.setAvailableFormats("*.pda"); // Указываем форматы для FileChooser.
        Label placeHolder = new Label("Image not selected"); // Если изображение не выбрано, тогда показываем данный компонент.
        BorderPane root = new BorderPane(); // Корневой контейнер, в него помещаются кнопка для выбора и само изображение.
        root.setCenter(placeHolder); // Так как изображение не выбрано отображаем текст 'Изображение не выбрано'
        ImageView imageView = new ImageView(); // Данный компонент показывает выбранное изображение.
        Button button = new Button("Select an image"); // Кнопка для выбора изображения.
        BorderPane.setAlignment(button, Pos.CENTER); // Выравнивание кнопки по середине.
        root.setTop(button); // Добавление кнопки в контейнер.
        button.setOnAction((event) -> { // Обработчик событий для нажатия кнопки.
            Image image = chooser.openImage(); // Выбираем изображение.
            if (image != null) {
                imageView.setImage(image); // Установка изображения.
                imageView.setFitWidth(100.0); // Установка ширины в 100.0.
                imageView.setFitHeight(100.0); // Установка высоты в 100.0.
                root.setCenter(imageView); // Добавление изображения в контейнер.
            }
            else
                root.setCenter(placeHolder); // Если изображение не выбрано, тогда показываем 'Изображение не выбрано'
            File fileToSave = fileChooser.showSaveDialog(null);
            if (fileToSave != null) {
                System.out.println("file" + fileToSave);
                assert image != null;
                BufferedImage picture = SwingFXUtils.fromFXImage(image, null);
                try {
                    ImageIO.write(picture, "jpg", new File(fileToSave.getPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Scene scene = new Scene(root, 640.0, 480.0); // Создание сцены.
        primaryStage.setScene(scene); // Установка сцены.
        primaryStage.setTitle("ImageChooser");
        primaryStage.show(); // Показываем окно.

    }
}


