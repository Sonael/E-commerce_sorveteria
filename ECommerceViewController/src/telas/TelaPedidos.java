/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaPedidos extends Application{
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent rood = loader.load(getClass().getClassLoader().getResourceAsStream("view/pedidos.fxml"));
        //Parent rood = FXMLLoader.load(getClass().getResource("/view/pedidos.fxml"));
        Scene scene = new Scene(rood);
        stage.setTitle("Pedidos");
        stage.setScene(scene);
        stage.show();
        setStage(stage); //recebido na variavel stage, muito util para fechar uma jaenela enquanto abre outra
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaPedidos.stage = stage;
    }
}
