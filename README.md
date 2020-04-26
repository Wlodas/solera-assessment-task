# Solera Assessment Task

The job recruitment task for Solero company creating a sale offer for a provided shopping cart and displaying it as an ASCII table in a console. Also some simple tests had been created to validate correctness of the calculated sale offers.

Assumptions:
* the product list is fixed
* prices can be expressed as natural numbers

The program can be executed in the following ways:
* by executing `gradlew run --args='apple,Apple,APPLE'` command
* by building the project first using `gradlew build` command, unpacking the distribution archive and running the executable file `bin/solera-assessment-task apple,Apple,APPLE`

Contents of the shopping cart can be defined by providing a comma-separated list of products as a program's argument. The available products include:
* Apple
* Orange
* Banana
* Papaya