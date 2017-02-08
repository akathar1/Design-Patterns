CS542 Design Patterns
Fall 2016
PROJECT <5> README FILE

Due Date: <Thursday, December 15, 2016>
Submission Date: <Thursday, December 15, 2016>
Grace Period Used This Project: <0> Days
Grace Period Remaining: NA
Author(s): <Abhishek Kathar>
e-mail(s): <akathar1@binghamton.edu>


PURPOSE:

[

To build a well designed application that compares objects using java reflection.
   
]

PERCENT COMPLETE:

[
  I believe I have completed 100% of this project.
]

PARTS THAT ARE NOT COMPLETE:

[
  N/A
]

BUGS:

[
  N/A
]

FILES:

[ 

  Included with this project are 8 files:

Driver
FileProcessor
FileProcessorI
Logger
First
PopulateObjects
PopulateObjectsI
Second


]

SAMPLE OUTPUT:

[

/*****************for input2.txt (Large input file)**********/
remote01:~/DPassign5> ant -buildfile genericDeser/build.xml run -Darg0=input.txt -Darg1=0
Buildfile: /import/linux/home/akathar1/DPassign5/genericDeser/build.xml

jar:

run:
     [java]
     [java]  Number of unique First objects : 359994
     [java]
     [java]  Total Number of First objects : 498623
     [java]
     [java]  Number of unique Second objects : 100643
     [java]
     [java]  Total Number of Second objects : 501377

BUILD SUCCESSFUL
Total time: 12 seconds

/*****************for input1.txt**********/
remote01:~/DPassign5> ant -buildfile genericDeser/build.xml run -Darg0=input.txt -Darg1=0
Buildfile: /import/linux/home/akathar1/DPassign5/genericDeser/build.xml

jar:

run:
     [java]
     [java]  Number of unique First objects : 4952
     [java]
     [java]  Total Number of First objects : 4952
     [java]
     [java]  Number of unique Second objects : 5018
     [java]
     [java]  Total Number of Second objects : 5048

BUILD SUCCESSFUL
Total time: 1 second


]

TO COMPILE:

[ 

Steps for program compilation :
  Unzip the tarball using following command :
	tar -xvf kathar_abhishek_assign5.tar.gz	
  Go to the folder above genericDeser
  and run the following program::	
	ant -buildfile genericDeser/build.xml all
	ant -buildfile genericDeser/build.xml jar 
  
]

TO RUN:

[

Steps for program execution :
  1. Execute following command to run the program :
	ant -buildfile genericDeser/build.xml run -Darg0=input.txt -Darg1=0
 


 
]




EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

[
NA  
]

DATA STRUCTURES :
[

I have used hash map for storing the Objects of First and Second class.
HashMap are efficient for locating a value based on a key and inserting or updating values based on a key.
With hash map its easy and efficient to check if the key(Object) already exists in the map 
by using the 'containsKey' method. And also it is easy to update the corresponding value of the
key (object). 

]


ACKNOWLEDGEMENT:

[
    During the coding process no help from anyone was taken
]
