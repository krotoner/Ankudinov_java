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
        chooser.setAvailableFormats("*.png", "*.gif", "*.jpg", "*.jpeg"); // Указываем форматы для FileChooser.
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
        });
        Scene scene = new Scene(root, 640.0, 480.0); // Создание сцены.
        primaryStage.setScene(scene); // Установка сцены.
        primaryStage.setTitle("ImageChooser");
        primaryStage.show(); // Показываем окно.
    }
}

// Класс для выбора изображения.
class ImageChooser {
    private final FileChooser chooser;
    private final List<ExtensionFilter> filters; // Фильтры файлов по их расширениям.
    public ImageChooser() {
        chooser = new FileChooser();
        filters = chooser.getExtensionFilters();
    }

    // Метод для выбора изображения.
    public Image openImage() {
        File file = chooser.showOpenDialog(null); // Открываем файл.
        if (file != null) {
            URI uri = file.toURI(); // Преобразуем файл в URI.
            return new Image(uri.toString());
        }
        return null; // Если изображение не выбрано, тогда возвращаем null.
    }

    // Метод для утановки форматов.
    public void setAvailableFormats(String ... formats) {
        filters.clear(); // Удаляем все прошлые форматы.
        if (formats != null && formats.length > 0) { // Если есть что добавить.
            ExtensionFilter filter =
                    new ExtensionFilter(String.join(", ", formats), formats);
            filters.add(filter);
        }
    }
}


