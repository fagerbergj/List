package edu.wit.comp2000.jasonfagerberg.application4;

import java.util.ArrayList;

public class Game
	{
		static int turnNum = 0;

		public static void round(ArrayList<Player> players, ArrayList<Card> pot)
			{
				System.out.println("\nROUND NUMBER " + turnNum);
				turnNum++;

				ArrayList<Player> currentPlayers = new ArrayList<>();

				// Players play card
				for (int i = 0; i < players.size(); i++)
					{
						currentPlayers.add(players.get(i));
						currentPlayers.get(i).play();
						System.out.println(
								"PLAYER " + players.get(i).getID() + " PLAYED A " + players.get(i).getLastCard());

					}

				// find highest card
				Card highestCard = currentPlayers.get(0).getLastCard();
				for (int i = 0; i < currentPlayers.size(); i++)
					{
						if (highestCard.compareTo(highestCard, currentPlayers.get(i).getLastCard()) < 0)
							{
								highestCard = players.get(i).getLastCard();
							}
					}

				System.out.println("THE HIGHEST VALUE CARD PLAYED WAS " + highestCard);

				// add players with the highest card to array list
				for (int i = 0; i < currentPlayers.size(); i++)
					{
						if (!(currentPlayers.get(i).getLastCard().equalValues(highestCard)))
							{
								pot.addAll(currentPlayers.get(i).getPlayingField());
								currentPlayers.get(i).getPlayingField().clear();
								currentPlayers.remove(i);
								i--;
							}
					}
				// If there is war call the war
				if (currentPlayers.size() > 1)
					{
						for (int i = 0; i < currentPlayers.size(); i++)
							{
								System.out.println("PLAYER " + currentPlayers.get(i).getID() + " IS GOING TO WAR");
								currentPlayers.get(i).playWar();
							}
						round(currentPlayers, pot);
					}
				else
					{
						Player winner = currentPlayers.get(0);
						pot.addAll(winner.getPlayingField());
						winner.getPlayingField().clear();
						System.out.println("PLAYER " + currentPlayers.get(0).getID() + " WON " + pot.size() + " CARDS");
						winner.getHand().addAll(pot);
						pot.clear();
					}

				// find out who wins

			}

		public static void main(String[] args)
			{

				int numOfPlayers = 4;
				Deck deck = new Deck();
				ArrayList<Player> players = new ArrayList<>();

				// create all players
				for (int i = 0; i < numOfPlayers; i++)
					{
						players.add(new Player("Player " + i + " ", i));
					}

				// split the deck and assign to player's hand
				int split = (int) (52 / players.size());
				for (int i = 0; i < players.size(); i++)
					{
						players.get(i).setHand(new Hand(deck.split(split)));
					}

				// main loop
				boolean noWinner = true;
				while (noWinner)
					{
						// see if anyone loses
						for (int i = 0; i < players.size(); i++)
							{
								// remove losers
								if (players.get(i).getHand().getNumberOfCards() == 0)
									{
										System.out.println("PLAYER " + players.get(i).getID() + " HAS LOST");
										players.remove(i);
										i--;
									}
							}
						round(players, new ArrayList<Card>());
						// see if anyone won
						if (players.size() == 1)
							{
								System.out.println("PLAYER " + players.get(0).getID() + " HAS WON THE GAME");
								noWinner = false;
							}
					}
			}

	}
