package no.ntnu.idata1001.oblig4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;

public class GUI extends Application {

    MemberArchive memberArchive = new MemberArchive();
    TableView table = new TableView();
    MyLogger myLogger = new MyLogger();

    public GUI() throws IOException {

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        //Creating table used to contain columns of information
        table.setColumnResizePolicy(table.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(500);
        table.setPrefWidth(700);

        //Column showing member number
        TableColumn<Integer, BonusMember> memberNoColumn = new TableColumn<>("Member number");
        memberNoColumn.setCellValueFactory(new PropertyValueFactory<>("MemberNo"));

        //Column showing name
        TableColumn<Personals, BonusMember> personalsColumn = new TableColumn<>("Name");
        personalsColumn.setCellValueFactory(new PropertyValueFactory<>("Personals"));

        //Column showing Enrollment date
        TableColumn<LocalDate, BonusMember> LocalDateColumn = new TableColumn<>("Registration date");
        LocalDateColumn.setCellValueFactory(new PropertyValueFactory<>("EnrolledDate"));

        //Column showing points
        TableColumn<Integer, BonusMember> pointsColumn = new TableColumn<>("Points");
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("Points"));

        //Adding the columns to the table
        table.setItems(memberList());
        table.getColumns().addAll(memberNoColumn, personalsColumn, LocalDateColumn, pointsColumn);
        updateTableView();  //Update TableView to refresh is there are changes to any of the columns

        //GridPane created to be used as the bottom of a BorderPane, containing the different buttons we want in our program
        GridPane buttonPane = new GridPane();
        Button addMemberButton = new Button("Add member");
        Button deleteMemberButton = new Button("Delete member");
        Button registerPointsButton = new Button("Register points");
        Button detailsMemberButton = new Button("Show details");

        //Specifying what happens when you click the different buttons
        addMemberButton.setOnAction(e -> addMember());
        deleteMemberButton.setOnAction(e -> deleteMember());
        registerPointsButton.setOnAction(e -> {
            int index = memberArchive.getMembers().indexOf(table.getSelectionModel().getSelectedItem());
            BonusMember member = memberArchive.getMembers().get(index);
            registerPoints(member);
        });
        detailsMemberButton.setOnAction(e -> {
            int index = memberArchive.getMembers().indexOf(table.getSelectionModel().getSelectedItem());
            BonusMember member = memberArchive.getMembers().get(index);
            showDetails(member);
        });

        buttonPane.add(addMemberButton, 1, 2);
        buttonPane.add(deleteMemberButton, 2, 2);
        buttonPane.add(registerPointsButton, 3, 2);
        buttonPane.add(detailsMemberButton, 4, 2);
        buttonPane.setVgap(10);
        buttonPane.setHgap(10);

        GridPane gridPane = new GridPane();
        gridPane.add(table, 1, 1);

        //BorderPane created to be used as scene
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(buttonPane);
        borderPane.setPadding(new Insets(20, 20, 20, 20));

        //Alternative method for checking members - double click to view information about selected member
        table.setRowFactory(tv -> {
            TableRow<BonusMember> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    BonusMember rowData = row.getItem();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Bonus member information");

                    if(rowData instanceof BasicMember){
                        alert.setHeaderText("Basic member information");
                        alert.setContentText(String.valueOf(rowData));
                    }
                    else if(rowData instanceof SilverMember){
                        SilverMember rowDataSilver = (SilverMember) row.getItem();
                        alert.setHeaderText("Silver member information");
                        alert.setContentText(String.valueOf(rowDataSilver));
                    }
                    else if(rowData instanceof GoldMember){
                        GoldMember rowDataGold = (GoldMember) row.getItem();
                        alert.setHeaderText("Gold member information");
                        alert.setContentText(String.valueOf(rowDataGold));
                    }
                    alert.show();
                }
            });
            return row;
        });

        //Creating main window containing the different sections
        Scene mainScene = new Scene(borderPane);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    //Method for adding BonusMembers to a list
    public ObservableList<BonusMember> memberList() {
        ObservableList<BonusMember> list = FXCollections.observableArrayList();


        Personals odin = new Personals("Odin", "Kvarving", "Odinkvarving@hotmail.com", "banan");
        Personals andreas = new Personals("Andreas", "Midtlyng", "Andreasmidtlyng@hotmail.com", "andreas");
        Personals petter = new Personals("Petter", "Lie", "Petterlie@hotmail.com", "petter");
        int memberNo1 = memberArchive.newMember(odin, LocalDate.of(2020, 2, 24));
        int memberNo2 = memberArchive.newMember(andreas, LocalDate.of(2020, 1, 24));
        int memberNo3 = memberArchive.newMember(petter, LocalDate.of(2020, 1, 24));
        memberArchive.registerPoints(memberNo3, 50000);

        memberArchive.getMembers().forEach(list :: add);
        checkMember();
        return list;
    }

    public void addMember() {
        Stage stage = new Stage();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        TextField firstname = new TextField("Firstname: ");
        firstname.setPrefHeight(40);
        firstname.setPromptText("First name");
        gridPane.add(firstname, 1, 1);


        TextField surname = new TextField("Surname: ");
        surname.setPromptText("Surname");
        surname.setPrefHeight(40);
        gridPane.add(surname, 1, 2);

        TextField email = new TextField("Email Address: ");
        email.setPromptText("Email");
        email.setPrefHeight(40);
        gridPane.add(email, 1, 3);

        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        password.setPrefHeight(40);
        gridPane.add(password, 1, 4);

        Button confirmButton = new Button("Register");
        confirmButton.setPrefHeight(40);
        confirmButton.setDefaultButton(true);
        confirmButton.setPrefWidth(100);
        gridPane.add(confirmButton, 1, 5);
        GridPane.setHalignment(confirmButton, HPos.CENTER);
        GridPane.setMargin(confirmButton, new Insets(20, 0, 20, 0));

        confirmButton.setOnAction(a -> {
            try {
                Personals personals = new Personals(firstname.getText(), surname.getText(), email.getText(), password.getText());
                memberArchive.newMember(personals, LocalDate.now());
                stage.close();
                updateTableView();
            } catch (Exception e) {
                myLogger.getLogger().log(Level.FINE,e.getMessage());
            }
        });

        Scene scene = new Scene(gridPane, 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    public void deleteMember() {
        memberArchive.getMembers().remove(table.getSelectionModel().getSelectedItem());
        updateTableView();
    }

    public void checkMember() {
        memberArchive.checkMember();
        updateTableView();
    }

    public void registerPoints(BonusMember member) {
        Stage stage = new Stage();
        TextField textField = new TextField();
        textField.setPromptText("Points...");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(textField);
        borderPane.setPrefHeight(100);
        borderPane.setPrefWidth(100);
        borderPane.setPadding(new Insets(20, 20, 20, 20));
        Button registerPointsButton = new Button("Confirm");
        registerPointsButton.setOnAction(a -> {
            try {
                memberArchive.registerPoints(member.getMemberNo(), Integer.parseInt(textField.getText()));
                updateTableView();
                checkMember();
                stage.close();
            } catch (Exception e) {
                myLogger.getLogger().log(Level.FINE,e.getMessage());
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(textField, 1, 1);
        Label headerLabel = new Label("Register points");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
        gridPane.add(registerPointsButton, 1, 2);
        stage.setScene(new Scene(gridPane, 400, 250));
        stage.show();

    }

    public void showDetails(BonusMember member) {
        String message;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (member.getPoints() > 0 && member.getPoints() < 25000) {
            message = "\nName: " + member.getPersonals().toString() + "\nEmail address: " + member.getPersonals().getEmailAddress() +
                    "\nStatus: BasicMember" + "\nPoints: " + member.getPoints();
        }
        else if (member.getPoints() >= 25000 && member.getPoints() < 75000) {
            message = "\nName: " + member.getPersonals().toString() + "\nEmail address: " + member.getPersonals().getEmailAddress() +
                    "\nStatus: SilverMember" + "\nPoints: " + member.getPoints();
        }
        else if (member.getPoints() >= 75000) {
            message = "\nName: " + member.getPersonals().toString() + "\nEmail address: " + member.getPersonals().getEmailAddress() +
                    "\nStatus: GoldMember" + "\nPoints: " + member.getPoints();
        }
        else if (member.getPoints() == 0) {
            message = "\nName: " + member.getPersonals().toString() + "\nEmail address: " + member.getPersonals().getEmailAddress() +
                    "\nStatus: BasicMember" + "\nPoints: " + member.getPoints();
        }
        else {
            message = "An error has occured. ";
            alert.setAlertType(Alert.AlertType.WARNING);
        }
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void updateTableView() {
        table.getItems().clear();
        for (BonusMember member : memberArchive.getMembers()) {
            table.getItems().add(member);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


