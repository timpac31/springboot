package com.demo.learningtest.lambda;

import java.util.Arrays;

public class LambdaTest {

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello");
			}
		}).start();
		

		new Thread(()->{ 
			System.out.println("Hello lambda"); 
		}).start();
		
		
		//functional interface implement using lambda
		Calculator add = (int a, int b) -> a + b;
		Calculator sub = (int a, int b) -> a - b;
		System.out.println(add.calc(10, 5));
		System.out.println(sub.calc(10, 5));
		
		
		//stream
		Arrays.asList(1,2,3).stream().map(i->i*2).forEach(System.out::println);
		Arrays.asList(1,2,3).stream().limit(1).forEach(System.out::println);
		Arrays.asList(1,2,3).stream().skip(2).forEach(System.out::println);
		Arrays.asList(1,2,3).stream().filter(i->i>1).forEach(System.out::println);
		System.out.println( Arrays.asList(1,2,3).stream().reduce((a,b)->a+b).get() );
		
	}

}
