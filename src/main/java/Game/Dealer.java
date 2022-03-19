package Game;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private List<String> cards;
    private int total;
    private String action;

    public Dealer(){
        setCards(new ArrayList<>());
    }

    public void startRound(){
        cards.add("A");
        cards.add("2");

    }


    public List<String> getCards() {
        return cards;
    }

    private int getValue(String card){
        switch (card){
            case "A":
                if(total + 11 > 21)return 1;
                else return 11;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "J":
            case "Q":
            case "K":
                return 10;

        }
        return 0;
    }

    public void sumCards(){
        total = 0;
        for(String card: cards){
            total += getValue(card);
        }
    }

    public void play(){
        if(total <= 13) action = "hit";else action = "stand";
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
