package org.blackjack.blackjack.models;

import org.blackjack.blackjack.models.interfac.IDeck;
import org.blackjack.blackjack.models.interfac.IGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Game implements IGame {

    private int numberOfPlayers;
    Player HomePlayer = new Player("Home");
    private List<Player> players = new ArrayList<>();
    private List<Piles> piles = new ArrayList<>();
    private Deck DeckGame ;
    private LinkedList<String> Logger = new LinkedList<>();


    public Game(Deck deck) {
        this.DeckGame = deck;
        setMoneyHomePlayer();
    }

    public Player getHomePlayer() {
        return HomePlayer;
    }

    public LinkedList<String> getLogger(){
        return Logger;
    }

    @Override
    public String startGame () {
        try{
            if (players.size() == 0){
                throw  new Exception("Is necesario añadir el set player");
            }
            Player player =  players.get(0);
            player.getHand();
            System.out.println(player.getHand());
            return "Game Start";
        }catch (Exception e){
            Logger.add(e.getMessage());
            return "No se pudo inicializar el juego checka el logger" ;
        }
    }


    @Override
    public void setPlayers(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers(){
        return players;
    }

    public void addCart(){
        Deck deck =  new Deck();
        deck.shuffleDeck();

    }

    private void setDeckHomePLayer (){

    }

    private void setMoneyHomePlayer(){
        HomePlayer.setMoney(100000);
    }

    public void applyRules(){}

    public void createPiles(){}

    public void endGame(){}

    public void restartGame(){}

}
