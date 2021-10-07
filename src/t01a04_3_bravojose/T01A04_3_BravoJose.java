/*
 * En esta ocasion podemos ver el codigo de un dialogo modal. Debe resolverse el dialogo para poder devolver el foco a la ventana que lo creo
 */
package t01a04_3_bravojose;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class T01A04_3_BravoJose extends Application {
    // Lanzador de la aplicacion
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(final Stage primaryStage) {
        // Establecemos el titulo de la ventana principal (no el dialogo)
        primaryStage.setTitle("Dialog");
        // Creamos un grupo que sera el nodo raiz de la escena
        Group root = new Group();
        // Creamos la escena con nodo root el grupo creado, 400 pixeles de ancho, 300 de alto, y color de fondo blanco
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        // Establecemos la escena creada como la escena activa del escenario
        primaryStage.setScene(scene);
        // Mostramos el escenario completo
        primaryStage.show();
        
        // Creamos la variable que referencia a la ventana de dialogo, la cual igual que en el ejercicio anterior, se crea al llamar al constructor de la clase MyDialog
        Stage myDialog = new MyDialog(primaryStage);
        // Ajusta el tamaño de la ventana myDialog al contenido que tendra la propia ventana
        myDialog.sizeToScene();
        // Mostramos el dialogo no modal
        myDialog.show();
  
    }
}

class MyDialog extends Stage {

    public MyDialog(Stage owner) {
        super();
        initOwner(owner);
        setTitle("title");
        initModality(Modality.APPLICATION_MODAL);
        Group root = new Group();
        Scene scene = new Scene(root, 250, 150, Color.WHITE);
        setScene(scene);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        Label userNameLbl = new Label("User Name: ");
        gridpane.add(userNameLbl, 0, 1);

        Label passwordLbl = new Label("Password: ");
        gridpane.add(passwordLbl, 0, 2);
        final TextField userNameFld = new TextField("Admin");
        gridpane.add(userNameFld, 1, 1);

        final PasswordField passwordFld = new PasswordField();
        passwordFld.setText("password");
        gridpane.add(passwordFld, 1, 2);

        Button login = new Button("Change");
        login.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                close();
            }
        });
        gridpane.add(login, 1, 3);
        GridPane.setHalignment(login, HPos.RIGHT);
        root.getChildren().add(gridpane);
    }
}