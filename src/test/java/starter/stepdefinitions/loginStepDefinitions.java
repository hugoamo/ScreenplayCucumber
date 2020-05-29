package starter.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.dashboard.CreditAvailable;
import starter.dashboard.overviewData;
import starter.login.DoLogin;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class loginStepDefinitions {

    String custumer;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("(.*) has an active account")
    public void has_an_active_account(String custumer) {
        this.custumer=custumer;
    }

    @When("he sends their valid credentials")
    public void he_sends_their_valid_credentials() {
        theActorCalled(custumer).attemptsTo(
                NavigateTo.applitoolstheGoHomePage(),
                DoLogin.withCredentials("pepito","algo")
        );
    }

    @Then("he should have access to manage his account")
    public void he_should_have_access_to_manage_his_account() {
        System.out.println("********************"+CreditAvailable.value().answeredBy(theActorInTheSpotlight()));
        System.out.println("--------------------"+ overviewData.CreditAviable().answeredBy(theActorInTheSpotlight()));

        theActorInTheSpotlight().should(
                seeThat("The displayer Credit Available", overviewData.CreditAviable(), equalTo("$17,800"))
        );
    }

}
