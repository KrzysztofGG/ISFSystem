# ISFSystem App
## What does it do?
This is an app that lets you determine the most<br/>
optimal way for the employees to prepare the orders. <br/>
It requires 2 json files: 
 - file with data about a store for the given day <br/>
   (list of employees, time of start and hour of start) (store.json)
 - second contains information about each order's specifics (orders.json)

## Running 
To run the app use this command:<br/>
java -jar  /home/…/app.jar /home/…/store.json /home/…/orders.json <br/>

You can generate the app.jar using the mvn package command

