# Linear-probing-optimisation
This repository contains my code (as well as some code written by Stephan Jamieson) and results for a university project.

- This project involved:
    - Implementing linear probing and quadratic probing hash tables by completing skeleton code written by Stephan Jamieson.
    - Computing weights that optimise the insertion of a **specific** list of names (_mydata.txt_) into a linear probing hash table (the set(s) of weights that minimise the probe count)

- The contents of the repository are detailed as follows:
    - LPHashTable.java: Skeleton code for a linear probing hash table written by Stephan Jamieson and implemented by Isa Alatovic.
    - QPHashTable.java: Skeleton code for a quadratic probing hash table written by Stephan Jamieson and implemented by Isa Alatovic.
    - students.txt: List of all student numbers of students taking CSC2001F.
    - mydata.txt: My person list of names to be inserted into a LP hash tables. This is a subset of students.txt and is unique to each student completing the assignment.
    - Optimize.java: My solution to the optimisation problem. Writes the output to a text file called results.txt.
    - results.txt: Contains the result of the optimisation process (more details in assignment doc)
    - Assignment_DS4.pdf: Assignment briefing document.
    - Monitorable.java: Abstract class that is implemented by HashTable.java.
    - HashTable.java: Abstract class that implements Monitorable.java and is implemented by LPHashTable.java and QPHashTable.java.
