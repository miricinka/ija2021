package ija2020;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;

/**
 * Main of application
 * @version 1.0
 * @author <a href="xkolar76@stud.fit.vutbr.cz">Mirka Kolarikova</a>
 * @author <a href="xzovin00@stud.fit.vutbr.cz">Martin Zovinec</a>
 */


public class Main extends Application {

    @FXML
    private AnchorPane textPanel;

    @Override
    public void start(Stage primaryStage) throws Exception{
        YAMLFactory yaml_factory = new YAMLFactory();
        ObjectMapper obj_mapper = new ObjectMapper(yaml_factory);
        WarehouseData warehouseData = obj_mapper.readValue(new File("data/dropspot2.yml"), WarehouseData.class);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("projekt.fxml"));
        BorderPane root = loader.load();
        Controller controller = loader.getController();

        primaryStage.setTitle("Warehouse Simulation");
        primaryStage.setScene(new Scene(root));

        controller.setWarehouseData(warehouseData);
        controller.paintIsles(root);
        controller.paintTrolleys(root);

        Text CanBeSeen = new Text(20, 20, "Načtení skladu ze souboru YAML a zobrazení v GUI\nPo najetí myší na vozík a regál se zobrazí informace o obsahu");
        root.getChildren().add(CanBeSeen);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
