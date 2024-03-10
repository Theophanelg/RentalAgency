# TP7 JAVA

## Objectif of the TP 7

```bash
  Handling of collection, hashmap and work on inheritance
```

## Realize

- All was Ok

## Compilation

```bash
  - Compilation of the test classe
  javac -classpath junit-console.jar:classes test/rental/*.java
  javac -classpath junit-console.jar:classes test/rental/filter/*.java
  javac -classpath junit-console.jar:classes test/rental/agency/*.java
  - Compilation of the filter classe
  javac -cp src src/rental/*.java -d classes
  javac -cp src src/rental/filter/*.java -d classes
  javac -cp src src/rental/vehicle/*.java -d classes
  javac -cp src src/rental/agency/*.java -d classes
```

## Execution

```bash
  java -jar junit-console.jar -classpath test:classes -scan-classpath 
  - Execution of classe MainAgency
  java -classpath classes rental.MainAgency
```

## Docs 

```bash
  javadoc -sourcepath src -subpackages rental -d docs
```
## Authors

- [theophane.legrand.etu@univ-lille.fr](mailto:theophane.legrand.etu@univ-lille.fr)


