package javafx_17.control.view;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private ListView<String> listView;
    @FXML private TableView<Phone> tableView;
    @FXML private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(FXCollections.observableArrayList(
                "갤럭시S1", "갤럭시S2","갤럭시S3","갤럭시S4","갤럭시S5","갤럭시S6","갤럭시S7"
        ));
        // selectedIndex 속성 감시
        listView.getSelectionModel().selectedIndexProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                    // 선택한 값을 선택되도록 하고, 화면도 선택한 칸에 가도록 한다.
                    tableView.getSelectionModel().select(newValue.intValue());
                    tableView.scrollTo(newValue.intValue());
                }
            }
        );

        ObservableList phoneList = FXCollections.observableArrayList(
                new Phone("갤럭시S1", "phone01.png"),
                new Phone("갤럭시S2", "phone02.png"),
                new Phone("갤럭시S3", "phone03.png"),
                new Phone("갤럭시S4", "phone04.png"),
                new Phone("갤럭시S5", "phone05.png"),
                new Phone("갤럭시S6", "phone06.png"),
                new Phone("갤럭시S7", "phone07.png")
        );

        TableColumn tcSmartPhone = tableView.getColumns().get(0);
        tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
        tcSmartPhone.setStyle("-fx-alignment:CENTER;");

        TableColumn tcImage = tableView.getColumns().get(1);
        tcImage.setCellValueFactory(new PropertyValueFactory("image"));
        tcImage.setStyle("-fx-alignment:CENTER;");

        tableView.setItems(phoneList);

        tableView.getSelectionModel().selectedItemProperty().addListener(
            ((observableValue, oldValue, newValue) -> {
                if(newValue != null) {
                    imageView.setImage(new Image(getClass().getResource("images/" + newValue.getImage()).toString()));
                }
            })
        );
    }

    public void handleButtonOkAction(ActionEvent e) {
        String item = listView.getSelectionModel().getSelectedItem();
        System.out.println("ListView 스마트폰 : " + item);

        Phone phone = tableView.getSelectionModel().getSelectedItem();
        System.out.println("TableView 스마트폰 : " + phone.getSmartPhone());
        System.out.println("TableView 이미지 : " + phone.getImage());
    }

    public void handleButtonCancelAction(ActionEvent e) {
        Platform.exit();;
    }
}
