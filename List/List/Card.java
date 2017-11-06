package edu.wit.comp2000.jasonfagerberg.application4;

import java.util.ArrayList;

/**
 * Write a Card class to represent a playing card. • As usual, provide
 * constructors and accessor methods for all instance variables, and a
 * toString() method for displaying the card. Note that the instance variables
 * for Card typically can't change so they should final. • Have it implement
 * Comparable (which will require you to write a compareTo() method) so it will
 * be easier later to compare cards. You should also override the equals()
 * method. • You may want to use enums for face/rank, suit, color, etc.
 */
public enum Card {
	TWO_C(2, "Clubs"), THREE_C(3, "Clubs"), FOUR_C(4, "Clubs"), FIVE_C(5, "Clubs"), SIX_C(6, "Clubs"), SEVEN_C(7,
			"Clubs"), EIGHT_C(8, "Clubs"), NINE_C(9, "Clubs"), TEN_C(10,
					"Clubs"), JACK_C(11, "Clubs"), QUEEN_C(12, "Clubs"), KING_C(13, "Clubs"), ACE_C(14, "Clubs"),

	TWO_H(2, "Hearts"), THREE_H(3, "Hearts"), FOUR_H(4, "Hearts"), FIVE_H(5, "Hearts"), SIX_H(6, "Hearts"), SEVEN_H(7,
			"Hearts"), EIGHT_H(8, "Hearts"), NINE_H(9, "Hearts"), TEN_H(10,
					"Hearts"), JACK_H(11, "Hearts"), QUEEN_H(12, "Hearts"), KING_H(13, "Hearts"), ACE_H(14, "Hearts"),

	TWO_S(2, "Spades"), THREE_S(3, "Spades"), FOUR_S(4, "Spades"), FIVE_S(5, "Spades"), SIX_S(6, "Spades"), SEVEN_S(7,
			"Spades"), EIGHT_S(8, "Spades"), NINE_S(9, "Spades"), TEN_S(10,
					"Spades"), JACK_S(11, "Spades"), QUEEN_S(12, "Spades"), KING_S(13, "Spades"), ACE_S(14, "Spades"),

	TWO_D(2, "Diamonds"), THREE_D(3, "Diamonds"), FOUR_D(4, "Diamonds"), FIVE_D(5, "Diamonds"), SIX_D(6,
			"Diamonds"), SEVEN_D(7, "Diamonds"), EIGHT_D(8, "Diamonds"), NINE_D(9, "Diamonds"), TEN_D(10,
					"Diamonds"), JACK_D(11,
							"Diamonds"), QUEEN_D(12, "Diamonds"), KING_D(13, "Diamonds"), ACE_D(14, "Diamonds");

	private int Value;
	private String Suite;

	private Card(int value, String suite)
		{
			Value = value;
			Suite = suite;
			return;
		}

	public int getCardValue()
		{
			return Value;
		}

	public String getCardSuite()
		{
			return Suite;
		}

	public int person1()
		{
			return Value;
		}

	public int person2()
		{
			return Value;
		}

	public int compareTo(Card person1, Card person2)
		{
			int v = person1.getCardValue() - person2.getCardValue();
			if (v > 0)
				{
					return 1;
				}
			else if (v < 0)
				{
					return -1;
				}
			else
				{
					return 0;
				}
		}

	public boolean equals(Card otherCard)
		{
			return this.getCardValue() == otherCard.getCardValue()
					&& this.getCardSuite().equals(otherCard.getCardSuite());
		}
	public boolean equalValues(Card otherCard)
	{
		return this.getCardValue() == otherCard.getCardValue();
	}

	@Override
	public String toString()
		{
			String result = String.valueOf(Value);
			if (Value == 11)
				{
					result = "JACK";
				}
			else if (Value == 12)
				{
					result = "QUEEN";
				}
			else if (Value == 13)
				{
					result = "KING";
				}
			else if (Value == 14)
				{
					result = "ACE";
				}

			return  result + " OF " + getCardSuite();
		}
	// public String toString()
	// {
	// String result;
	// result = "Player cards are ";
	// for (Card values : Card.values())
	// {
	// result += "The enum " + values.name();
	// result += " has a value of " + values.getCardValue();
	// result += " and the suit of " + values.getCardSuite();
	// }
	// return result;
	//
	// }

	public static void main(String[] args)
		{
			ArrayList<Card> cards = new ArrayList<>();
			for (Card values : Card.values())
				{
					cards.add(values);
				}
		}
}
