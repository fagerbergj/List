package edu.wit.comp2000.jasonfagerberg.application4;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import junit.framework.Assert;

public class PileTest
	{
		String suite = "Hearts";

		@Test
		public void testDraw()
			{
				System.out.println("\n\nTESTING DRAW......");
				Pile pile1 = new Pile();
				Pile pile2 = new Pile();
				System.out.println("NO ELEMENTS WERE ADDED TO PILE1 AND PILE2\nPile1:" + pile1 + "\nPile2:" + pile2);
				Card emptyRemove1 = pile1.draw();
				Card emptyRemove2 = pile2.draw();
				System.out
						.println("CARD DRAWN FROM PILE1: " + emptyRemove1 + "\nCARD DRAWN FROM PILE2: " + emptyRemove2);
				if (pile1.draw() == null)
					{
						System.out.println("Draw...WORKING");
					}
				else
					System.out.println("Draw...BROKEN");
				Assert.assertEquals(true, pile1.draw() == null);
				for (int i = 0; i < 10; i++)
					{
						int num = (int) (Math.random() * 52);
						pile1.add(getCard(num));
						pile2.add(getCard(num));
					}
				System.out
						.println("RANDOM ELEMENTS WERE ADDED TO PILE1 AND PILE2\nPile1:" + pile1 + "\nPile2:" + pile2);
				Card remove1 = pile1.draw();
				Card remove2 = pile2.draw();
				System.out.println("CARD DRAWN FROM PILE1: " + remove1 + "\nCARD DRAWN FROM PILE2: " + remove2);
				if (remove1.equals(remove2))
					{
						System.out.println("Draw...Working");
					}
				else
					System.out.println("Draw...Broken");
				Assert.assertEquals(true, remove1.equals(remove2));
			}

		@Test
		public void testShuffle()
			{
				System.out.println("\n\nTESTING SHUFFLE......");
				Pile pile1 = new Pile();
				Pile pile2 = new Pile();
				for (int i = 0; i < 10; i++)
					{
						int num = (int) (Math.random() * 52);
						pile1.add(getCard(num));
						pile2.add(getCard(num));
					}
				pile1.sort();
				pile2.sort();
				System.out.println("RANDOM ELEMENTS WERE ADDED AND SORTED TO PILE1 AND PILE2\nPile1:" + pile1
						+ "\nPile2:" + pile2);
				Assert.assertEquals(true, pile1.equals(pile2));
				pile1.shuffle();
				pile2.shuffle();
				System.out.println("BOTH PILES WERE SHUFFLED\nPile1:" + pile1 + "\nPile2:" + pile2);
				if (!pile1.equals(pile2))
					{
						System.out.println("Shuffle...Working");
					}
				else
					{
						System.out.println("Shuffle...Broken");
					}
				Assert.assertEquals(false, pile1.equals(pile2));
			}

		@Test
		public void testAdd()
			{
				System.out.println("\n\nTESTING ADD......");
				Pile pile1 = new Pile();
				Pile pile2 = new Pile();
				for (int i = 0; i < 10; i++)
					{
						int num = (int) (Math.random() * 52);
						pile1.add(getCard(num));
						pile2.add(getCard(num));
					}
				System.out
						.println("RANDOM ELEMENTS WERE ADDED TO PILE1 AND PILE2\nPile1:" + pile1 + "\nPile2:" + pile2);
				if (pile1.equals(pile2))
					{
						System.out.println("ADD...WORKING");
					}
				else
					System.out.println("ADD...BROKEN");
				Assert.assertEquals(true, pile1.equals(pile2));
			}

		@Test
		public void testAddAll()
			{
				System.out.println("\n\nTESTING ADD ALL......");
				Pile adder = new Pile();
				for (int i = 0; i < 10; i++)
					{
						int num = (int) (Math.random() * 52);
						adder.add(getCard(num));
					}
				System.out.println("ELEMENTS TO BE ADDED TO EACH PILE\nPile1:" + adder);
				Pile pile1 = new Pile();
				String adderBefore = adder.toString();
				pile1.addAll(adder);
				System.out.println("THOSE ELEMENTS WERE ADDED TO PILE1 AND PILE2\nPile1:" + pile1);
				Assert.assertEquals(true,adderBefore.equals(pile1.toString()));
				if (adderBefore.equals(pile1.toString()))
					{
						System.out.println("ADD ALL...WORKING");
					}
				else
					System.out.println("ADD ALL...BROKEN");

			}


		@Test
		public void testSplit()
			{
				System.out.println("\n\nTESTING SPLIT......");
				Deck pile = new Deck();
				System.out.println("A DECK WAS CREATE\nDECK:" + pile);
				int num = (int) (Math.random() * 20);
				Pile split = pile.split(num);
				System.out.println("THE DECK WAS SPLIT INTO\nSplit1:" + split);
				System.out.println("THE DECK NOW CONTAINS\nDECK:" + pile);
				boolean result = true;
				int numCards = split.getNumberOfCards();
				for (int i = 0; i < numCards; i++)
					{
						Card checkCard = split.draw();
						if (pile.contains(checkCard))
							{
								result = false;
								System.out.println("SPLIT...Broken, REPEATED CARD:" + checkCard);
								Assert.assertEquals(true, result);
								return;
							}
					}
				System.out.println("SPLIT...Working");
				Assert.assertEquals(true, result);
			}

		@Test
		public void testToString()
			{
				System.out.println("\n\nTESTING TO STRING......");
				Pile pile1 = new Pile();
				Pile pile2 = new Pile();
				System.out.println("NO ELEMENTS WERE ADDED TO PILE1 AND PILE2\nPile1:" + pile1 + "\nPile2:" + pile2);
				if (pile1.toString().equals(pile2.toString()))
					{
						System.out.println("TO STRING...WORKING");
					}
				else
					System.out.println("TO STRING...BROKEN");
				Assert.assertEquals(true, pile1.toString().equals(pile2.toString()));

				for (int i = 0; i < 10; i++)
					{
						int num = (int) (Math.random() * 52);
						pile1.add(getCard(num));
						pile2.add(getCard(num));
					}
				System.out
						.println("RANDOM ELEMENTS WERE ADDED TO PILE1 AND PILE2\nPile1:" + pile1 + "\nPile2:" + pile2);
				if (pile1.toString().equals(pile2.toString()))
					{
						System.out.println("TO STRING...WORKING");
					}
				else
					System.out.println("TO STRING...BROKEN");
				Assert.assertEquals(true, pile1.toString().equals(pile2.toString()));
			}

		@Test
		public void testIsEmpty()
			{
				System.out.println("\n\nTESTIN IS EMPTY...");
				Pile pile = new Pile();
				System.out.println("NO ELEMENTS WERE ADDED TO PILE1 \nPile1:" + pile);
				Assert.assertEquals(true, pile.isEmpty());
				if ((pile.isEmpty()))
					{
						System.out.println("IS EMPTY...WORKING");
					}
				else
					System.out.println("IS FULL...BROKEN");
				Assert.assertEquals(true, pile.isEmpty());
				for (int i = 0; i < 10; i++)
					{
						int num = (int) (Math.random() * 52);
						pile.add(getCard(num));
					}
				System.out.println("RANDOM ELEMENTS WERE ADDED TO PILE1\nPile1:" + pile);
				if (!(pile.isEmpty()))
					{
						System.out.println("IS EMPTY...WORKING");
					}
				else
					System.out.println("IS FULL...BROKEN");
				Assert.assertEquals(false, pile.isEmpty());
			}

		@Test
		public void testSort()
			{
				System.out.println("\n\nTESTING SORT......");
				Pile pile1 = new Pile();
				Pile pile2 = new Pile();
				for (int i = 0; i < 10; i++)
					{
						int num = (int) (Math.random() * 52);
						pile1.add(getCard(num));
						pile2.add(getCard(num));
					}
				pile1.shuffle();
				pile2.shuffle();
				System.out.println("RANDOM ELEMENTS WERE ADDED AND SHUFFLED TO PILE1 AND PILE2\nPile1:" + pile1
						+ "\nPile2:" + pile2);
				Assert.assertEquals(false, pile1.equals(pile2));
				pile1.sort();
				pile2.sort();
				System.out.println("BOTH PILES WERE Sorted\nPile1:" + pile1 + "\nPile2:" + pile2);
				if (pile1.equals(pile2))
					{
						System.out.println("Sort...Working");
					}
				else
					{
						System.out.println("Sort...Broken");
					}
				Assert.assertEquals(true, pile1.equals(pile2));
			}

		@Test
		public void testContains()
			{
				System.out.println("\n\nTESTING CONTAINS......");
				Pile pile = new Pile();
				Assert.assertEquals(false, pile.contains(Card.JACK_S));
				pile.add(Card.JACK_S);
				for (int i = 0; i < 10; i++)
					{
						int num = (int) (Math.random() * 52);
						pile.add(getCard(num));
					}
				System.out.println("CARD VALUE 99 AND OTHER RANDOM ELEMENTS WERE ADDED TO PILE1\npile1:" + pile);
				System.out.println("TESTING TO SEE IF PILE1 CONTAINS CARD 99");
				if (pile.contains(Card.JACK_S))
					{
						System.out.println("CONTANS...WORKING");
					}
				else
					System.out.println("CONTANS...BROKEN");
				Assert.assertEquals(true, pile.contains(Card.JACK_S));
			}

		public Card getCard(int index)
			{
				ArrayList<Card> cards = new ArrayList<>();
				for (Card values : Card.values())
					{
						cards.add(values);
					}
				return cards.get(index);
			}

	}
