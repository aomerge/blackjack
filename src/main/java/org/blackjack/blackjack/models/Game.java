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
    private int SussesCode = 2255;
    private int ErrorCode = 2530;
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

    public IPiles getPiles(){
        return piles;
    }

    /* this method generates the next move of a round of the game
    *
    * */
    public void NxtMove(String namePlayer, int move, int countMove  ){
        switch (move){
            case 0:
                Casino.removeBalance(countMove );
                setRemoveMoneyPlayer(countMove);
                piles.setBet(countMove * 2);
                break;
            case 1:
                this.getStand(namePlayer);
                break;
            case 2:
                this.setAddCart(namePlayer);
                break;
            case 3:
                break;
        }
    }

    private void setRemoveMoneyPlayer( int money ){
        try {
            if (players.size() == 0){
                throw  new Exception("Is necesario añadir el set player");
            }
            for (Player player : players){
                if (player.getMoney() < money){
                    throw new Exception("No tienes suficiente dinero");
                }
                player.removeBalance(money);
            }
        }catch (Exception e){
            setLogger(ErrorCode ,e.getMessage(), "setRemoveMoneyPlayer");
        }
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
        String reference = "getStand";
        int SumMoney = this.piles.getPile().stream().mapToInt(Integer::intValue).sum();
        try {
            for (Player player : players){
                if (player.getName().equals(namePlayer)){
                    // player
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

                    if(numberPlayer > 21 && Casino.getSumHand() < numberPlayer || Casino.getSumHand() <= 21 && Casino.getSumHand() > numberPlayer || Casino.getSumHand()<= 21 && numberPlayer > 21){
                        if (getLogger().size() < 2){
                            Casino.setMoney(SumMoney);
                            String messenger = "You lose";
                            setLogger(SussesCode,messenger, reference);
                            break;
                        }
                    }

                    if (numberPlayer == Casino.getSumHand() && numberPlayer <= 21 && Casino.getSumHand() <= 21){
                        String messenger = "Yours Draw";
                        player.setMoney(SumMoney/2);
                        Casino.setMoney(SumMoney/2);
                        setLogger(SussesCode,messenger, reference);
                        break;
                    }

                    if (numberPlayer > Casino.getSumHand() && numberPlayer <= 21 || Casino.getSumHand() > 21 && numberPlayer <= 21 ){
                        if (getLogger().size() < 2){
                            player.setMoney(SumMoney);
                            String messenger = "You win";
                            setLogger(SussesCode,messenger, reference);
                        }
                        break;
                    }

                    break;
                }
            }

        }catch ( Exception e){
            setLogger(ErrorCode,e.getMessage(), reference);
        }
        // const

    }

    private void setLogger(int code, String messenger, String reference){
        Logger.add(String.format("{ Code: %d , messenger: %s, Reference: %s }", SussesCode, messenger,  reference ));
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


    private void setMoneyHomePlayer(){
        Casino.setMoney(100000);
    }

    public void endGame(){}

    public void restartGame(){}

}
