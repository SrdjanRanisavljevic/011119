package cucumber.cucumberTests;

import api.sign.home.screen.HomeScreenView;
import api.sign.launcher.SignLauncherView;
import api.sign.login.Screen.SignLoginView;
import api.sign.send.screen.MessageScreen;
import api.sign.send.screen.SendScreenView;
import api.sign.send.screen.DocumentsScreen;
import api.sign.send.screen.RecipientsScreen;
import api.sign.settings.screen.SettingsView;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.io.FileNotFoundException;

public class SignStepDefinitions {


  // D I F F E R E N T      S H A R D S


    @And ("^User signs with NA1 user")
    public void enterNa1UserName () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.na1UserName);
    }


    @And ("^User signs with NA1 user B")
    public void enterNa1UserNameB () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.na1UserNameB);
    }

    // NA 2

    @And ("^User signs with NA2 user")
    public void enterNa2UserName () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.na2UserName);
    }

    @And ("^User signs with NA2 user B")
    public void enterNa2UserNameB () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.na2UserNameB);
    }

    // NA 3

    @And ("^User signs with NA3 user")
    public void enterNa3UserName () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.na3UserName);
    }

    @And ("^User signs with NA3 user B")
    public void enterNa3UserNameB () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.na3UserNameB);
    }


    // E U 1

    @And ("^User signs with EU1 user")
    public void enterEu1UserName () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.eu1UserName)
                .enterPassword()
                .clickOnSignInButton();

    }

    @And ("^User signs with EU1 user B")
    public void enteraEu1UserNameB () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.eu1UserNameB);
    }

// EU 2

    @And ("^User signs with EU2 user")
    public void enterEu2UserName () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.eu2UserName);
    }

    @And ("^User signs with EU2 user B")
    public void enterEu2UserNameB () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.eu2UserNameB);
    }

// JP 1     AU 1     IN 1


    @And ("^User signs with JP1 user")
    public void enterJp1UserName () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.jp1UserName);
    }

    @And ("^User signs with AU1 user")
    public void enteraAu1UserName () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.au1UserName);
    }

    @And ("^User signs with IN1 user")
    public void enteraIn1UserName () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        signLoginView.enterUserName(signLoginView.in1UserName);
    }


  // ENTERING RECIPIENTS ON SEND FOR SIGNATURE

    @And ("^Click on recipients button on send page")
    public void clickOnRecipientsButtonOnSednPage () throws FileNotFoundException {
        SendScreenView sendScreenView = new SendScreenView();
        sendScreenView.clickOnRecipientsButton();
    }

    @And ("^Enter recipient from NA1")
    public void enterRecipientFromNa1 () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        recipientsScreen.addRecipient(signLoginView.na1UserName);
    }

    @And ("^Enter recipient from NA2")
    public void enterRecipientFromNa2 () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        recipientsScreen.addRecipient(signLoginView.na2UserName);
    }

    @And ("^Enter recipient from EU1")
    public void enterRecipientFromEu1 () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        recipientsScreen.addRecipient(signLoginView.eu1UserName);
    }

    @And ("^Enter recipient from IN1")
    public void enterRecipientFromIn1 () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        recipientsScreen.addRecipient(signLoginView.in1UserName);
    }

    @And ("^Enter recipient from JP1")
    public void enterRecipientFromJp1 () throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        recipientsScreen.addRecipient(signLoginView.jp1UserName);
    }


    // R   O   L   E   S                  R   O   L   E   S

    @And ("^Assign delegator to approver role to the recipient from shard: \"([^\"]*)\"$")
    public void assignDelegatorToApproverRole (String arg0) throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        switch (arg0) {
            case "NA1": recipientsScreen.setDelegatorToApprover(signLoginView.na1UserName);
                break;
            case "NA1B": recipientsScreen.setDelegatorToApprover(signLoginView.na1UserNameB);
                break;
            case "NA2": recipientsScreen.setDelegatorToApprover(signLoginView.na2UserName);
                break;
            case "NA2B": recipientsScreen.setDelegatorToApprover(signLoginView.na2UserNameB);
                break;
            case "NA3": recipientsScreen.setDelegatorToApprover(signLoginView.na3UserName);
                break;
            case "NA3B": recipientsScreen.setDelegatorToApprover(signLoginView.na3UserNameB);
                break;
            case "EU1": recipientsScreen.setDelegatorToApprover(signLoginView.eu1UserName);
                break;
            case "EU1B": recipientsScreen.setDelegatorToApprover(signLoginView.na1UserNameB);
                break;
            case "EU2": recipientsScreen.setDelegatorToApprover(signLoginView.eu2UserName);
                break;
            case "EU2B": recipientsScreen.setDelegatorToApprover(signLoginView.eu2UserNameB);
                break;
            case "JP1": recipientsScreen.setDelegatorToApprover(signLoginView.jp1UserName);
                break;
            case "AU1": recipientsScreen.setDelegatorToApprover(signLoginView.au1UserName);
                break;
            case "IN1": recipientsScreen.setDelegatorToApprover(signLoginView.in1UserName);
                break;
        }
    }

    @And ("^Assign delegator to signer role to the recipient from shard: \"([^\"]*)\"$")
    public void assignDelegatorToSignerRole(String arg0) throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        switch (arg0) {
            case "NA1": recipientsScreen.setDelegatorToSigner(signLoginView.na1UserName);
                break;
            case "NA1B": recipientsScreen.setDelegatorToSigner(signLoginView.na1UserNameB);
                break;
            case "NA2": recipientsScreen.setDelegatorToSigner(signLoginView.na2UserName);
                break;
            case "NA2B": recipientsScreen.setDelegatorToSigner(signLoginView.na2UserNameB);
                break;
            case "NA3": recipientsScreen.setDelegatorToSigner(signLoginView.na3UserName);
                break;
            case "NA3B": recipientsScreen.setDelegatorToSigner(signLoginView.na3UserNameB);
                break;
            case "EU1": recipientsScreen.setDelegatorToSigner(signLoginView.eu1UserName);
                break;
            case "EU1B": recipientsScreen.setDelegatorToSigner(signLoginView.eu1UserNameB);
                break;
            case "EU2": recipientsScreen.setDelegatorToSigner(signLoginView.eu2UserName);
                break;
            case "EU2B": recipientsScreen.setDelegatorToSigner(signLoginView.eu2UserNameB);
                break;
            case "JP1": recipientsScreen.setDelegatorToSigner(signLoginView.jp1UserName);
                break;
            case "AU1": recipientsScreen.setDelegatorToSigner(signLoginView.au1UserName);
                break;
            case "IN1": recipientsScreen.setDelegatorToSigner(signLoginView.in1UserName);
                break;
        }
    }

    @And ("^Assign Approver role to the recipient from shard: \"([^\"]*)\"$")
    public void assignApproverRoleToRecipient (String arg0) throws FileNotFoundException {
        SignLoginView signLoginView = new SignLoginView();
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        switch (arg0) {
            case "NA1": recipientsScreen.setRoleToApprover(signLoginView.na1UserName);
                break;
            case "NA1B": recipientsScreen.setRoleToApprover(signLoginView.na1UserNameB);
                break;
            case "NA2": recipientsScreen.setRoleToApprover(signLoginView.na2UserName);
                break;
            case "NA2B": recipientsScreen.setRoleToApprover(signLoginView.na2UserNameB);
                break;
            case "NA3": recipientsScreen.setRoleToApprover(signLoginView.na3UserName);
                break;
            case "NA3B": recipientsScreen.setRoleToApprover(signLoginView.na3UserNameB);
                break;
            case "EU1": recipientsScreen.setRoleToApprover(signLoginView.eu1UserName);
                break;
            case "EU1B": recipientsScreen.setRoleToApprover(signLoginView.eu1UserNameB);
                break;
            case "EU2": recipientsScreen.setRoleToApprover(signLoginView.eu2UserName);
                break;
            case "EU2B": recipientsScreen.setRoleToApprover(signLoginView.eu2UserNameB);
                break;
            case "JP1": recipientsScreen.setRoleToApprover(signLoginView.jp1UserName);
                break;
            case "AU1": recipientsScreen.setRoleToApprover(signLoginView.au1UserName);
                break;
            case "IN1": recipientsScreen.setRoleToApprover(signLoginView.in1UserName);
                break;
        }
    }


    @And ("^Click on done on Recipients Page")
    public void clickDoneOnRecipientsPage () throws FileNotFoundException {
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        recipientsScreen.clickOnDone();
    }



    // S  I  G  N         O   U   T

    @And ("^Sign out - from home screen")
    public void signOut () throws FileNotFoundException {
        HomeScreenView homeScreenView = new HomeScreenView();
        homeScreenView.clickOnSettingsButton();
        SettingsView settingsView = new SettingsView();
        settingsView.clickOnSignOut();
    }





    // CELI KOMADI TESTOVAA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    @Given("^Sign in with production user and change server to Stage")
    public void changeServerToStage() throws FileNotFoundException {
        SignLauncherView signLauncherView = new SignLauncherView();

        signLauncherView
                .swipeLeftThreeTimes()
                .clickOnLoginButton();

        SignLoginView signLoginView = new SignLoginView();
        signLoginView
                .enterUserName(signLoginView.prodUser)
                .enterPassword()
                .clickOnSignInButton();

//        HomeScreenView homeScreenView = new HomeScreenView();
//        homeScreenView.validateElementsfromHomeScreen()
//                .clickOnSettingsButton();
//
//    SettingsView settingsView = new SettingsView();
//        settingsView.clickOnAboutButton()
//                .clickOnVersionButton()
//                .clickYesOrOk()
//                .chooseStageServer()
//                .clickYesOrOk();

}

    @And ("^User selects document from phone storage")
    public void userSelectDocument () throws FileNotFoundException {
        HomeScreenView homeScreenView = new HomeScreenView();
        homeScreenView.clickSendForSignature();

        SendScreenView sendScreenView = new SendScreenView();
        sendScreenView.clickOnDocumentsButton();
        DocumentsScreen documentsScreen = new DocumentsScreen();
        documentsScreen.clickOnAddDocumentButton()
                .clickOnDocumentsOnThisDevice();

//        Swipe.customSwipeDown();
//        Swipe.customSwipeDown();

               documentsScreen
                .chooseEmptyDocFromThePhone()
                .clickDone();
    }

    @And ("^User enters agreement name and message")
    public void userEntersAgrementNameAndMessage () throws FileNotFoundException {
        MessageScreen messageScreen = new MessageScreen();
        messageScreen.enterAgreementName()
                .enterAgreementMessage()
                .clickOnDone();
    }

    @And ("^User clicks on send button")
    public void userClicksOnSendButton () throws FileNotFoundException {
        SendScreenView sendScreenView = new SendScreenView();
        sendScreenView.clickOnSendAgreementButton();
    }

    @And ("^User clicks on Message button on send page")
    public void userClicksonMessageButtonOnSendPage () throws FileNotFoundException {
        SendScreenView sendScreenView = new SendScreenView();
        sendScreenView.clickOnMessageButton();
    }


//     H  O  M  E       S  C  R  E  E  N      S  T  E  P  S

    @And ("^User clicks on waiting for you")
    public void userClicksonWaitingForYou () throws FileNotFoundException {
        HomeScreenView homeScreenView = new HomeScreenView();
//        homeScreenView.clickOnWaitingForYou();
    }








}
