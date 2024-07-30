# String Calculator Service

A simple string calculator service that performs addition operations based on a string input. This service supports various delimiters, handles negative numbers by throwing exceptions, and ignores numbers greater than 1000.

## Features

- Add up to two numbers, separated by commas.
- Handle an unknown amount of numbers.
- Handle new lines between numbers.
- Support custom delimiters.
- Throw exceptions for negative numbers.
- Ignore numbers greater than 1000.
- Support delimiters of any length.
- Support multiple custom delimiters.

## Getting Started

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/string-calculator-service.git
    cd string-calculator-service
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Usage

### CalculatorService

The `CalculatorService` class provides the `add` method to perform addition based on the input string.

#### Example

mvn test
