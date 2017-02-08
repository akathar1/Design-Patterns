CS542 Design Patterns
Fall 2016
PROJECT <2> README FILE

Due Date: <Friday, SEPTEMBER 30, 2016>
Submission Date: <Friday, SEPTEMBER 30, 2016>
Grace Period Used This Project: <0> Days
Grace Period Remaining: NA
Author(s): <Abhishek Kathar>
e-mail(s): <akathar1@binghamton.edu>


PURPOSE:

[

To design an application which reads contents of the file with multiple threads and assign courses to them according to their preferences. And also the project intends to develop a well designed appliction.
   
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

  Included with this project are 13 files:
		
Driver.java : contains the main method
CreateWorker.java : creats and starts threads
Worker.java : contains the run method for running the threads
FileProcessor.java : to read from file and write to file
Students.java : contains student details
StudentRegistration.java : Contains registration algorithm
StudentRegistrationInterface.java : Interface
ObjectPool.java : conatins course pool
Logger.java : for debugging
FileDisplayInterface.java : Interface
StdoutDisplayInterface.java : Interface
Results.java :  conatains write to screen and write to file and        			insert record methos
  
README, the text file you are presently reading
]

SAMPLE OUTPUT:

[
Student_2 B C A D E 17
Student_1 A B F G C 19
Student_3 C D E F G 15
Student_4 D E A B F 17
Student_5 E F G A B 15
Student_6 F G C D A 17
Student_7 G A B C D 15
Student_8 A B E C D 15
Student_9 B C E F G 18
Student_10 C D E F G 15
Student_11 D E A B F 17 
-------
-------
-------
 Average Preference count is : 16.0833335

]

TO COMPILE:

[ 

Steps for program compilation :
  Unzip the tarball using following command :
	tar -xvf abhishek_kathar_assign2.tar.gz	
  Go to the folder above src and run the following program::	
	ant -buildfile src/build.xml all
  	ant -buildfile src/build.xml jar 
  
]

TO RUN:

[

Steps for program execution :
  1. Execute following command to run the program :
	ant -buildfile src/build.xml run -Darg0=<INPUT_FILE_NAME> -Darg1=<OUTPUT_FILE_NAME> -Darg2=<NUM_THREADS> -Darg3=<DEBUG_LVL>
	For example : ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt-Darg2=3 -Darg3=0
 
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

I have preferred arraylist for various operation because you can insert at or delete elements from a particular position easily. 
The Time complexity of add remove operations of arraylist is O(n) time.
I have also used array of objects (Students) to store the record of each student as it is easy to store/access or modify student details for all students in that array.
The time complexity is O(n).

]


ACKNOWLEDGEMENT:

[
    During the coding process no help from anyone was taken
]
