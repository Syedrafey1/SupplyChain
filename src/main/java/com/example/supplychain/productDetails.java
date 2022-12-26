package com.example.supplychain;

//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class productDetails {

    public TableView<product> productTable;

    public Pane getAllProducts(){
        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//        ObservableList<product> data = FXCollections.observableArrayList();
//        data.add(new product(1, "MSI", 54999.9));
//        data.add(new product(1, "HP", 64999.9));

        ObservableList<product> products = product.getAllProducts();


        productTable = new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id, name, price);
        productTable.setMinSize(SupplyChain.width, SupplyChain.height);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Pane tablePane = new Pane();
        tablePane.setStyle("-fx-background-color: #C0C0C0");
        tablePane.setMinSize(SupplyChain.width, SupplyChain.height);
        tablePane.getChildren().addAll(productTable);

        return tablePane;
    }


    public Pane getAllProductsByName(String productName){
        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//        ObservableList<product> data = FXCollections.observableArrayList();
//        data.add(new product(1, "MSI", 54999.9));
//        data.add(new product(1, "HP", 64999.9));

        ObservableList<product> products = product.getProductsByName(productName);


        productTable = new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id, name, price);
        productTable.setMinSize(SupplyChain.width, SupplyChain.height);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Pane tablePane = new Pane();
        tablePane.setStyle("-fx-background-color: #C0C0C0");
        tablePane.setMinSize(SupplyChain.width, SupplyChain.height);
        tablePane.getChildren().addAll(productTable);

        return tablePane;
    }

    public product getSelectedProduct(){
        try {
            product selectedProduct = productTable.getSelectionModel().getSelectedItem();
            return selectedProduct;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
