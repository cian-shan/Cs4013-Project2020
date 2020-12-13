import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class  GUI extends Application {

    Stage window;
    Scene sceneHome, sceneUserLogin, SceneAdminLogin, sceneUserFns, sceneAdminFns, sceneAddPropertyFn, sceneGetTotalTaxForAPropertyFn,
            scenePayTaxFn, scenePropertyForAnOwnerFn, sceneQueryTaxDueForAYearFn, sceneTaxDueForAnAreaFn, sceneTaxDueForAPropertyFn ;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setMinWidth(600);
        window.setMinHeight(400);


        //HOME Buttons @ Labels
        Label labelUserType = new Label("Select a User Type:");
        Label labelLoginAs = new Label("Log in as a:");
        Button buttonUser = new Button("User");
        Button buttonAdmin = new Button("Admin");
        buttonUser.setOnAction(e -> window.setScene(sceneUserFns));
        buttonAdmin.setOnAction(e -> window.setScene(sceneAdminFns));

        //Home Layout
        VBox layoutHome = new VBox(20);
        layoutHome.getChildren().addAll(labelUserType, labelLoginAs, buttonUser, buttonAdmin);
        sceneHome = new Scene(layoutHome, 200, 200);


        //USERFN's Buttons & Labels
        Button buttonHome = new Button("Home");
        Button buttonAddPropertyFn = new Button("Add Property");
        /*Button buttonViewPropertiesFn = new Button("View Properties");*/
        Button buttonGetTotalTaxForAPropertyFn = new Button("Get Total Tax For a Property");
        Button buttonTaxDueForAYearFn = new Button("Tax Due For a Year");
        Button buttonPayTaxFn = new Button("Pay Tax");
        Button buttonTaxDueForAPropertyFn = new Button("Tax Due For a Property");
        buttonHome.setOnAction(e -> window.setScene(sceneHome));
        buttonAddPropertyFn.setOnAction(e -> window.setScene(sceneAddPropertyFn));
        /*buttonViewPropertiesFn.setOnAction(e -> window.setScene(sceneAddPropertyFn));*/
        buttonGetTotalTaxForAPropertyFn.setOnAction(e -> window.setScene(sceneGetTotalTaxForAPropertyFn));
        buttonTaxDueForAYearFn.setOnAction(e -> window.setScene(sceneQueryTaxDueForAYearFn));
        buttonPayTaxFn.setOnAction(e -> window.setScene(scenePayTaxFn));
        buttonTaxDueForAPropertyFn.setOnAction(e -> window.setScene(sceneTaxDueForAPropertyFn));

        //USERFN's Layout
        VBox layoutUserFn = new VBox(20);
        layoutUserFn.getChildren().addAll(buttonAddPropertyFn, /*buttonViewPropertiesFn*/ buttonGetTotalTaxForAPropertyFn,
                buttonTaxDueForAYearFn, buttonPayTaxFn, buttonTaxDueForAPropertyFn, buttonHome);
        sceneUserFns = new Scene(layoutUserFn, 600, 300);


        //ADMINFN's Buttons & Labels
        Button buttonHome1 = new Button("Home");
        Button buttonPropertyForAnOwnerFn = new Button("Get Property For An Owner");
        Button buttonTaxDueForAnAreaFn = new Button("Get Tax Due For An Area");
        buttonHome1.setOnAction(e -> window.setScene(sceneHome));
        buttonPropertyForAnOwnerFn.setOnAction(e -> window.setScene(scenePropertyForAnOwnerFn));
        buttonTaxDueForAnAreaFn.setOnAction(e -> window.setScene(sceneTaxDueForAnAreaFn));

        //ADMINFN's Layout
        VBox layoutAdminFn = new VBox(20);
        layoutAdminFn.getChildren().addAll(buttonPropertyForAnOwnerFn, buttonTaxDueForAnAreaFn, buttonHome1);
        sceneAdminFns = new Scene(layoutAdminFn, 600, 300);


        //ADDPROPERTYFN Buttons & Labels
        Label labelAddProperty = new Label("Add a Property:");
        Label labelAddPropertyOwner = new Label("Property Owner(s:)");
        Label labelAddPropertyAddress = new Label("Property Address:");
        Label labelAddPropertyEircode = new Label("Property Eircode:");
        Label labelAddPropertyEMV = new Label("Estimated Market Value:");
        Label labelAddPropertyLocationCat = new Label("Location Category:");
        Label labelAddPropertyPrivateRes = new Label("Principle Private Residence?");
        Label labelAddPropertyYearsOwned = new Label("Years Owned:");

        TextField textAddPropertyOwner = new TextField();
        TextField textAddPropertyAddress = new TextField();
        TextField textAddPropertyEircode = new TextField();
        TextField textAddPropertyEMV = new TextField();
        TextField textAddPropertyLocationCat = new TextField("City/Large town/Small town/Village/Countryside");
        TextField textAddPropertyPrivateRes = new TextField("Yes/No");
        TextField textAddPropertyYearsOwned = new TextField();

        Button buttonBack1 = new Button("Back");
        Button buttonSubmit1 = new Button("Submit");
        buttonBack1.setOnAction(e -> window.setScene(sceneUserFns));
        buttonSubmit1.setOnAction(e -> window.setScene(sceneHome));
        /*buttonSubmit1.setOnAction(e -> (String propLine = (textAddPropertyOwner.getText() + "/" + textAddPropertyEMV.getText() + "/" +
                textAddPropertyLocationCat.getText() + "/" + textAddPropertyPrivateRes.getText() + "/" + textAddPropertyYearsOwned.getText() + "/" +
                textAddPropertyEircode.getText() + "/" + textAddPropertyAddress.getText()) );*/



        //ADDPROPERTYFN Layout
        VBox layoutAddPropertyFn = new VBox();
        layoutAddPropertyFn.getChildren().addAll(labelAddProperty, labelAddPropertyOwner, textAddPropertyOwner, labelAddPropertyAddress,
        textAddPropertyAddress, labelAddPropertyEircode, textAddPropertyEircode, labelAddPropertyEMV, textAddPropertyEMV, labelAddPropertyLocationCat,
        textAddPropertyLocationCat, labelAddPropertyPrivateRes, textAddPropertyPrivateRes, labelAddPropertyYearsOwned, textAddPropertyYearsOwned,
                buttonSubmit1, buttonBack1);
        sceneAddPropertyFn = new Scene(layoutAddPropertyFn, 600, 400);


        //GETTOTALTAXFORAPROPERTYFN Buttons & Labels
        Label labelGetTotalTaxForAProperty = new Label("Get Total Tax for a Property:");
        Label labelAddPropertyAddress1 = new Label("Property Address");

        TextField textGetPropertyAddress = new TextField();

        Button buttonBack2 = new Button("Back");
        Button buttonSubmit2 = new Button("Submit");
        buttonBack2.setOnAction(e -> window.setScene(sceneUserFns));
        buttonSubmit2.setOnAction(e -> window.setScene(sceneHome));

        //GETTOTALTAXFORAPROPERTYFN Layout
        VBox layoutGetTotalTaxForAProperty = new VBox(20);
        layoutGetTotalTaxForAProperty.getChildren().addAll(labelGetTotalTaxForAProperty, labelAddPropertyAddress1, textGetPropertyAddress, buttonSubmit2, buttonBack2);
        sceneGetTotalTaxForAPropertyFn = new Scene(layoutGetTotalTaxForAProperty, 600, 400);


        //PAYTAXFN Buttons & Labels
        Label labelPayTaxForAProperty = new Label("Pay Tax For a Property:");
        Label labelPayTaxAmountBeingPaid = new Label("Amount Being Paid:");
        Label labelPayTaxPropertyOwner = new Label("Property Owner");
        Label labelPayTaxPropertyAddress = new Label("Property Address");
        Label labelPayTaxYear= new Label("Year");

        TextField textPayTaxAmountBeingPaid = new TextField();
        TextField textPayTaxPropertyOwner = new TextField();
        TextField textPayTaxPropertyAddress = new TextField();
        TextField textPayTaxYear = new TextField();

        Button buttonBack3 = new Button("Back");
        Button buttonSubmit3 = new Button("Submit");
        buttonBack3.setOnAction(e -> window.setScene(sceneUserFns));
        buttonSubmit3.setOnAction(e -> window.setScene(sceneHome));

        //PAYTAXFN Layout
        VBox layoutPayTaxFn = new VBox(15);
        layoutPayTaxFn.getChildren().addAll(labelPayTaxForAProperty,labelPayTaxAmountBeingPaid, textPayTaxAmountBeingPaid,
                labelPayTaxPropertyOwner, textPayTaxPropertyOwner, labelPayTaxPropertyAddress, textPayTaxPropertyAddress,
                labelPayTaxYear, textPayTaxYear, buttonSubmit3, buttonBack3);
        scenePayTaxFn = new Scene(layoutPayTaxFn, 600, 400);


        //ADMINFN
        //PROPERTYFORANOWNERFN Buttons & Labels
        Label labelGetPropertiesForAnOwner = new Label("Get Properties For An Owner:");
        Label labelPropertiesForAnOwnerName = new Label("Owner's Name");

        TextField textPropertiesForAnOwnerName = new TextField();

        Button buttonBack4 = new Button("Back");
        Button buttonSubmit4 = new Button("Submit");
        buttonBack4.setOnAction(e -> window.setScene(sceneAdminFns));
        buttonSubmit4.setOnAction(e -> window.setScene(sceneHome));

        //PROPERTYFORANOWNERFN Layout
        VBox layoutPropertiesForAnOwner = new VBox(20);
        layoutPropertiesForAnOwner.getChildren().addAll(labelGetPropertiesForAnOwner, labelPropertiesForAnOwnerName,
                textPropertiesForAnOwnerName,buttonSubmit4, buttonBack4);
        scenePropertyForAnOwnerFn = new Scene(layoutPropertiesForAnOwner, 600, 400);

        //QUERYTAXDUEFORAYEARFN Buttons & Labels
        Label labelQueryTaxDueForAYear = new Label("Query Tax Due For a Year:");
        Label labelQueryTaxDueYearName = new Label("Name:");
        Label labelQueryTaxDueYearYearDue = new Label("Year Due:");

        TextField textQueryTaxDueYearName = new TextField();
        TextField textQueryTaxDueYearYearDue = new TextField();

        Button buttonBack5 = new Button("Back");
        Button buttonSubmit5 = new Button("Submit");
        buttonBack5.setOnAction(e -> window.setScene(sceneUserFns));
        buttonSubmit5.setOnAction(e -> window.setScene(sceneHome));

        //QUERYTAXDUEFORAYEARFN Layout
        VBox layoutQueryTaxDueForAYear = new VBox(20);
        layoutQueryTaxDueForAYear.getChildren().addAll(labelQueryTaxDueForAYear, labelQueryTaxDueYearName,textQueryTaxDueYearName,
                labelQueryTaxDueYearYearDue, textQueryTaxDueYearYearDue,buttonSubmit5, buttonBack5);
        sceneQueryTaxDueForAYearFn = new Scene(layoutQueryTaxDueForAYear, 600, 400);


        //ADMINFN
        //TOTALTAXDUEFORANAREAFN Buttons & Labels
        Label labelTotalTaxDueForAnArea = new Label("Total Tax Due For An Area:");
        Label labelTotalTaxDueForAnAreaEircode = new Label("Eircode:");

        TextField textTotalTaxDueForAnAreaEircode = new TextField();

        Button buttonBack6 = new Button("Back");
        Button buttonSubmit6 = new Button("Submit");
        buttonBack6.setOnAction(e -> window.setScene(sceneAdminFns));
        buttonSubmit6.setOnAction(e -> window.setScene(sceneHome));

        //TOTALTAXDUEFORANAREAFN Layout
        VBox layoutTotalTaxDueForAnArea = new VBox(20);
        layoutTotalTaxDueForAnArea.getChildren().addAll(labelTotalTaxDueForAnArea, labelTotalTaxDueForAnAreaEircode,
                textTotalTaxDueForAnAreaEircode,buttonSubmit6, buttonBack6);
        sceneTaxDueForAnAreaFn = new Scene(layoutTotalTaxDueForAnArea, 600, 400);


        //TAXDUEFORAPROPERTYFN Buttons & Labels
        Label labelTaxDueForAProperty = new Label("Tax Due For An Property:");
        Label labelTaxDueForAPropertyAddress = new Label("Property's Address:");

        TextField textTaxDueForAPropertyAddress = new TextField();

        Button buttonBack7 = new Button("Back");
        Button buttonSubmit7 = new Button("Submit");
        buttonBack7.setOnAction(e -> window.setScene(sceneUserFns));
        buttonSubmit7.setOnAction(e -> window.setScene(sceneHome));

        //TAXDUEFORAPROPERTYFN Layout
        VBox layoutTaxDueForAProperty = new VBox(20);
        layoutTaxDueForAProperty.getChildren().addAll(labelTaxDueForAProperty, labelTaxDueForAPropertyAddress,
                textTaxDueForAPropertyAddress, buttonSubmit7, buttonBack7);
        sceneTaxDueForAPropertyFn = new Scene(layoutTaxDueForAProperty, 600, 400);



        //Display scene 1 at first
        window.setScene(sceneHome);
        window.setTitle("Home");
        window.show();
    }


}
