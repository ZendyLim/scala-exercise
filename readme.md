## How to Run

```
# Task 1 (sbt "runMain Task1Main {your number here}")
sbt "runMain Task1Main 1"

# Task 2 (sbt "runMain Task2Main {dd-MM-yyyy} {dd-MM-yyyy}")
sbt "runMain Task2Main 10-10-1995 10-10-2022"

# Task 3 (sbt "runMain Task3Main \"{+XX XXX XXXX XXXX or ooo@oooo.com}\"")
sbt "runMain Task3Main \"+12 345 6789 0000\""
sbt "runMain Task3Main \"help@example.com\""
```