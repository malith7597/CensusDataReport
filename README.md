# CensusDataReport
Module 10 Java I/O Assignment


Introduction:

This assignment is to provide practice in using the Java I/O techniques discussed in the Module 10 video lectures and readings. Although the main focus of this assignment is Java I/O techniques, Java design and implementation techniques discussed in earlier modules should be incorporated in to this assignment.

Problem:

Supplied is a data file from the US Census, https://www.census.gov/, which contains data from US school districts and reports statistics related to child poverty. It is desired to have a summary report which calculate basic statistics at the state level.

Desired Implementation:

Java implementation to read the supplied text data and produce a report similar to the below:


  
 


There should be two separate “programs” (main()), one to read the text data file and write a reformatted file to be read by the second program which will create the report to standard out. Note before the report is displayed, a single line with “File: “ then the path of the input file for the report is displayed.
The first program will have 3 run-time parameters, the data source file path, the destination file path, and the number of records in the data file (13486) .
The second program will have 2 run-time parameters, the input file path and the number of records.

Features and Restrictions:

This assignment is an individual effort. Collaboration with other students on design approaches, implementation techniques, etc. as well as using the course's Discussion Board and other course resources are encouraged but the design, implementation, and submitted files must be your own creation.

The programs should use standard Java (SE) code and compile without errors or warnings. It should also run without errors or warnings when given valid input.
The programs should provide reasonable parameter validation (correct number of parameters,

  
reasonable values, etc.).

The file produced by the first program should not be deleted after running the report program.

The program's code should be reasonable formatted and commented as demonstrated so far in the course.
Resources:

File: SmallAreaIncomePovertyEstData.txt – contains the small area poverty data. It is a standard 8-bit readable text file.
File: SmallAreaIncomePovertyEstLayout.txt – contains information about the field layout of the SmallAreaIncomePovertyEstData.txt file.


