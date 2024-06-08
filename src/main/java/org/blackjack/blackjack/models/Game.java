package org.blackjack.blackjack.models;

import org.blackjack.blackjack.models.interfac.IDeck;
import org.blackjack.blackjack.models.interfac.IGame;
import org.blackjack.blackjack.models.interfac.IPiles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game implements IGame {

    private int numberOfPlayers;
    Player Casino = new Player("Casino");
    private List<Player> players = new ArrayList<>();
    private IPiles piles = new Piles();
    private IDeck DeckGame ;
    private LinkedList<String> Logger = new LinkedList<>();


    public Game(IDeck deck) {
        this.DeckGame = deck;
        setMoneyHomePlayer();
    }

    public Player getCasino() {
        return Casino;
    }

    public LinkedList<String> getLogger(){
        return Logger;
    }

    @Override
    public void  startGame (){
        try{
            if (players.size() == 0){
                throw  new Exception("Is necesario añadir el set player");
            }

            DeckGame.handoutCard();
            for (int i = 0; i < 2; i++){
                Casino.setHand(DeckGame.getHand().get(i));
            }
            DeckGame.removeHand();
            for (Player player : players){
                this.DeckGame.handoutCard();
                for (int i = 0; i < 2; i++){
                    player.setHand(this.DeckGame.getHand().get(i));
                }
                DeckGame.removeHand();
            }
            Logger.add( 2255 + " Game Started "+ ", Class : startGame"   );

        }catch (Exception e){
            Logger.add(String.format( 2530 +" Error: %s "+ " Class: startGame", e.getMessage() ));
        }
    }

    @Override
    public void setPlayers(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers(){
        return players;
    }

    public List<Carts> getDeckGame(){
        return DeckGame.getDeck();
    }

    public void NxtMove(String namePlayer, String move){
        switch (move){
            case "hit":
                this.getHit(namePlayer);
                break;
            case "stand":
                this.getStand(namePlayer);
                break;
            case "addCart":
                this.setAddCart(namePlayer);
                break;
            case "nextMove":
                this.setNextMove();
                break;
        }
    }

    private void BetPvt(String namePlayer){

    }

    private void NxtMovePvt(String namePlayer, String move){

    }

    public void getAddCart(){
        Deck deck =  new Deck();
        deck.shuffleDeck();

    }

    public void getHit(String namePlayer){
        for (Player player : players){
            if (player.getName().equals(namePlayer)){
                player.setHand(DeckGame.getHand().get(0));
                DeckGame.removeHand();
                if (player.getSumHand() > 21){
                    player.removeBalance(1000);
                    Casino.setMoney(1000);
                    Logger.add( 2255 + " You lose "+ ", Class : getHit" );
                }
            }
        }
    }

    public void getStand  (String namePlayer){
        for (Player player : players){
            if (player.getName().equals(namePlayer)){
                int numberPlayer = player.getSumHand();
                player.removeHandSum();
                // sum cart
                do {
                    if (Casino.getSumHand() >= 21 || numberPlayer > 21) {
                        Casino.removeHandSum();
                        break;
                    }

                    if(DeckGame.getHand().isEmpty()){
                        DeckGame.setHand();
                        Casino.setHand(DeckGame.getHand().getFirst());
                        this.getStand(namePlayer);
                        break;
                    }

                    break;

                } while (Casino.getSumHand() < 17);

                // get winner
                if(numberPlayer > 21 && Casino.getSumHand() < numberPlayer){
                    player.removeBalance(1000);
                    Casino.setMoney(1000);
                    Logger.add( 2255 + " You lose "+ ", Class : getStand" );
                } else if (numberPlayer == Casino.getSumHand()) {
                    System.out.println("You lose "+ player.getMoney());
                    Casino.removeHandSum();
                    Logger.add( 2255 + " Draw "+ ", Class : getStand" );
                } else {
                    Casino.removeBalance(1000);
                    player.setMoney(1000);
                    Logger.add( 2255 + " Messanger:  You win  "+ ", Class : getStand");
                    System.out.println("You win "+ player.getMoney());
                }

            }
        }
    }

    public void setAddCart(String namePlayer){
        DeckGame.setHand();
        for (Player player : players){
            if (player.getName().equals(namePlayer)){
                player.setHand(DeckGame.getHand().get(0));
            }
        }
        DeckGame.removeHand();
    }

    public void setNextMove(){


    }

    private void setMoneyHomePlayer(){
        Casino.setMoney(100000);
    }

    public void createPiles(){}

    public void endGame(){}

    public void restartGame(){}

}
