# bank-ocr-kata-cljs

A workshop for learning ClojureScript test-driven development, first presented at Let's Test South Africa 2018.

# Getting started

* [Install Java](https://www.java.com/en/download/help/download_options.xml)
* [Install Node](https://nodejs.org) (on a Mac with Homebrew: `brew install node`)
* [Install Clojure](https://clojure.org/guides/getting_started) (on a Mac with Homebrew: `brew install clojure`)

Once that's installed, fork and clone this repo. In a terminal window, change to the directory you just cloned and run the following command.

    npm install

You should now run tests (using the command below) to download the relevant libraries and verify that everything is fine.

# Running tests

The majority of the work will involve running the following command at the command line. Set your editor or IDE up so that you can quickly run this command.

    clj -Atest

# Part one: Digit OCR

Your task is to read in a string of numbers in the format described in [the kata description](http://codingdojo.org/kata/BankOCR/), and convert them into an account number.

Don't worry about reading in a file or creating a program entry-point. Just focus on writing tests that exercise behaviour. If you follow the instructions below you'll end up with two functions, `read-single-character` and `read-many`.

## Hints

### Kata progress

Katas are often exercises in finding a series of small steps that help you move towards the solution. You want to avoid a "big bang" where you have to write the entire solution to solve a test.

For this kata, I'd suggest writing tests in this order:

1. Read a single character, using a function `read-single-character`, which returns an integer.
2. Read two characters, using a function `read-many`, which returns a string (e.g. "01").
3. Read more than two characters, by modifying `read-many` to read up until the newline.

### Use newlines

`read-single-character` shouldn't worry about newline characters ('\n'). But `read-many` will need to use newlines to determine the number of characters in the string.

### Think functionally

There is no 'state' in Clojure; you can't reassign variables. Rather than thinking about gathering up characters, think about reading in all the data and then chopping it up into segments and then reassembling in the right order.

# Part two: Adding a UI

This part involves using [Reagent](https://github.com/reagent-project/reagent) to build a UI. There is already some it implemented in the `part-two` branch.

You will need to build the application using the following command.

    clj -m cljs.main -c bank-ocr-kata.core

You can then open the `index.html` file in the project root:

    open index.html

You'll see a line of 9 LCD digits, each in the number '8' formation. There are a few options for tasks at this point:

 * Modify the code to show the correct formation of digits for a given account number.
 * Refactor the existing code to be clearer.
 * Write tests around the UI code. You can use [JSDOM](https://github.com/jsdom/jsdom) which is already included in the project, to give you a "headless" DOM (in other words, not connected to any browser environment. It all runs in-process, with your tests).
