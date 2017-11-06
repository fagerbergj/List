package edu.wit.comp2000.jasonfagerberg.application4;


public class Deck extends Pile
	{
		public Deck()
			{
				for (Card values : Card.values())
					{
						super.cards.add(values);
					}
			}
	}
