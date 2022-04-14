package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Messenger extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Group root = new Group();       // �������� ����
        Scene scene = new Scene(root);  // �������� Scene
        stage.setScene(scene);          // ��������� Scene ��� Stage


        stage.setTitle("������.ru");
        stage.setWidth(1080);
        stage.setHeight(720);

        Parent main_window =  main_window();
        stage.setScene(new Scene(main_window));

        stage.show();
    }

    private Parent main_window(){
        Parent contacts =  contacts();
        Parent sending_message = sending_message();
        Parent viewing_message = viewing_message();
        VBox mini_window = new VBox(viewing_message,sending_message);
        HBox window =  new HBox(mini_window,contacts);
        return window;
    }

    private Parent contacts() {
        Label label = new Label("��������");
        Button contact_1 = new Button("������� ����");
        Button contact_2 = new Button("������� ����");
        Button contact_3 = new Button("����� ����");
        Button contact_4 = new Button("������ ������");
        Button contact_5 = new Button("�������� ������");
        Button contact_6 = new Button("����������� ����");
        VBox contacts = new VBox(label,contact_1,contact_2,contact_3,contact_4,contact_5,contact_6);
        contacts.setAlignment(Pos.TOP_LEFT);
        contacts.setSpacing(10);
        return contacts;
    }

    private Parent sending_message(){
        Label label = new Label("������� ���� ���������");
        TextArea message = new TextArea();
        Button sending = new Button("���������");
        VBox new_massage = new VBox(label,message);
        HBox sending_message = new HBox(new_massage, sending);
        return sending_message;
    }

    private Parent viewing_message(){
        Label label = new Label("������ ����");
        return label;
    }

}