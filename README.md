# POO TV Streaming Platform

## Project Overview

This project involves implementing a simple backend for a specific movie and series streaming platform, akin to services like Netflix or HBO MAX. The primary objectives are to develop a generic backend for a streaming platform, enhance organizational and object-oriented design skills, write generic code for easy addition of new functionalities, utilize appropriate design patterns for various tasks, and adhere to a standard coding and commenting style.

## Stage 1 - Implementation

### Structure Overview

The platform operates on a sequential system, and actions are executed sequentially based on received commands. The platform's structure resembles a file system, with pages representing different levels of interaction.

#### User Pages

1. **Homepage Unauthenticated**: Initial landing page for users not logged in.
   - Options: Register, Login.

2. **Register Page**: Allows users to register a new account.
   - Action: Register.

3. **Login Page**: Facilitates user login.
   - Action: Login.

4. **Homepage Authenticated**: After successful login, users have access to:
   - Logout
   - Movies
   - See Details
   - Upgrades

5. **Movies Page**: Lists available movies based on the user's country.
   - Actions: See Details, Upgrades, Search, Filter.

6. **See Details Page**: Provides details about a specific movie.
   - Actions: Purchase, Watch, Like, Rate the movie.

7. **Upgrades Page**: Offers premium account and token purchase options.
   - Actions: Buy Tokens, Buy Premium Account.

#### Workflow Example

1. Start at "Homepage Unauthenticated."
2. Navigate to "Register" or "Login."
3. After successful login, move to "Homepage Authenticated."
4. Explore options like "Movies," "See Details," and "Upgrades."
5. Execute actions such as "Purchase," "Watch," "Like," and "Rate the movie."

### Execution of the Project

1. Load initial data from the JSON file containing user information and the movie list.
2. Receive sequential actions and execute them, updating the platform's state.
3. Display the result in the output JSON file after each action.

### User Actions

- **Change Page**: Navigate to a different page.
- **On Page Actions**: Execute specific actions on the current page.

## Stage 2 Enhancements

### Subscribe Feature
- Allow users to subscribe to film genres.
- Subscription notifications on new relevant movies.

### Database Modification
#### Add Movie
- Add a movie to the database.
- Notify genre subscribers.

#### Delete Movie
- Delete a movie; refund and notify buyers.

### Back Action
- Navigate back for logged-in users.

### Premium User Recommendations
- Provide personalized film recommendations.
- Follow a specified algorithm.

### Output Modification
- Display user notifications.

## Notes
- Maintain subscriptions between sessions.
- Handle errors for various actions.
- Implement a user-friendly Back action.

## Recommendations
- Generate a concise readme for GitHub.
- Ensure correct input/output format.
- Adhere to defined action constraints.

## Example Input/Output
- Refer to documentation examples.
