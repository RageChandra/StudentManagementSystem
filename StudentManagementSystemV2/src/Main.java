/*
================================
DEVELOPER NAME: R CHANDRA
Created date: 7th August 2026
Version : V2
Last Modified date: 29/08/2026
Modified Count: 127
==================================
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;
public class Main extends Application{                                                     //Inheriting the methods of the Class Application to Main 
    Scene mainscene;  
    Label totalStudents;
    Label avgCgpa;                                                                     // creating an Scene named mainscene which contains the content in it.
    public static void main(String[] args){                                                                         //main() is like an entry point of the javaFx 
        launch(args);                //launch() is an method in the class Application which is static method and passing args to it from Cmd received by String[] args;
    }
    StudentManagement mang;
    private void updateDashboard() {
    totalStudents.setText(String.valueOf(mang.getTotalStudent()));
    avgCgpa.setText(String.format("%.2f", mang.getAverageCgpa()));
}
       
    
    /*---------@override-----------
        generally javaFx Application Class already contains an method start like
        public void start(stage primarystage){
            //empty
        }
        so now we are overriding the method start with our UI which is initially empty 
        after the launch statement the launch method automatically calls the start() method
            launch()----->start();*/

        @Override 
        public void start(Stage stage){                 
        mang = new StudentManagement();      //creating of Object of StudentManagement using ref var "mang" because it contains all the internal operations like storing and issuing ID to students
        VBox root = new VBox();                                // VBox is an class and root is ref var and new VBox() creates an object of VBox and used to manage data vertically
        GridPane menuGrid = new GridPane();                    // Grid pane is used to store data in rows and coloums wise
        menuGrid.setId("menuGrid");                            //menuGrid.setId("menuGrid")----->helps in CSS pack to add colours and styling its just like tag line
        menuGrid.setHgap(20);                                  //setting the Horizantal gap of 20
        menuGrid.setVgap(15);                                   //setting vertical gap of 15
        menuGrid.setAlignment(Pos.CENTER);                       // setting the elements to be in center
        root.setId("mainMenu");                                   //setting an ID named "main menu" for root which is used in css style                                   //setting an ID for roots "add form" because to use in style sheet
        stage.setTitle("Student Management System");               //setting the window name as Student Management System
        Label name = new Label("Student Management System"); //label is used to print the text inside the window and we kept it as "Welcome to Student Managemnet System"
        name.setId("title");                                            //to add styling to that label we made it to set as "Title" which is used in css
        Label subTitle = new Label("Developed by CHANDRA R");//adding subtitle for creator name
        subTitle.setId("subtitle");                       //setting id to it to be used in CSS
        Button add = new Button("Add Student");                              //creating button for adding students in the main window
        add.setId("addButton");                                               //styling for add button
        Button view = new Button("View Students");
        view.setId("viewButton");                             //Button creation for the view feature
        Button Search = new Button("Search Student"); 
        Search.setId("searchMenuButton");                         //button creation for search feature
        Button update = new Button("Update Student");                          //button creation for update feature
        update.setId("updateButton");                                          //setting id for update button for styling in css
        Button delete = new Button("Delete student");                           //delete button creation
        delete.setId("deleteButton");                                           //deletion button styling 
        Button save = new Button("Save Student");                               //save button in add form
        save.setId("saveButton");                                               //setting id for save button to make use in css
        Button exit = new Button("Exit app");                                   //exiting app button
        exit.setId("exitButton");                                               
        Button back = new Button("Back");                                       //back button creation
        back.setId("backButton");                                               
        menuGrid.add(add, 0, 0);                                                //created an gridpane called mainmenu so now adding all button to it to make them in row and coloum arrangement
        menuGrid.add(view, 1, 0);
        menuGrid.add(Search, 0, 1);
        menuGrid.add(update, 1, 1);
        menuGrid.add(delete, 0, 2);
        menuGrid.add(exit, 1, 2);
        root.getChildren().add(name);                                            //adding the name "Welcome to student management system" to window 
        root.getChildren().add(subTitle);   
        Label dashboard = new Label("Dashboard Overview");
        dashboard.setId("dashboardTitle");
        root.getChildren().add(dashboard);                                     //adding subtitle to the window
        HBox statsBox = new HBox(30);
        statsBox.setAlignment(Pos.CENTER);
        statsBox.setId("statsBox");
        VBox totalCard = new VBox(10);
        Label totalTitle = new Label("TOTAL STUDENTS");
        totalTitle.setId("statTitle");
        totalStudents = new Label(String.valueOf(mang.getTotalStudent()));
        totalStudents.setId("totalValue");
        totalCard.setId("totalCard");
        totalCard.setAlignment(Pos.CENTER);
        totalCard.getChildren().addAll(totalTitle, totalStudents);
        statsBox.getChildren().add(totalCard);
        root.getChildren().add(statsBox);
        root.getChildren().add(menuGrid);                                        //now as all buttons are stored in gridpane now we are making add the gridpane to the window
        root.setAlignment(Pos.CENTER);           
        avgCgpa = new Label(String.valueOf(mang.getAverageCgpa()));
        avgCgpa.setId("cgpaValue");
        VBox cgpaCard = new VBox(10);
        Label cgpaTitle = new Label("AVERAGE CGPA");
        cgpaTitle.setId("statTitle");
        cgpaCard.setId("cgpaCard");
        cgpaCard.setAlignment(Pos.CENTER);
        cgpaCard.getChildren().addAll(cgpaTitle,avgCgpa);
        statsBox.getChildren().add(cgpaCard);
        add.setOnAction(e->{  
        GridPane roots = new GridPane();                           /*Grid pane is used to arrange the elements in the rows and coloums wise so creating an new Grid pane named roots  */
        roots.setId("addForm");              
        TextField inputn = new TextField();                                          //Taking input through textField for name
        TextField inputa = new TextField();                                          //Taking input through textField for age
        TextField inputb = new TextField();                                          //Taking input through textField for Branch
        TextField inputm = new TextField();                                          //Taking input through textfield for Mobile Number
        inputm.getText();
        TextField inputc = new TextField();                                          //setting the add Button on the Action (making the response to the add button)
            Label inputname = new Label("Name of Student: ");                       //labels to be needed in add form when user clicks the add Student button
            Label inputage = new Label("Age of Student: ");                           
            Label inputBranch = new Label("Branch of Student: ");
            Label inputMobile = new Label("Mobile Number is: ");
            Label inputCgpa = new Label("Student CGPA(Intermediate or +2):  ");
            roots.add(inputname,0,0);                                               //adding the labels to gridpane for making cleaner view 
            roots.add(inputage,0,1);
            roots.add(inputBranch,0,2);
            roots.add(inputMobile,0,3);
            roots.add(inputCgpa,0,4);
            roots.add(inputn,1,0);                                                  //adding the text fields to make to take the input
            roots.add(inputa,1,1);
            roots.add(inputb,1,2);
            roots.add(inputm,1,3);
            roots.add(inputc,1,4);
            roots.add(save,1,5);                                                   //adding the save student button into form
            roots.add(back,2,5);                                                   //adding back button into the add student form
            roots.setAlignment(Pos.CENTER); 
            save.setOnAction(ex->{   
            String namesText = inputn.getText();
            String agesText = inputa.getText();
            String branchesText = inputb.getText();
            String MobilesText = inputm.getText();
            String cgpasText = inputc.getText();
            if(namesText.isEmpty()||agesText.isEmpty()||branchesText.isEmpty()||MobilesText.isEmpty()||cgpasText.isEmpty()){
                Alert empty = new Alert(Alert.AlertType.INFORMATION);
                empty.setTitle("empty alert");
                empty.setContentText("Please Fill All fields");
                empty.show();
                return;
            }                     /*Grid pane is used to arrange the elements in the rows and coloums wise so creating an new Grid pane named roots  */        //setting save button to work
            String names = inputn.getText();
            if(Validation.isValidName(names)){
                System.out.println("Student Name: "+names);
            }
            else{
                Alert alertnames = new Alert(Alert.AlertType.INFORMATION);
                alertnames.setTitle("validation alert");
                alertnames.setContentText("Please enter correct name");
                alertnames.showAndWait();
            }
            int ages = Integer.parseInt(inputa.getText());
            if(Validation.isValidAge(ages)){
                System.out.println("Student Age: "+ages);
            }
            else{
                Alert alertages = new Alert(Alert.AlertType.INFORMATION);
                alertages.setTitle("validation alert");
                alertages.setContentText("Please enter valid age");
                alertages.showAndWait();
            }
            String branches = inputb.getText();
            if(Validation.isValidBranch(branches)){
                System.out.println("Student Branch: "+branches);
            }
            else{
                Alert alertbranches = new Alert(Alert.AlertType.INFORMATION);
                alertbranches.setTitle("validation alert");
                alertbranches.setContentText("Please enter valid Branch");
                alertbranches.showAndWait();

            }
            String Mobiles = inputm.getText();
            if(Validation.isValidMobileNumber(Mobiles)){
                System.out.println("Student Mobile: "+Mobiles);
            }
            else{
                Alert alertMobiles = new Alert(Alert.AlertType.INFORMATION);
                alertMobiles.setTitle("validation alert");
                alertMobiles.setContentText("Please enter valid Mobile Number");
                alertMobiles.showAndWait();
            }
            double cgpas = Double.parseDouble(inputc.getText());
            if(Validation.isValidCgpa(cgpas)){
                System.out.println("Student CGPA: "+cgpas);
            }
            else{
                Alert alertGpa = new Alert(Alert.AlertType.INFORMATION);
                alertGpa.setTitle("validation alert");
                alertGpa.setContentText("Please enter valid CGPA");
                alertGpa.showAndWait();
            }
            if(Validation.isValidAge(ages)&&Validation.isValidBranch(branches)&&Validation.isValidCgpa(cgpas)&&Validation.isValidName(names)&&Validation.isValidMobileNumber(Mobiles)){
            int id= mang.addStudent(names,ages,branches,cgpas,Mobiles);
            totalStudents.setText(String.valueOf(mang.getTotalStudent()));
            avgCgpa.setText(String.valueOf(mang.getAverageCgpa()));
            System.out.println("Student Successfully added");
            System.out.println("Student ID is: "+id);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Added Successfully");
            alert.setHeaderText("Successfully Student Added!!");
            alert.setContentText("Student ID: "+id);
            alert.showAndWait();
            inputn.clear();
            inputa.clear();
            inputb.clear();
            inputc.clear();
            inputm.clear();
            }
        });                                        // alignment of every things into neat center
            Scene addStudentForm = new Scene(roots,900,750);                                   //scene for add student
            addStudentForm.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());//styling for add student form
            stage.setScene(addStudentForm); //setting stage(Window) for add student form
            stage.show();//displaying the stage
        });
        back.setOnAction(e -> {       //back button on action
         stage.setScene(mainscene);   //back to main menu 
        });
        view.setOnAction(e->{
            Button backFromView = new Button("Back to Main");
            backFromView.setId("backFromViewButton");
            ArrayList<Student> students = mang.viewStudents();
            TableView <Student> st = new TableView<>();
            st.setId("viewTable");
            TableColumn<Student , String> Name = new TableColumn<>("Name");
            Name.setCellValueFactory(
                new PropertyValueFactory<>("name")
            );
            TableColumn<Student , Integer>  Age = new TableColumn<>("Age");
            Age.setCellValueFactory(
                new PropertyValueFactory<>("age")
            );
            TableColumn<Student , String> Branch = new TableColumn<>("Branch");
            Branch.setCellValueFactory(
                new PropertyValueFactory<>("branch")
            );
            TableColumn<Student , Double> Cgpa = new TableColumn<>("CGPA");
            Cgpa.setCellValueFactory(
                new PropertyValueFactory<>("cgpa")
            );
            TableColumn<Student , String> MobileN = new TableColumn<>("Mobile Number");
            MobileN.setCellValueFactory(
                new PropertyValueFactory<>("mobileNumber")
            );
            TableColumn<Student , Integer> STID = new TableColumn<>("Student ID");
            STID.setCellValueFactory(
                new PropertyValueFactory<>("studentId")
            );
            VBox viewBox = new VBox();
            viewBox.setId("viewStudentsPane");
            viewBox.getChildren().addAll(st, backFromView);
            viewBox.setSpacing(10);
            viewBox.setAlignment(Pos.CENTER);
            st.getColumns().add(STID);
            st.getColumns().add(Name);
            st.getColumns().add(Age);
            st.getColumns().add(Branch);
            st.getColumns().add(Cgpa);
            st.getColumns().add(MobileN);
            ObservableList<Student> data = FXCollections.observableArrayList(students);
            st.setItems(data);
            Scene scs = new Scene(viewBox,900,750);
            scs.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scs);
            stage.show();
            backFromView.setOnAction(ev -> {
                stage.setScene(mainscene);
            });
        });
        Search.setOnAction(e->{
            Label enterStudentID = new Label("Enter Student ID: ");
            TextField eSID = new TextField();
            eSID.setId("searchIdField");
            GridPane searchpane = new GridPane();
            searchpane.setId("searchPane");
            Button searchByID = new Button("Search Student");
            searchByID.setId("SearchButtonInSearch");
            Button backFromSearch = new Button("Back");
            backFromSearch.setId("BackFromSearchStudent");
            searchpane.add(enterStudentID,0,0);
            searchpane.add(eSID,0,1);
            searchpane.add(backFromSearch,1,2);
            searchpane.add(searchByID,0,2);
            searchpane.setAlignment(Pos.CENTER);
            Scene searchscene = new Scene(searchpane,900,750);
            searchscene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(searchscene);
            stage.show();
            searchByID.setOnAction(ev->{
                int enteredStudentID = Integer.parseInt(eSID.getText());
                Student SearchingID = mang.searchStudent(enteredStudentID);
                if(SearchingID!=null){
                Alert alerts = new Alert(Alert.AlertType. INFORMATION);
                alerts.setTitle("Student details");
                alerts.setHeaderText("Student found");
                alerts.setContentText("Student Details are: "+SearchingID);
                alerts.show();
                System.out.println(SearchingID);
                SearchingID.toString();
                }
                else{
                    Alert alertForSearch = new Alert(Alert.AlertType.INFORMATION);
                    alertForSearch.setTitle("Student Details");
                    alertForSearch.setHeaderText("Student Not found");
                    alertForSearch.show();
                }
            });
            backFromSearch.setOnAction(ev->{
                stage.setScene(mainscene);
            });
        });
        update.setOnAction(e->{
            System.out.println("UPDATE BUTTON CLICKED");
            Label updating = new Label("Enter the Student ID: ");
            TextField UpdatingID = new TextField();
            Button findstudent = new Button("Find Student");
            findstudent.setId("FindStudentUpdate");
            Button backUpdate = new Button("Back");
            backUpdate.setId("BackUpdate");
            Button updateStudentData = new Button("Update Student Data");
            updateStudentData.setId("UpdateStudentData");
            GridPane updatingPane = new GridPane();
            updatingPane.setId("updateSearchPane");
            updatingPane.add(UpdatingID,1,0);
            updatingPane.add(updating,0,0);
            updatingPane.add(findstudent,0,1);
            updatingPane.add(backUpdate,1,1);
            updatingPane.setAlignment(Pos.CENTER);
            Scene updatingScene = new Scene(updatingPane,900,750);
            updatingScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(updatingScene);
            stage.show();
            findstudent.setOnAction(ev->{
                System.out.println("FIND STUDENT CLICKED");
                int enteredUpdatingID = Integer.parseInt(UpdatingID.getText());
                Student searchUpdatingID = mang.searchStudent(enteredUpdatingID);
                if(searchUpdatingID != null){
                    GridPane UpdateDetails = new GridPane();
                    UpdateDetails.setId("updateDetailsPane");
                    UpdateDetails.setAlignment(Pos.CENTER);
                    Label updatingName = new Label("Name: ");
                    TextField updatingNameField = new TextField(searchUpdatingID.getName());
                    Label updatingAge = new Label("Age: ");
                    TextField updatingAgeField =new TextField(String.valueOf(searchUpdatingID.getAge()));
                    Label updatingBranch = new Label("Branch: ");
                    TextField updatingBranchField = new TextField(searchUpdatingID.getBranch());
                    Label updatingCgpa = new Label("CGPA: ");
                    TextField updatingCgpaField =new TextField(String.valueOf(searchUpdatingID.getCgpa()));
                    Label updatingMobile = new Label("Mobile Number: ");
                    TextField updatingMobileField = new TextField(searchUpdatingID.getMobileNumber());
                    UpdateDetails.add(updatingName, 0, 0);
                    UpdateDetails.add(updatingNameField, 1, 0);
                    UpdateDetails.add(updatingAge, 0, 1);
                    UpdateDetails.add(updatingAgeField, 1, 1);
                    UpdateDetails.add(updatingBranch, 0, 2);
                    UpdateDetails.add(updatingBranchField, 1, 2);
                    UpdateDetails.add(updatingCgpa, 0, 3);
                    UpdateDetails.add(updatingCgpaField, 1, 3);
                    UpdateDetails.add(updatingMobile, 0, 4);
                    UpdateDetails.add(updatingMobileField, 1, 4);
                    UpdateDetails.add(updateStudentData,1,5);
                    Button backUpdatingStudentData = new Button("Back");
                  backUpdatingStudentData.setId("Backtomainfromupdating");
                  backUpdatingStudentData.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                    backUpdatingStudentData.setOnAction(ea->{
                            stage.setScene(mainscene);
                        });
                    UpdateDetails.add(backUpdatingStudentData,2,5);
                    updateStudentData.setOnAction(eu->{
                        String newName = updatingNameField.getText();
                        int newAge = Integer.parseInt(updatingAgeField.getText());
                        String newBranch = updatingBranchField.getText();
                        double newCgpa = Double.parseDouble(updatingCgpaField.getText());
                        String newmobile = updatingMobileField.getText();
                        searchUpdatingID.setName(newName);
                        searchUpdatingID.setAge(newAge);
                        searchUpdatingID.setbranch(newBranch);
                        searchUpdatingID.setCgpa(newCgpa);
                        searchUpdatingID.setmobileNumber(newmobile);
                        Alert alertUpdated = new Alert(Alert.AlertType.INFORMATION);
                        alertUpdated.setTitle("Update Status");
                        alertUpdated.setHeaderText("Update Successfull");
                        updateDashboard();
                        alertUpdated.show();
                    });
                    Scene updateDetailsScene = new Scene(UpdateDetails, 900, 750);
                    updateDetailsScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                    stage.setScene(updateDetailsScene);
                    stage.show();
                }
                else{
                    Alert updatingalert = new Alert(Alert.AlertType.INFORMATION);
                    updatingalert.setTitle("Update Status");
                    updatingalert.setHeaderText("Student Not Found");
                    updatingalert.show();
                }
            }
            );
            backUpdate.setOnAction(eb->{
                    stage.setScene(mainscene);
            });
        });
        delete.setOnAction(e->{
            Label deleteStudentID = new Label("Enter Student ID: ");
            TextField delStudentID = new TextField();
            Button deleteStudent = new Button("Delete Student");
            Button backFromDelete = new Button("back");
            deleteStudent.setId("deleteStudentAction");
            backFromDelete.setId("backFromDelete");
            GridPane deletepane = new GridPane();
            deletepane.setId("deletePane");
            deletepane.add(deleteStudentID,0,0);
            deletepane.add(delStudentID,1,0);
            deletepane.add(deleteStudent,0,1);
            deletepane.add(backFromDelete,1,1);
            deletepane.setAlignment(Pos.CENTER);
            Scene del = new Scene(deletepane,900,750);
            del.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(del);
            stage.show();
            deleteStudent.setOnAction(ea->{
                    int enteredDeletedStudentID = Integer.parseInt(delStudentID.getText());
                    Student delStudents = mang.searchStudent(enteredDeletedStudentID);
                    if(delStudents!=null){
                        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
                        confirmDelete.setTitle("Delete Student");
                        confirmDelete.setHeaderText("Student Found");
                        confirmDelete.setContentText("Are you sure you want to delete Student ID: " + enteredDeletedStudentID + "?");
                        Optional<ButtonType> result = confirmDelete.showAndWait();
                        if(result.isPresent() && result.get()==ButtonType.OK){
                            Student deleted = mang.removeStudent(enteredDeletedStudentID);
                            Alert deletedStudent = new Alert(Alert.AlertType.INFORMATION);
                            deletedStudent.setTitle("Deletion Status");
                            deletedStudent.setHeaderText("Successfully Deleted");
                            updateDashboard();
                            deletedStudent.setContentText("Successfully Student "+enteredDeletedStudentID+" Deleted");
                            deletedStudent.showAndWait();
                        }
                    }
                    else{
                        Alert delStatus = new Alert(Alert.AlertType.INFORMATION);
                        delStatus.setTitle("Deletion status");
                        delStatus.setHeaderText("Student not Found");
                        delStatus.setContentText("deletion Failed");
                        delStatus.show();
                    }
            });
            backFromDelete.setOnAction(esa->{
                stage.setScene(mainscene);
            });
        });
        exit.setOnAction(e ->{
            stage.close();
        });
        VBox LoginRoot = new VBox();
        Label LoginTitle = new Label("Welcome To Student Management System\n");
        LoginTitle.setId("LoginTitle");
        Label subLogin = new Label("\n🔒  Admin Login  \n");
        subLogin.setId("subLogin");
        Button LoginButton = new Button("Login");
        LoginButton.setId("LoginButton");
        LoginRoot.getChildren().add(LoginTitle);
        LoginRoot.getChildren().add(subLogin);
        GridPane Login = new GridPane();
        Label LoginId = new Label("Enter Your ID:  ");
        LoginId.setId("LoginIdLabel");
        Label LoginPassword = new Label("Enter Your Password: ");
        LoginPassword.setId("LoginPasswordLabel");
        TextField inputLoginId = new TextField();
        PasswordField inputLoginPassword = new PasswordField();
        Login.add(LoginId,0,0);
        Login.add(LoginPassword,0,1);
        Login.add(inputLoginId,1,0);
        Login.add(inputLoginPassword,1,1);
        Login.setAlignment(Pos.CENTER);
        LoginRoot.setAlignment(Pos.CENTER);
        LoginRoot.setId("LoginPane");
        LoginRoot.setSpacing(15);
        Login.setHgap(10);
        Login.setVgap(15);
        LoginRoot.getChildren().add(Login);
        LoginRoot.getChildren().add(LoginButton);
        Scene LoginPage = new Scene(LoginRoot,900,750);
        LoginPage.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setScene(LoginPage);   
        stage.show();
        LoginButton.setOnAction(ex->{
        int recievedId = Integer.parseInt(inputLoginId.getText());
        String receivedPassword = inputLoginPassword.getText();
        System.out.println(recievedId);
        System.out.println(receivedPassword);
        if(Validation.isValidLogin(recievedId, receivedPassword)){
        mainscene = new Scene(root,900,750);
        mainscene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setScene(mainscene);
        stage.show();
        }
        else{
            Alert Loginalert = new Alert(Alert.AlertType.INFORMATION);
            Loginalert.setTitle("Login Failed");
            Loginalert.setHeaderText("Invalid Credentials");
            Loginalert.setContentText("Contact Management for Help");
            Loginalert.showAndWait();
        }
        });
    }
}