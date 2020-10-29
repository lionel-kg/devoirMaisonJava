package devoirMaisonJava;

import java.util.*;
import java.io.*;
import java.math.*;

/**
*Auto-generated code below aims at helping you parse
*the standard input according to the problem statement.
**/
class Solution 
{
	public static void main(String args[]) 
	{
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();

		if (in.hasNextLine())
		{
			in.nextLine();
		}

		String []tab = new String [M];

		for (int i = 0; i < M; i++)
		{
			String ROW = in.nextLine();
			tab[i] = ROW;
		} 
		// Write an answer using System.out.println()
		System.out.println(possiblePath(tab, M, N, 0, 0));
		// To debug: System.err.println("Debug messages...");
	}

	public static int possiblePath(String[] tab,int M,int N, int x, int y)
	{
		int [][] cache = new int[N][M];
		for(int i = 0 ; i < N; i++)
		{
			for(int j = 0; j < M ; j++)
			{
				cache[i][j] = -1;
			}
		}
		return possiblePath(tab, M, N, x, y,cache);
	}

	//- La case analysée est hors des limites du tableau, donc > à N et > M
	//- La case analysée est = 1, donc on peut pas y aller
	//- La case analysée est égale à (N-1,M-1), ça veut dire que t'es arrivé.

	public static int possiblePath(String[] tab,int M,int N, int x, int y,int[][]cache)
	{
		if(x == N || y == M)
		{
			return 0;
		}
		if(cache[x][y] == -1)
		{
			if(tab[x].charAt(y) == '1')
			{
				return 0;
			} 
			if(x == N-1 && y == M-1)
			{
				return 1;
			} 
			cache[x][y] = possiblePath(tab, M,  N, x+1, y)+ possiblePath(tab, M,  N, x, y+1);
		}   
		return cache[x][y];
	}
}

