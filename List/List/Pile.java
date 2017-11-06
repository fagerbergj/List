package edu.wit.comp2000.jasonfagerberg.application4;

import java.util.ArrayList;
import java.util.Collections;

public class Pile
	{
		ArrayList<Card> cards = new ArrayList<>();
		/**
		 * Default Constructor
		 * Makes empty pile
		 */
		public Pile()
			{
	
			}

		/**
		 * Return the card at the top of pile
		 */
		public Card draw()
			{
				if (!isEmpty())
					{
						return cards.remove(cards.size() - 1);
					}
				return null;
			}

		/**
		 * Shuffle cards in pile
		 */
		public void shuffle()
			{
				for (int i = 0; i < cards.size(); i++)
					{
						int randPos = (int) (Math.random() * cards.size());
						Card temp = cards.get(randPos);
						cards.set(randPos, cards.get(i));
						cards.set(i, temp);
					}

			}

		/**
		 * Add card to bottom of the pile
		 * @param card
		 */
		public void add(Card card)
			{
				cards.add(0,card);
			}

		/**
		 * Add an pile of cards to the pile
		 * top of array list is added to bottom of the pile first
		 * @param toAdd
		 */
		public void addAll(Pile toAdd)
			{
				for (int i = toAdd.getNumberOfCards() - 1; i >= 0; i--)
					{
						add(toAdd.draw());
					}
			}
		

		/**
		 * Add an arrayList of cards to the pile
		 * top of array list is added to bottom of the pile first
		 * @param toAdd
		 */
		public void addAll(ArrayList<Card> toAdd)
			{
				for (int i = toAdd.size() - 1; i >= 0; i--)
					{
						add(toAdd.get(i));
					}
			}

		/**
		 * return a specified amount of random cards from the pile
		 * remove the cards being passed from the pile 
		 * @param numCards
		 * @return Pile of Cards 
		 */
		public Pile split(int numCards)
			{
				shuffle();
				Pile splitPile = new Pile();
				for (int i = 0; i < numCards; i++)
					{
						splitPile.add(draw());
					}
				return splitPile;
			}

		/**
		 * Prints Values of the cards in brackets
		 */
		@Override
		public String toString()
			{
				String res = "[";
				for (int i = 0; i < cards.size(); i++)
					{
						res += cards.get(i).toString();
						if (i + 1 != cards.size())
							{
								res += ", ";
							}
					}
				res += "]";
				return res;

			}

		/**
		 * @return if pile contains no cards
		 */
		public boolean isEmpty()
			{
				return cards.size() == 0;
			}

		/**
		 * Compares toString() values
		 * @param otherPile
		 * @return
		 */
		public boolean equals(Pile otherPile)
			{
				return otherPile.toString().equals(this.toString());
			}

		/**
		 * Sorts pile based on card value
		 */
		public void sort()
			{
				int numCards = cards.size();
				for (int x = 0; x < numCards; x++)
					{
						Card currentCard = cards.get(x);
						for (int i = 0; i < numCards; i++)
							{
								int check = currentCard.compareTo(cards.get(i));
								if (check < 0)
									{
										Card temp = cards.get(i);
										cards.set(i, cards.get(x));
										cards.set(x, temp);
										currentCard = cards.get(x);
									}
							}
					}
			}
		/**
		 * @return Cards array length
		 */
		public int getNumberOfCards()
		{
			return cards.size();
		}

		/**
		 * return if pile contains card
		 */
		public boolean contains(Card check)
		{
			boolean result = false;
			for(int i = 0; i < cards.size(); i++)
				{
					if(cards.get(i).equals(check))
						{
							result = true;
						}
				}
			return result;
		}
		/**
		 * return cards array
		 */
		public ArrayList<Card> toArray()
		{
			return cards;
		}
		/**
		 * Clears Pile
		 */
		public void clear()
		{
			cards.clear();
		}
		/**
		 * Unit test
		 * @param args
		 */
		public static void main(String[] args)
			{
				PileTest tester = new PileTest();
				tester.testToString();
				tester.testAdd();
				tester.testAddAll();
				tester.testDraw();
				tester.testContains();
				tester.testToString();
				tester.testShuffle();
				tester.testSort();
				tester.testSplit();
			}

	}
