package pl.put.poznan.buildingclient.app;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;
import pl.put.poznan.buildingclient.classes.Location;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import pl.put.poznan.buildingclient.classes.Building;
import pl.put.poznan.buildingclient.classes.Floor;
import pl.put.poznan.buildingclient.classes.Room;

public class FXMLController implements Initializable {
    @FXML
    TreeView treeview;
    
    @FXML
    Button button;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    String uri = "http://localhost:8080/buildings";
                    String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
                    //String param1 = "value1";

                    //String query = String.format("param1=%s&param2=%s",
                    //URLEncoder.encode(param1, charset),

                    URLConnection connection = new URL(uri).openConnection();
                    connection.setRequestProperty("Accept-Charset", charset);
                    InputStream response = new URL(uri).openStream();

                    try (Scanner scanner = new Scanner(response)) {
                        String responseBody = scanner.useDelimiter("\\A").next();
                        // json string to object
                        Gson g = new Gson();
                        ArrayList<Building> buildings = g.fromJson(responseBody, new TypeToken<ArrayList<Building>>(){}.getType());
                        //constructing tree
                        Location catRoot = new Location();
                        TreeItem<Location> rootItem = new TreeItem<Location>(catRoot);
                        rootItem.setExpanded(true);
                        treeview.setRoot(rootItem);
                        for (Building b : buildings) {
                            TreeItem<Location> itemb = new TreeItem<Location>(b);
                            for (Floor f : b.getPoziomy()) {
                                TreeItem<Location> itemf = new TreeItem<Location>(f);
                                for (Room r : f.getRooms()) {
                                    TreeItem<Location> itemr = new TreeItem<Location>(r);
                                    itemf.getChildren().addAll(itemr);
                                }
                                itemb.getChildren().addAll(itemf);
                            }
                            rootItem.getChildren().addAll(itemb);
                        }
                        treeview.setShowRoot(false);
                    }
                }       catch (MalformedURLException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        });
        
        treeview.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {
        @Override
        public void changed(ObservableValue observable, Object oldValue,
                Object newValue) {

            TreeItem<Location> selectedItem = (TreeItem<Location>) newValue;
            System.out.println("Selected Item : " + selectedItem.getValue());
            // do what ever you want 
        }

      });
    }
}
