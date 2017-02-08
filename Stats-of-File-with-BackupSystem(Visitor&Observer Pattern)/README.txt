CS542 Design Patterns
Fall 2016
PROJECT <4> README FILE

Due Date: <Wednesday, November 23, 2016>
Submission Date: <Wednesday, November 23, 2016>
Grace Period Used This Project: <0> Days
Grace Period Remaining: NA
Author(s): <Abhishek Kathar>
e-mail(s): <akathar1@binghamton.edu>


PURPOSE:

[

To build a well designed application for reading the statistics of the file using 
visitor pattern and keeping track of original file by creating backup of the file
using prototype and observer pattern 
   
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

  Included with this project are 16 files:

ObserverInterface
SubjectInterface
Driver
BinarySearchTree
Node
TreeForStringI
FileProcessor
FileProcessorI
Logger
Test
CloneNObserveVisitor
DSProcessingVisitorI
PopulateVisitor
TreeTraversal
TreeTraversalI
WordCountVisitor




]

SAMPLE OUTPUT:

[
remote02:~/DPassign4/kathar_abhishek_assign4/wordCount> ant run -Darg0=input.txt -Darg1=output.txt -Darg2=100
Buildfile: /import/linux/home/akathar1/DPassign4/kathar_abhishek_assign4/wordCount/build.xml

jar:

run:
     [java] Total Time : 42 milli seconds

BUILD SUCCESSFUL
Total time: 5 seconds


]

TO COMPILE:

[ 

Steps for program compilation :
  Unzip the tarball using following command :
	tar -xvf kathar_abhishek_assign4.tar.gz	
  Go to the folder above wordCount and run the following program::	
	ant -buildfile wordCount/build.xml all
	ant -buildfile wordCount/build.xml jar 
  
]

TO RUN:

[

Steps for program execution :
  1. Execute following command to run the program :
	ant -buildfile wordCount/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=10
 


 
]

OUTPUT INFORMATION:

[
Two output files will be generated after running the above command viz. backupTree.txt and originalTree.txt
and time in milli seconds will be displayed on the screen.
originalTree.txt will contain the inorder printing of tree with word and no_of_occurences before update.
backupTree.txt will contain the inorder printing of tree with word and no_of_occurences after update.
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

I have used Binary Search tree for keeping track of the words in the file.
Doing order statistics, finding closest lower and greater elements, doing range queries are easy to do with BSTs.
Thus it helped to traverse with speed and extract the stats from the tree efficiently.
With BSTs, all operations are guaranteed to work in O(Logn) time.
I have used hashmap for registering observer.
HashMap are efficient for locating a value based on a key and inserting and deleting values based on a key.
Therefore it becomes easy to find updated observer by searching through key.

]


ACKNOWLEDGEMENT:

[
    During the coding process no help from anyone was taken
]
