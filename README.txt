Discrete Event Simulation: Bussing system Simulation

Thomas Dourgarian
Dourg004@umn.edu

Running on new machine: Save file conataining all classes. Go inside the file in your terminal
and compile BusSim.java ("$javac BusSim.java") and that will compile all other classes used in it.
Then run BusSim.java ($java BusSim").


Project Overview: BusSim.java is the main class of the entire simulation. It creates all the starting
events and holds the while loop for the agenda. It also prints out all the statistics I found.
BusEvent.java does most of the work within the entire simulation, it is where I gather the statistics and
utilize multiple algorithms for boarding and deboarding. The other key classes that weren't provided by lecture examples are
Rider.java and Bus.java which are my object classes that are needed to create their corresponding
event classes, RiderEvent.java and BusEvent.java. Stop.java just holds all the queues and some arrays.
Statistics.java just holds stat variables so in BusEvent you can easily see what variables are 
only for stat findings. Important notes: to change the busyness of the simulation, change the time constraint
in the while loop in BusSim.java and also change the "interval" variable in RiderEvent.java to simulate 
faster or slower spawning time. Also it seemed 11 normal busses was pretty close to equilibrium when running for longer 
than an hourish.You can change the number of normal busses and express busses pretty easily in BusSim.java.


Data Structures and Algorithms: I used a queue class (Q2.java) provided by lecture examples, structured
with an array for all my bus stops. The only problem with this is getting out the express riders within
the queue. I explain how I do it in BusEvent.java under the "express bus" section. For my busses I used
an array list which worked out well because I could easily remove, add, or check any riders without having to
re-size the constantly changing array which made things run alot smoother.


Bugs and issues: No critical issues or any bugs in the program. Only thing is I didn't give myself enough
time to figure out was bus clumping and how to prevent it, thus the max queue length can get pretty extreme
at the downtown bus stops during rush hour. Thats why I chose not to evaluate that statistic in my report.
