
# Doomsday Algorithm Project

Welcome to the Doomsday Algorithm Project! This project implements John Horton Conway's Doomsday algorithm to calculate the day of the week for any given date. It's a fun and educational way to explore algorithms and learn about date calculations. It's a fun project i started in my Junior year in College, inspired by [The Doomsday Algorithm - Numberphile](https://www.youtube.com/watch?v=z2x3SSBVGJU) YouTube video. Recently, I revisited the project to fix bugs, code readability, optimize the code, and add unit tests for better reliability and performance.


## Table of Contents

- [Introduction](#introduction)
  - [How it Works](#how-it-works)
  - [Special Days](#special-days)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](Acknowledgments)

## Introduction

The Doomsday rule, Doomsday algorithm or Doomsday method is an algorithm of determination of the day of the week for a given date. It provides a perpetual calendar because the Gregorian calendar moves in cycles of 400 years. The algorithm for mental calculation was devised by John Conway in 1973, drawing inspiration from Lewis Carroll's perpetual calendar algorithm. It takes advantage of each year having a certain day of the week upon which certain easy-to-remember dates, called the doomsdays, fall; for example, the last day of February, 4/4, 6/6, 8/8, 10/10, and 12/12 all occur on the same day of the week in any year. [Wikipedia](https://en.wikipedia.org/wiki/Doomsday_rule)


### How it Works

The Doomsday algorithm relies on knowing the "Doomsday" for each month, which is a specific day of the week that falls on certain dates within each month. By using simple calculations based on the known Doomsdays, the algorithm can determine the day of the week for any date.

### Special Days

Certain dates within the year always share the same day of the week:
- 4/4, 6/6, 8/8, 10/10, 12/12
- 5/9, 9/5, 7/11, 11/7
- For non-leap years: 1/3, 2/28
- For leap years: 1/4, 2/29


## Features

- Calculate the day of the week for any given date (1583AD - 10000AD), (Could work for years above 10000AD but have not been tested)
- Account for leap years and century-specific rules
- Simple and easy-to-use interface

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE or text editor for Java development
- Apache Maven (Might be required for contribution)

### Installation

1. Clone the repository:
   ```sh
   git clone [https://github.com/NatnaelB1/doomsday.git](https://github.com/NatnaelB1/Doomsday.git)
   ```
2. Navigate to the project directory:
    ```sh
    cd doomsday/src/main/java
    ```
3. Compile and run the program:
    ```sh
    javac DayOfTheWeek.java
    javac Main.java
    java Main
    ```

## Usage

The main class `DayOfTheWeek` contains the implementation of the Doomsday algorithm. The class `Main` contains a built in easy way to input day values to test the algorithm. It's also possible to create an instance of this class with a specific date and call the `doomsday()` method to calculate and print the day of the week for that date.

### Examples

```java
public static void main(String[] args) {
    DayOfTheWeek date1 = new DayOfTheWeek(1, 1, 2050);
    date1.doomsday();

    DayOfTheWeek date2 = new DayOfTheWeek(4, 7, 2100);
    date2.doomsday();
}
```

### Contributing
Contributions are welcome! Please open an issue or submit a pull request if you have suggestions for improvements or additional features.

### License
This project is licensed under the MIT License - see the LICENSE file for details.

### Acknowledgments
- John Horton Conway for devising the Doomsday algorithm
- [Numberphile Youtube channel](https://www.youtube.com/@numberphile)
- All contributors and supporters
Enjoy calculating the day of the week for any date with this fun project! 🙂
