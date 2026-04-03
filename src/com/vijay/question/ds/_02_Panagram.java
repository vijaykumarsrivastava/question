package com.vijay.question.ds;

import java.util.SortedSet;
import java.util.TreeSet;

public class _02_Panagram {

	private static class PanagramDetector {
		private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

		public String findMissingLetters(String input) {
			SortedSet<Character> missingCharacters = new TreeSet<Character>();
			for (int i = 0; i < ALPHABET.length(); i++) {
				missingCharacters.add(new Character(ALPHABET.charAt(i)));
			}

			String s = input.toLowerCase();

			for (int i = 0; i < s.length(); i++) {
				missingCharacters.remove(new Character(s.charAt(i)));
			}

			StringBuilder sb = new StringBuilder();
			for (Character c : missingCharacters) {
				sb.append(c.charValue());
			}

			return sb.toString();
		}

	}

	public static void main(String[] args) {
		PanagramDetector pd = new PanagramDetector();
		boolean success = true;

		success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
		success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

		if (success) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}
}
