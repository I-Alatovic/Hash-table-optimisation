# Hash-table-optimisation
This repository contains my code (as well as some code written by Stephan Jamieson) and results for a 2nd year university project.

- This project involved:
    - Implementing linear probing and quadratic probing hash tables by completing skeleton code written by Stephan Jamieson.
    - Computing weights that optimise the insertion of a **specific** list of names (_mydata.txt_) into a linear probing hash table (the set(s) of weights that minimise the probe count).

- The contents of the repository are detailed as follows:
    - _LPHashTable.java_: Skeleton code for a linear probing hash table written by Stephan Jamieson and implemented by Isa Alatovic.
    - _QPHashTable.java_: Skeleton code for a quadratic probing hash table written by Stephan Jamieson and implemented by Isa Alatovic.
    - _students.txt_: List of all student numbers of students taking CSC2001F.
    - _mydata.txt_: My person list of names to be inserted into a LP hash table. This is a subset of _students.txt_ and is unique to each student completing the assignment.
    - _Optimize.java_: My solution to the optimisation problem. Writes the output to a text file called _results.txt_.
    - _results.txt_: Contains the result of the optimisation process (more details in assignment doc)
    - _Assignment_DS4.pdf_: Assignment briefing document.
    - _Monitorable.java_: Abstract class that is implemented by _HashTable.java_.
    - _HashTable.java_: Abstract class that implements _Monitorable.java_ and is implemented by _LPHashTable.java_ and _QPHashTable.java_.

- See _Assignment_DS4.pdf_ for details on the assignment.


NB: This repository is part of a university assignment submitted by Isa Alatovic. Please do not copy this work for academic submissions.
