package steps;

import Game.Dealer;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class Scenario {

    Dealer dealer;

    @Given("a dealer")
    public void dealInitialCards(){
        dealer = new Dealer();
    }

    @When("the round starts")
    public void startRound(){
        dealer.startRound();
    }

    @Then("the dealer should have 2 cards")
    public void countCards(){
        Assert.assertEquals(2, dealer.getCards().size());
    }

    @Given("a {string}")
    public void setAHand(String hand){
        dealer = new Dealer();
        String [] separedHand = hand.split(",");
        dealer.setCards(Arrays.stream(separedHand).toList());
    }

    @When("the dealer sums the cards")
    public void sumsCards(){
        dealer.sumCards();
    }

    @Then("the dealer should have a {int}")
    public void getTotal(int total){
        Assert.assertEquals(total, dealer.getTotal());
    }

    @Given("a hand {int}")
    public void setHandTotal(int total){
        dealer = new Dealer();
        dealer.setTotal(total);
    }

    @When("the dealer plays")
    public void playGame(){
        dealer.play();
    }

    @Then("the dealer should play {word}")
    public void wichAction(String action){
        Assert.assertEquals(action, dealer.getAction());
    }

}
