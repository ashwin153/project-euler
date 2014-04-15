package com.ashwin.euler.problems;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem054 {

	//0,0,2,2,12,36,103,845,1000
	private static final char[] suits = {'H', 'C', 'S', 'D'};
	private static final char[] values = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};

	public static void main(String[] args) throws IOException {
		new Problem054();
	}
	
	public Problem054() throws IOException {
		Scanner scanner = new Scanner(new File("assets/problem054.txt"));
		int counter = 0;
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] cards = line.split(" ");
			
			Card[] c1 = new Card[5];
			Card[] c2 = new Card[5];
			for(int i = 0; i < c1.length; i++) {
				c1[i] = new Card(cards[i+0].toCharArray());
				c2[i] = new Card(cards[i+5].toCharArray());
			}
			
			Hand h1 = new Hand(c1);
			Hand h2 = new Hand(c2);
			
			if(h1.compareTo(h2) > 0)
				counter++;
		}
		
		System.out.println(counter);
		scanner.close();
	}
	
	private class Hand implements Comparable<Hand> {
		
		private Card[] _cards;
		
		public Hand(Card[] cards) {
			_cards = cards;
		}
		
		public int compareTo(Hand oth) {
			Map<Rank, Integer> r1 = getRankMap();
			Map<Rank, Integer> r2 = oth.getRankMap();
						
			Value v1 = getValue(r1);
			Value v2 = oth.getValue(r2);
			
			int compare = v1.compareTo(v2);
			if(compare != 0) {
				return compare;
			} else {
				Iterator<Rank> iter1 = r1.keySet().iterator();
				Iterator<Rank> iter2 = r2.keySet().iterator();
				

				while(iter1.hasNext() && iter2.hasNext()) {
					Rank val1 = iter1.next();
					Rank val2 = iter2.next();

					if(val1 != val2)
						return val1.compareTo(val2);
				}
				
				return 0;
			}
		}
		
		public Value getValue(Map<Rank, Integer> map) {
			boolean isFlush = isFlush();
			boolean isStraight = isStraight(map);
									
			if(isStraight && isFlush && map.containsKey(Rank.ACE))
				return Value.ROYAL_FLUSH;
			else if(isStraight && isFlush)
				return Value.STRAIGHT_FLUSH;
			else if(map.containsValue(4))
				return Value.FOUR_OF_KIND;
			else if(map.containsValue(2) && map.containsValue(3))
				return Value.FULL_HOUSE;
			else if(isFlush)
				return Value.FLUSH;
			else if(isStraight)
				return Value.STRAIGHT;
			else if(map.containsValue(3))
				return Value.THREE_OF_KIND;
			else if(map.containsValue(2) && map.size() == 3)
				return Value.TWO_PAIR;
			else if(map.containsValue(2))
				return Value.ONE_PAIR;
			else
				return Value.HIGH_CARD;
		}
		//0,0,2,2,18,36,100,842,1000
		//0,0,2,2,12,36,103,845,1000

		// All cards are the same suit
		public boolean isFlush() {
			Suit s1 = _cards[0].getSuit();
			for(int i = 1; i < _cards.length; i++)
				if(_cards[i].getSuit().compareTo(s1) != 0)
					return false;
			return true;
		}

		// All cards are in order
		public boolean isStraight(Map<Rank, Integer> rankMap) {
			if(rankMap.size() != 5)
				return false;
			Iterator<Rank> iter = rankMap.keySet().iterator();
			int first = iter.next().ordinal();
			while(iter.hasNext())
				if(iter.next().ordinal() != --first)
					return false;
			return true;
		}
	
		public Map<Rank, Integer> getRankMap() {
			Map<Rank, Integer> rankMap = new HashMap<Rank, Integer>();
			for(Card card : _cards) {
				Rank rank = card.getRank();
				if(rankMap.containsKey(rank))
					rankMap.put(rank, rankMap.get(rank) + 1);
				else
					rankMap.put(rank, 1);
			}
			
			ValueComparator vc = new ValueComparator(rankMap);
			TreeMap<Rank, Integer> map = new TreeMap<Rank, Integer>(vc);
			map.putAll(rankMap);
			return map;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < _cards.length; i++)
				sb.append(_cards[i] + ",");
			return sb.toString();
		}
	}
	
	private class Card {
		
		private Suit _suit;
		private Rank _rank;
		
		public Card(Suit suit, Rank rank) {
			_suit = suit;
			_rank = rank;
		}
		
		public Card(char[] values) {
			_rank = Rank.fromChar(values[0]);
			_suit = Suit.fromChar(values[1]);
		}
		
		public Suit getSuit() {
			return _suit;
		}
		
		public Rank getRank() {
			return _rank;
		}
		
		@Override
		public String toString() {
			return _rank.toString() + " of " + _suit.toString();
		}
	}
	
	private enum Value {
		HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_KIND, STRAIGHT, FLUSH, 
		FULL_HOUSE, FOUR_OF_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH;
	}
	
	private enum Suit {
		CLUB('C'), DIAMOND('D'), HEART('H'), SPADE('S');
		
		private char _suit;
		
		private Suit(char suit) {
			_suit = suit;
		}
		
		public char getSuit() {
			return _suit;
		}
		
		public static Suit fromChar(char value) {
			for(Suit suit : Suit.values())
				if(suit.getSuit() == value)
					return suit;
			return null;
		}
	}
	
	private enum Rank {
		TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), 
		EIGHT('8'), NINE('9'), TEN('T'), JACK('J'), QUEEN('Q'), KING('K'), ACE('A');
		
		private char _rank;
		
		private Rank(char rank) {
			_rank = rank;
		}
		
		public char getRank() {
			return _rank;
		}
		
		public static Rank fromChar(char value) {
			for(Rank rank : Rank.values())
				if(rank.getRank() == value)
					return rank;
			return null;
		}
	}
	
	private class ValueComparator implements Comparator<Rank> {
		
		private Map<Rank, Integer> _map;
		
		public ValueComparator(Map<Rank, Integer> map) {
			_map = map;
		}
		
		public int compare(Rank a, Rank b) {
			if(_map.get(a) == _map.get(b))
				return b.compareTo(a);
			else if(_map.get(a) > _map.get(b))
				return -1;
			else
				return 1;
		}
	}
}