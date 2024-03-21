package com.perscholas.loops;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * In this assignment, you will create a Java program. Requirements are given below. This assignment
 * will test your knowledge of Control Flow (Conditional) Statements and loops in Java.
 */
public class Loops {

  private Scanner scanner;

  public static void main(String[] args) {
    new Loops().pa_303_5_1();
  }

  private void pa_303_5_1() {
    System.out.println("""
        **************************************************
        PA 303.5.1 - Iteration Statements (Loops)
        **************************************************""");
    scanner = new Scanner(System.in);
    boolean usingScanner // comment either one below if you wish to use Scanner
        = false;
    //        = true;
    problem_1();
    System.out.println();
    problem_2(usingScanner);
    System.out.println();
    problem_3(usingScanner);
    System.out.println();
    scanner.close();
  }

  /**
   * 1. Write a program that uses nested for loops to print a multiplication table. ~Note: it seems
   * they went up to 12, so that's what I'll do.
   */
  private void problem_1() {
    System.out.println("1.\tMultiplication Tables");
    for (int i = 1; i <= 12; i++) {
      for (int j = 1; j <= 12; j++) {
        System.out.printf("| %3d |", i * j);
      }
      System.out.println();
    }
  }

  /**
   * 2. Write a program that prompts the user to enter two positive integers, and find their
   * greatest common divisor (GCD).
   */
  private void problem_2(boolean usingScanner) {
    System.out.print("2.\t");
    int n1;
    int n2;
    int k = 2;
    int gcd = 1;
    if (usingScanner) {
      System.out.print("Input the first integer: ");
      n1 = Integer.parseInt(scanner.next());
      System.out.print("Input the second integer:  ");
      n2 = Integer.parseInt(scanner.next());
    } else {
      n1 = ThreadLocalRandom.current().nextInt(2, 100001);
      n2 = ThreadLocalRandom.current().nextInt(2, 100001);
    }
    while (k < n1 / 2 || k < n2 / 2) {
      if ((k > gcd) && (n1 % k == 0) && (n2 % k == 0)) {
        gcd = k;
      }
      k++;
    }
    System.out.printf("GCD between %d and %d is: %d\n", n1, n2, gcd);
  }

  /**
   * 3.Suppose the tuition for a university is $10,000 for the current year and increases by 7
   * percent every year.  In how many years will the tuition be doubled?
   */
  private void problem_3(boolean usingScanner) {
    System.out.print("3.\t");
    float initialTuition;
    float increaseRate;
    if (usingScanner) {
      System.out.print("Input the starting tuition: ");
      initialTuition = Float.parseFloat(scanner.next());
      System.out.print("Input the annual increase rate as a decimal:  ");
      increaseRate = Float.parseFloat(scanner.next());
    } else {
      initialTuition = 10000f;
      increaseRate = 0.07f;
    }
    int years = 1;
    float newTuition = initialTuition * years * (1 + increaseRate);
    while (newTuition < 2 * initialTuition) {
      newTuition = initialTuition * (1 + years * increaseRate);
      years++;
    }
    System.out.printf("""
            For the given initial tuition of $%,.2f and an annual increase rate of %.2f%%,
            it will take %d years to double in price.
            """, initialTuition, increaseRate, years);
  }
}
