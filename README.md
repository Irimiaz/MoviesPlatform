# MoviesPlatform

The idea of this project is to simulate an interface of a site such as Netflix through which the user can interact with different movies and also be able to log in or authenticate. My main class is the one called PLATFORM which is instantiated using Singleton. In this class there are details and general information about the entire platform (such as all the movies that are available, the current user or the current page where the user is).

In the "platform" package, there are also classes such as User or Movie, which have the role of storing information about users or movies. Input and output classes are very important because it provide and display the information in the form of Json and facilitate data processing, entering them into classes. 

In the "actions" package there are several classes such as "Filter" "Change Page" "Purchase" "Login" which simply represent the action desired by the user. Within these classes there is the logic behind the entire project. Action information is stored in classes to make the code better structured.

The Main class is the one that goes through all the actions and uses the input to send further commands. It will go through each action separately and call the functions from the "actions" package. Depending on the result of these calls, different outputs (error or desired display) will be sent to the user.

Database add and delete are two functions that add or delete movies from the database. In addition to modifying the database, all affected users will receive a notification. With this modification of the database, if a movie is deleted from the database but was bought, viewed, etc. by a user, it disappears from all these arrays. We implemented these functions using the Obeserver Design Pattern because once the Database is modified, several actions are produced synchronously. All the observations we need are instantiated and they are all updated instantly.

The back action between pages is exactly the opposite of the change page, because users also need to return to a previous page. In order not to have to remember for each change page and the page we started from, we used the Command design pattern which has the role of remembering the list of commands performed on an object. This design pattern is perfect for creating delegation and callback structures. 

