package ru.spbu.arts.java.fractals;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class FractalViewer extends Application {

    public final int W = 600;
    public final int H = 400;

    private double x = -4;
    private double y = 3;
    private double d = 8 / 600.0;

    private Fractal f = new Mandelbrot();
    private Palette p = new HSBNewPalette();
    private WritableImage img = new WritableImage(W, H);
    private ImageView imgView = new ImageView(img);

    private Button up = new Button("вверх");
    private Button right = new Button("вправо");
    private Button down = new Button ("вниз");
    private Button left = new Button ("влево");

    private Button zoom = new Button("увеличить");
    private Button distance = new Button("уменьшить");
    private Button save = new Button("save position");
    private Button load = new Button("load position");
    private Button export = new Button("сохранить");

    private FileChooser fileChooser = new FileChooser();

    @Override
    public void start (Stage primaryStage) throws Exception {

        primaryStage.setTitle("Фракталы");

        VBox root = initInterface();
        initInteraction();
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    private VBox initInterface() {

        Display display = new Display(x, y, d);
        display.paint(img, f, p);

        GridPane moving = new GridPane();
        moving.add(up, 1, 0);
        moving.add(right, 2, 1);
        moving.add(down, 1, 2);
        moving.add(left, 0, 1);

        HBox mainPanel = new HBox(moving,
                zoom, distance, save, load, export);

        return new VBox(imgView, mainPanel);
    }

    private void initInteraction() {

        up.addEventHandler(ActionEvent.ACTION, event -> {
            y += (H / 10.0) * d;
            paintNewDisplay();
        });

        right.addEventHandler(ActionEvent.ACTION, event -> {
            x += (W / 10.0) * d;
            paintNewDisplay();
        });

        down.addEventHandler(ActionEvent.ACTION, event -> {
            y -= (H / 10.0) * d;
            paintNewDisplay();
        });

        left.addEventHandler(ActionEvent.ACTION, event -> {
            x -= (W / 10.0) * d;
            paintNewDisplay();
        });

        zoom.addEventHandler(ActionEvent.ACTION, event -> {
            double newD = d / 1.5;
            x += 0.5 * W * (d - newD);
            y -= 0.5 * H * (d - newD);
            d = newD;
            paintNewDisplay();
        });

        distance.addEventHandler(ActionEvent.ACTION, event -> {
            double newD = d * 1.5;
            x += 0.5 * W * (d - newD);
            y -= 0.5 * H * (d - newD);
            d = newD;
            paintNewDisplay();
        });

        save.addEventHandler(ActionEvent.ACTION, event -> {
            try { savePosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        load.addEventHandler(ActionEvent.ACTION, event -> {
            try { loadPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        export.addEventHandler(ActionEvent.ACTION, event -> {
            File fileToSave = fileChooser.showSaveDialog(null);
            if (fileToSave != null) {
                System.out.println("Выбран файл" + fileToSave);
                BufferedImage picture = SwingFXUtils.fromFXImage(img, null);
                try {
                    ImageIO.write(picture, "png", new File(fileToSave.getPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void savePosition() throws Exception {
        try (PrintStream outFile = new PrintStream("src/textFiles/lastPosition.txt", StandardCharsets.UTF_8)) {
            outFile.println(x);
            outFile.println(y);
            outFile.println(d);
        }
    }

    private void loadPosition() throws Exception {
        Path pathToFile = Path.of("src/textFiles/lastPosition.txt");
        try (Scanner inFile = new Scanner(pathToFile, StandardCharsets.UTF_8)) {
            x = Double.parseDouble(inFile.next());
            y = Double.parseDouble(inFile.next());
            d = Double.parseDouble(inFile.next());
            paintNewDisplay();
        }
    }

    private void paintNewDisplay() {
        Display newDisplay = new Display(x, y, d);
        newDisplay.paint(img, f, p);
    }
}

