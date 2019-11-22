package cucumber.cucumberTests;

import cucumber.api.java.en.When;
import pages.sign.completedScreen.CompletedScreen;
import pages.sign.getSignatureInPersonScreen.GetSignatureInPersonScreen;
import pages.sign.getSignatureInPersonScreen.RecipientsOnGSIPScreen;
import pages.sign.homeScreen.HomeScreen;
import pages.sign.launcherScreen.SignLauncherScreen;
import pages.sign.loginScreen.SignLoginScreen;
import pages.sign.loginScreen.Users;
import pages.sign.sendForSignatureScreen.*;
import pages.sign.settingsScreen.SettingsScreen;
import pages.sign.waitingForOthersScreen.WaitingForOthersScreen;
import pages.sign.waitingForYouScreen.WaitingForYouScreen;
import core.json.parsers.AppiumReadJsonResults;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import service.organization.User;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.getAndroidJasonResults;

public class SignStepDefinitions {

    private Users users = new Users();
    AppiumReadJsonResults appiumReadJsonResults = new AppiumReadJsonResults();

    // L O G       I N       W I T H       D I F F E R E N T      S H A R D S


    @And("^Log in with user from \"([^\"]*)\"$")
    public void logIn(String arg0) throws FileNotFoundException, InterruptedException {
        new SignLauncherScreen().dismissUpdateMessageIfPresent();
        new SignLoginScreen()
                .enterUserName(users.getUser(arg0))
                .enterPassword()
                .clickOnSignInButton();
    }

    @When("^User is logged in as sender from shard \"([^\"]*)\"$")
    public void logInToCheckComplete(String arg0) throws FileNotFoundException, InterruptedException {
        new SignLauncherScreen().dismissUpdateMessageIfPresent();
        new SignLoginScreen()
                .enterUserName(users.getUser(arg0))
                .enterPassword()
                .clickOnSignInButton();
    }


    // R   E   C   I   P   I   E   N   T   S


    @And("^Click on Add Me button$")
    public void clickOnAddMeButton() throws FileNotFoundException {
        new RecipientsScreen()
                .swipeToFindAddMeAndRecipientNameField()
                .clickOnAddMeButton();
    }

    @And("^Click on recipients button on send page$")
    public void clickOnRecipientsButtonOnSednPage() throws FileNotFoundException {
        new SendForSignatureScreen().clickOnRecipientsButton();
    }

    @And("^Enter recipient from shard: \"([^\"]*)\"$")
    public void enterRecipientFromShared(String arg0) throws FileNotFoundException {
        new RecipientsScreen()
                .swipeToFindAddMeAndRecipientNameField()
                .addRecipient(users.getUser(arg0));
    }

    @And("^Enter in person signer from shard: \"([^\"]*)\"$")
    public void enterInPersonSignerFromShard(String arg0) throws FileNotFoundException {
        new RecipientsOnGSIPScreen()
                .addInPersonSigner(users.getUser(arg0));

    }

    @And("^Enter additional recipient from shard: \"([^\"]*)\"$")
    public void enterAdditionalRecipientFromShard(String arg0) throws FileNotFoundException {
        new RecipientsOnGSIPScreen()
                .swipeToFindAddMeAndRecipientNameField();
        new RecipientsOnGSIPScreen()
                .addAdditionalSigner(users.getUser(arg0));

    }



    // R   O   L   E   S                  R   O   L   E   S

    @And("^Assign delegator to approver role to the recipient from shard: \"([^\"]*)\"$")
    public void assignDelegatorToApproverRole(String arg0) throws FileNotFoundException {
        new RecipientsScreen().setDelegatorToApprover(users.getUser(arg0));
    }


    @And("^Assign delegator to signer role to the recipient from shard: \"([^\"]*)\"$")
    public void assignDelegatorToSignerRole(String arg0) throws FileNotFoundException {
        new RecipientsScreen().setDelegatorToSigner(users.getUser(arg0));
    }


    @And("^Assign Approver role to the recipient from shard: \"([^\"]*)\"$")
    public void assignApproverRoleToRecipient(String arg0) throws FileNotFoundException {
        new RecipientsScreen().setRoleToApprover(users.getUser(arg0));
    }


    @And("^Click on done on Recipients Page$")
    public void clickDoneOnRecipientsPage() throws FileNotFoundException {
        new RecipientsScreen().clickDone();
    }



    //     S  E  T         E  N  V  I  R  O  N  M  E  N  T



    @Given("^User sets the environment$")
    public void setServer() throws FileNotFoundException {
        if(((getAndroidJasonResults().getEnvironment()).equalsIgnoreCase("prod"))) {
            new SignLauncherScreen()
                    .dismissUpdateMessageIfPresent()
                    .clickRightArrowButtonToGetToSignInButton()
                    .clickOnLoginButton();
        } else {
            new SignLauncherScreen()
                    .clickRightArrowButtonToGetToSignInButton()
                    .clickOnLoginButton();
            new SignLoginScreen()
                    .enterUserName(users.getProdUser())
                    .enterPassword()
                    .clickOnSignInButton();
            new HomeScreen()
                    .clickOnSettingsButton();
            new SettingsScreen()
                    .clickOnAboutButton()
                    .clickOnVersionButton()
                    .clickYesOrOk();
            if (((getAndroidJasonResults().getEnvironment()).equalsIgnoreCase("stage"))) {
                new SettingsScreen().chooseStageServer().clickYesOrOk();
            }
            if (((getAndroidJasonResults().getEnvironment()).equalsIgnoreCase("preview"))) {
                new SettingsScreen().clickYesOrOk();
            }
        }
    }



    // S  E  N  D      S   C   R   E   E   N       S   T   E   P   S

    @And("^Turn off complete in order listed$")
    public void turnOffCompleteInOrderListed() throws FileNotFoundException {
        RecipientsScreen recipientsScreen = new RecipientsScreen();
        recipientsScreen.clickOnCompleteInOrderListed();
    }

    @Then("^Verify message screen place holders$")
    public void verifyMessageScreenPlaceHolders() {
        new SendForSignatureScreen().clickOnMessageButton();
        new MessageScreen().verifyMessageScreenPlaceHolders();
    }

    @Then("^Verify message section$")
    public void verifyMessageSection() {
        new SignScreen().verifyMessageSection().clickDone();

    }
    @And("^Verify that document IS under \"([^\"]*)\" section$")
    public void verifyThatDocumentIsUnderWantedSection(String arg0) {
        new WaitingForOthersScreen().verifyThatDocumentIsUnderWantedSection(arg0);
    }

    @And("^Verify that document is NOT in \"([^\"]*)\" screen$")
    public void verifyThatAgreementIsNotUnderToDelegateSection(String arg0) {
        new WaitingForYouScreen().verifyThatDocumentIsNOTInCurrentScreen(arg0);
    }


    @And("^Select document from phone storage$")
    public void userSelectDocument() throws FileNotFoundException, InterruptedException {
        new SendForSignatureScreen().clickOnDocumentsButton();
        new DocumentsScreen()
                .dismissScanDocumentsAndAttachPopUp()
                .clickOnAddDocumentButton()
                .clickOnAllowOnPopUp()
                .clickOnDocumentsOnThisDevice()
                .swipUpUntilYouFindEmptyDoc()
                .chooseTestDocFromPhoneStorage()
                .clickDone();
    }

    @And("^Enter agreement name and message$")
    public void userEntersAgrementNameAndMessage() throws FileNotFoundException {
        new SendForSignatureScreen().clickOnMessageButton();
        new MessageScreen()
                .enterAgreementName()
                .enterAgreementMessage()
                .clickDone();

    }

    @And("^Click on send button$")
    public void userClicksOnSendButton() throws FileNotFoundException {
        new SendForSignatureScreen().clickOnSendAgreementButton();
    }

    @And("^Click on send button on get signature in person$")
    public void clickOnSendOnGetSignatureInPerson() throws FileNotFoundException {
        new GetSignatureInPersonScreen().clickOnSendButtonOnGetSignatureInPerson();
    }


//     H  O  M  E       S  C  R  E  E  N      S  T  E  P  S

    @And("^Click on waiting for you$")
    public void userClicksonWaitingForYou() throws FileNotFoundException {
        new HomeScreen().clickOnWaitingForYou();
    }

    @Then("^Click on Completed and verify that the document is in completed folder$")
    public void verifyAgreementIsInCompleted() throws FileNotFoundException {
        new HomeScreen().clickOnCompleted();
        new CompletedScreen()
                .waitingForCompletedScreenToLoad()
                .clickOnSearchbuttonAndEnterAgreementName()
                .verifyThatAgreementIsInCurrentSection();
    }

    @Then("^Agreement should be in completed folder$")
    public void thenAgreementIsInCompletedFolder() throws FileNotFoundException {
        new HomeScreen().clickOnCompleted();
        new CompletedScreen()
                .waitingForCompletedScreenToLoad()
                .clickOnSearchbuttonAndEnterAgreementName()
                .verifyThatAgreementIsInCurrentSection();
    }



    @And("^Click on waiting for others$")
    public void clickOnWaitingForOthers() throws FileNotFoundException {
        new HomeScreen().clickOnWaitingForOthers();
    }

    @Then("^Verify that document is successfully sent$")
    public void verifyDocumentIsSuccessfullySent() throws FileNotFoundException {
        new HomeScreen().clickOnWaitingForOthers();
        new WaitingForOthersScreen()
                .waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen()
                .clickOnSearchbuttonAndEnterAgreementName()
                .verifyThatAgreementIsInCurrentSection();
    }


    @And("^Click on send for signature$")
    public void clickOnSendForSignature() throws FileNotFoundException {
        new HomeScreen().clickSendForSignature();
    }

    @And("^Click on get signature in person$")
    public void clickOnGetSignatureInPerson() throws FileNotFoundException {
        new HomeScreen().clickOnGetSignatureInPerson();
    }

    @And("^Sign out - from home screen$")
    public void signOut() throws FileNotFoundException {
        new HomeScreen()
                .clickOnSettingsButton();
        new SettingsScreen()
                .clickOnSignOut()
                .clickYesOrOk();
    }


    // W  A  I  T  I  N  G        F  O  R         Y  O  U

    @And("^Select agreement you want to delegate and click on it$")
    public void findAgreementAndClickOnIt() throws FileNotFoundException {
        new WaitingForYouScreen()
                .waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen()
                .clickOnSearchbuttonAndEnterAgreementName()
                .clickOnAgreementOnWaitingForYouPage();
    }

    @And("^Select agreement you want to sign and click on it$")
    public void findAgreementToSignAndClickOnIt() throws FileNotFoundException {
        new WaitingForYouScreen()
                .waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen()
                .clickOnSearchbuttonAndEnterAgreementName()
                .clickOnAgreementOnWaitingForYouPage();
    }

    @And("^Log in with user from \"([^\"]*)\" and sign, then log out$")
    public void logInAndSign(String arg0) throws FileNotFoundException, InterruptedException {
        new SignLauncherScreen().dismissUpdateMessageIfPresent();
        new SignLoginScreen()
                .enterUserName(users.getUser(arg0))
                .enterPassword()
                .clickOnSignInButton();
        new HomeScreen().clickOnWaitingForYou();
        new WaitingForYouScreen()
                .waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen()
                .clickOnSearchbuttonAndEnterAgreementName()
                .clickOnAgreementOnWaitingForYouPage();
        new SignScreen()
                .clickOnStartButton()
                .clickOnSignatureField()
//              .clickSecondTimeOnSignatureFieldtoEdit()
//               .writeTheNameOfSigner()
                .clickOnKeyboardIcon()
                .clickOnApplyButtonOnEditSignatureScreen()
                .clickOnFinishButton()
                .clickOnTapToSign();
        new WaitingForYouScreen()
                .waitingForWFYScrenToLoadAfterSigning()
                .clickBackButton();
        new HomeScreen()
                .clickOnSettingsButton();
        new SettingsScreen()
                .clickOnSignOut()
                .clickYesOrOk();
    }

    @And("^Log in with user from \"([^\"]*)\" and and delegate to user from \"([^\"]*)\"$")
    public void logInAndSign(String arg0, String arg1) throws FileNotFoundException, InterruptedException {
        new SignLauncherScreen().dismissUpdateMessageIfPresent();
        new SignLoginScreen()
                .enterUserName(users.getUser(arg0))
                .enterPassword()
                .clickOnSignInButton();
        new HomeScreen().clickOnWaitingForYou();
        new WaitingForYouScreen()
                .waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen()
                .clickOnSearchbuttonAndEnterAgreementName()
                .clickOnAgreementOnWaitingForYouPage();
        new DelegateThisDocumentScreen()
                .verifyTextOnDelegateThisDocumentWebView()
                .enterDelegateeMail(users.getUser(arg1))
                .enterDelegateeMessage()
                .clickOnDelegateButton();
        new PostSignScreen()
                .waitingForPostSignScreenToLoad()
                .isActualPostDelegationMessageAsExpectedSigning(users.getUser(arg0))
                .backToHomePage();
        new HomeScreen()
                .clickOnSettingsButton();
        new SettingsScreen()
                .clickOnSignOut()
                .clickYesOrOk();
    }


    @And("^Log in with user from \"([^\"]*)\" and approve, then log out$")
    public void logInAndApprove(String arg0) throws FileNotFoundException, InterruptedException {
        new SignLauncherScreen().dismissUpdateMessageIfPresent();
        new SignLoginScreen()
                .enterUserName(users.getUser(arg0))
                .enterPassword()
                .clickOnSignInButton();
        new HomeScreen().clickOnWaitingForYou();
        new WaitingForYouScreen()
                .waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen()
                .clickOnSearchbuttonAndEnterAgreementName()
                .clickOnAgreementOnWaitingForYouPage();
        new ApprovalScreen().approveAgreement();
        new HomeScreen()
                .clickOnSettingsButton();
        new SettingsScreen()
                .clickOnSignOut()
                .clickYesOrOk();
    }





    @And("^Select agreement you want to Approve and click on it$")
    public void findAgreementToApproveAndClickOnIt() throws FileNotFoundException {
        new WaitingForYouScreen()
                .waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen()
                .clickOnSearchbuttonAndEnterAgreementName()
                .clickOnAgreementOnWaitingForYouPage();
    }

    @And("^Click on Delegate button on agreements screen$")
    public void clickOnDelegateButtonOnAgreementScreen() throws FileNotFoundException {
        new AgreementSummaryScreen().clickOnSignButton();
    }

    @And("^Click on Approve button on agreements screen$")
    public void clickOnApproveeButtonOnAgreementScreen() throws FileNotFoundException {
        new ApprovalScreen().approveAgreement();
    }

    @And("^Sign the agreement$")
    public void signTheAgreement() throws FileNotFoundException {
        new SignScreen()
                .clickOnStartButton()
                .clickOnSignatureField()
//              .clickSecondTimeOnSignatureFieldtoEdit()
//               .writeTheNameOfSigner()
                .clickOnKeyboardIcon()
                .clickOnApplyButtonOnEditSignatureScreen()
                .clickOnFinishButton()
                .clickOnTapToSign();
        new WaitingForYouScreen()
                .waitingForWFYScrenToLoadAfterSigning()
                .clickBackButton();
    }

    @And("^Sign the agreement when agreement automatically loads for signing in paralel workflow$")
    public void signTheAgreementAutomaticLoadOfAgreement() throws FileNotFoundException {
        new SignScreen()
                .clickOnStartButton()
                .clickOnSignatureField()
                .clickOnKeyboardIcon()
                .clickOnApplyButtonOnEditSignatureScreen()
                .clickOnFinishButton()
                .clickOnTapToSign();
    }

    @And("^Sign the agreement in in person signing flow$")
    public void signTheAgreementInPersonFlow() throws FileNotFoundException {
        new GetSignatureInPersonScreen()
                .clickOnOKProceedOnDialog()
                .clickOnOKProceedOnDialog();
        new SignScreen()
                .clickOnStartButton()
                .clickOnSignatureField()
                .clickOnKeyboardIcon()
                .clickOnApplyButtonOnEditSignatureScreen()
                .clickOnFinishButton()
                .clickOnTapToSign();
    }

    @And("^Sign the agreement in in person signing flow as user \"([^\"]*)\" and verify messages$")
    public void signTheAgreementInPersonFlowAndVerifyMessages(String arg0) throws FileNotFoundException {
        new GetSignatureInPersonScreen()
                .verifyPleasePassTheDeviceMessage(users.getUser(arg0))
                .clickOnOKProceedOnDialog()
                .verifyPleasePassTheDeviceMessage(users.getUser(arg0))
                .clickOnOKProceedOnDialog();
        new SignScreen()
                .clickOnStartButton()
                .clickOnSignatureField()
                .clickOnKeyboardIcon()
                .clickOnApplyButtonOnEditSignatureScreen()
                .clickOnFinishButton()
                .clickOnTapToSign();
    }


    @And("^Approve the agreement in in person signing flow$")
    public void approveAgreementInPersonFlow() throws FileNotFoundException {
        new GetSignatureInPersonScreen()
                .clickOnOKProceedOnDialog()
                .clickOnOKProceedOnDialog();
        new ApprovalScreen()
                .approveAgreementInPersonFlow();
        // used when user external
        // .enterYourInformationInPersonFlow();
    }

    @And("^Approve the agreement as Sender in parallel approval flow$")
    public void approveAgreementAsSender() throws FileNotFoundException {
        new ApprovalScreen()
                .approveAgreementInPersonFlow();
        // used when user external
        // .enterYourInformationInPersonFlow();
    }




    @And("^Delegate agreement for approval to the recipient from shard: \"([^\"]*)\"$")
    public void delegateAgreementForApproval(String arg0) throws FileNotFoundException {
        new DelegateThisDocumentScreen()
                .enterDelegateeMail(users.getUser(arg0))
                .enterDelegateeMessage()
                .clickOnDelegateButton();
        new PostSignScreen()
                .waitingForPostSignScreenToLoad()
                .isActualPostDelegationMessageAsExpectedApproval(users.getUser(arg0))
                .backToHomePage();
    }


    @And("^Delegate agreement for signing to the recipient from shard: \"([^\"]*)\"$")
    public void delegateAgreementForSigning(String arg0) throws FileNotFoundException {
        new DelegateThisDocumentScreen()
                .verifyTextOnDelegateThisDocumentWebView()
                .enterDelegateeMail(users.getUser(arg0))
                .enterDelegateeMessage()
                .clickOnDelegateButton();
        new PostSignScreen()
                .waitingForPostSignScreenToLoad()
                .isActualPostDelegationMessageAsExpectedSigning(users.getUser(arg0))
                .backToHomePage();
    }

    // W  A  I  T  I  N  G     F  O  R     O  T  H  E  R  S
    @And("^Click on back button on waiting for others screen$")
    public void clickOnBackButtonOnWaitingForOthersScreen() throws FileNotFoundException {
        new WaitingForOthersScreen().clickBackButton();
    }

    @And("^Select signer on WFO screen in paralel workflow - from shard :\"([^\"]*)\"$")
    public void selectSignerFromShard (String arg0) throws FileNotFoundException {
        new WaitingForOthersScreen().clickOnSpecificUser(users.getUser(arg0));
    }

    @And("^Verify that sign/delegate/approve buttons are not present$")
    public void verifyThatSignDelegateApproveButtonsAreNotPresent() throws FileNotFoundException {
        new WaitingForOthersScreen()
                .waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen();
        new WaitingForYouScreen().clickOnSearchbuttonAndEnterAgreementName();
        new WaitingForOthersScreen().verifyThatSignButtonIsNotPresent();
    }



}




