# UggCLI

UggCLI is a command-line tool designed for players of "League of Legends" to quickly open champion build guides on [u.gg](https://u.gg) using specific parameters such as champion name, rank, and lane.

## Features

- **Quick Access to Builds**: Directly open the browser with the optimal build, runes, and strategy for your selected champion.
- **Customizable Options**: Specify the rank and lane to get the most relevant build information for your current game scenario.

## Installation

To use UggCLI, you'll need Java installed on your machine as it's a Java-based application. Clone this repository to your local machine using the following command:

```bash
git clone https://your-repository-url.git
```

Navigate into the project directory and build the project using Maven:

```bash
cd UggCLI
mvn package
```

This will compile the code and create an executable JAR in the target directory.

## Usage

Run UggCLI with the required and optional parameters as shown below:

```bash
java -jar target/uggcli-0.1.jar <championName> [options]
```

### Parameters
* `<championName>`: The name of the champion (required).

### Options
* -r, --rank <rank>: Specify the rank to tailor the build (optional).
* -l, --lane <lane>: Specify the lane for the champion (optional).

### Examples

Here are some example commands to start using UggCLI

```bash
java -jar target/uggcli-0.1.jar Garen
java -jar target/uggcli-0.1.jar Ahri --lane mid
java -jar target/uggcli-0.1.jar Ezreal --lane adc --rank diamond
```

These commands will open your default web browser and direct you to the respective champion build pages on u.gg.

This README was shamelessly [generated with LLM labor](https://github.com/chancehl/gpt-readme)💪🤖
