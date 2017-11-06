package edu.wit.comp2000.jasonfagerberg.application4;

import java.util.ArrayList;

public class Player
	{

		private String name;
		private int ID;
		Hand hand;
		ArrayList<Card> playingField;

		public Player()
			{

			}

		public Player(String name, int ID)
			{
				this.name = name;
				this.ID = ID;
				this.hand = new Hand(new Pile());
				this.playingField = new ArrayList<>();
			}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public int getID()
			{
				return ID;
			}

		public void setID(int iD)
			{
				ID = iD;
			}

		public Hand getHand()
			{
				return hand;
			}

		public void setHand(Hand hand)
			{
				this.hand = hand;
			}

		public ArrayList<Card> getPlayingField()
			{
				return this.playingField;
			}

		public void play()
			{
				if(hand.getNumberOfCards() !=0)
				this.playingField.add(this.hand.playCard());
			}

		public void playWar()
			{
				int num;
				if (getHandSize() > 3)
					{
						num = 3;
					}
				else
					{
						num = hand.getNumberOfCards() - 1;
					}
				for (int i = 0; i < num; i++)
					{
						this.playingField.add(this.hand.playCard());
					}
			}

		public Boolean hasWon()
			{
				return hand.getNumberOfCards() == 52;
			}

		public Card getLastCard()
			{
				return playingField.get(playingField.size() - 1);
			}

		public int getHandSize()
			{
				return hand.getNumberOfCards();
			}

		@Override
		public String toString()
			{
				return "Player ID: " + ID + " Player Name: " + name;

			}

	}
