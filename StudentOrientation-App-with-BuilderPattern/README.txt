CS542 Design Patterns
Fall 2016
PROJECT <3> README FILE

Due Date: <Friday, Oct 28, 2016>
Submission Date: <Friday, Oct 28, 2016>
Grace Period Used This Project: <0> Days
Grace Period Remaining: NA
Author(s): <Abhishek Kathar> <Mohit Kulkarni>
e-mail(s): <akathar1@binghamton.edu> <mkulkar3@binghamton.edu>


PURPOSE:

[

To build a well designed application for various activities involved in orientation.
And to give students freedom to select their own choices for activities. We have used builder pattern to accomplish this. 
The workshop interface gives the scope for activites to be implemented in their independent way in future.
Also the cost,time,effort and carbon footprint are provided with interfaces to give a future scope for change in the currency or units
in which they are measured in.
   
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

  Included with this project are 33 files:

Driver
BuildOrientation
BuildOrientationInterface
WorkShop
WorkShopInterface
BookStoreChoice
CampusTourChoice
DormsChoice
RegistrationChoice
BuyingBooksInterface
CampusTourInterface
CourseRegisterationInterface
DormGamingContest
DormInLine
MandoBookStore
RegisterInLabOnline
RegisterInOffice
SelectingDormInterface
TourByBus
TourOnFoot
UniversityBookStore
CarbonFootPrint
CarbonFootPrintInterface
Cost
CurrencyInterface
Duration
Efforts
EffortsInterface
TimeInterface
OrientationResults
OrientationResultsInterface
Logger
README, the text file you are presently reading
]

SAMPLE OUTPUT:

[
In OrientationResults.Display  method...
 
CampusTour
Cost : 0.1 Dollars   Effort : 300.0 Calories   FootPrint : 2.0 tons Co2   Time : 150.0 Minutes

BookStore
Cost : 237.5 Dollars   Effort : 50.0 Calories   FootPrint : 0.3 tons Co2   Time : 15.0 Minutes

Dorms 
Cost : 714.0 Dollars   Effort : 150.0 Calories   FootPrint : 0.3 tons Co2  Time : 30.0 Minutes

Course Registration 
Cost : 2910.0 Dollars   Effort : 200.0 Calories   FootPrint : 0.5 tons Co2  Time : 30.0 Minutes

Total Cost: 3861.6 Dollars

Total Effort: 700.0 Calories

Total Carbon FootPrint: 3.0999999999999996 tons Co2

Total Time: 225.0 Minutes


]

TO COMPILE:

[ 

Steps for program compilation :
  Unzip the tarball using following command :
	tar -xvf Kathar_abhishek_Kulkarni_mohit.tar.gz	
  Go to the folder above studentOrientation and run the following program::	
	ant -buildfile studentOrientation/build.xml all
  	ant -buildfile studentOrientation/build.xml jar 
  
]

TO RUN:

[

Steps for program execution :
  1. Execute following command to run the program :
	ant -buildfile studentOrientation/build.xml run 

 
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

I have used objects of the interfaces of various activities involved in orientation to store their respective time,cost,effort and carbon footprint

]


ACKNOWLEDGEMENT:

[
    During the coding process no help from anyone was taken
]
