package edu.wit.comp2000.jasonfagerberg.application4;

public class Hand extends Pile
	{
		public Hand(Pile toHand)
		{
			super.addAll(toHand);
		}
		public Card playCard()
		{
			return super.draw();
		}
		public void add(Card card)
		{
			super.add(card);
		}

	}
