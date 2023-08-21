# Multithreaded Data Update and Calculation in Java

This repository contains a Java program that demonstrates multithreading concepts related to data update and calculation. It consists of several classes designed to showcase thread synchronization using locks and the issues that can arise without proper synchronization.

## Table of Contents

- [Introduction](#introduction)
- [Classes](#classes)
- [Usage](#usage)
- [Issues](#issues)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Multithreading is a powerful technique to achieve concurrent execution and better performance in software applications. However, improper synchronization between threads can lead to data inconsistency and unexpected behavior. This repository provides an example of multithreaded data manipulation to illustrate these concepts.

## Classes

The repository includes the following Java classes:

- `CalculatorThread`: A thread that calculates and displays the difference between two numbers using the `Data` class.
- `Data`: Represents a class containing two integer values, supporting synchronized update and difference calculation methods with locks for proper synchronization.
- `GeneratorThread`: A thread that updates the values in the `Data` class with random integers while using synchronization.
- `GeneratorThreadWrong`: A thread attempting to update `Data` without synchronization, demonstrating potential issues.
- `Main`: The main entry point of the program, creating and starting instances of the various threads.

## Issues

The `GeneratorThreadWrong` class demonstrates the problems that can occur when updating data without proper synchronization. The program may exhibit unexpected results and errors due to data inconsistency.
