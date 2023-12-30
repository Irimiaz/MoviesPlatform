# POO TV Streaming Platform

## Project Overview

This project involves implementing a backend for a movie and series streaming platform, akin to Netflix or HBO MAX. Objectives include developing a generic backend, enhancing organizational and object-oriented design skills, utilizing design patterns, and adhering to coding and commenting standards.

## Stage 1 - Implementation

### Structure Overview

The platform operates sequentially, resembling a file system. User pages include:

1. **Homepage (Unauthenticated):** Initial landing with options to Register or Login.
2. **Register Page:** Allows user registration.
3. **Login Page:** Facilitates user login.
4. **Homepage (Authenticated):** After login, access to Logout, Movies, See Details, and Upgrades.
5. **Movies Page:** Lists movies based on the user's country.
6. **See Details Page:** Provides movie details with actions like Purchase, Watch, Like, and Rate.
7. **Upgrades Page:** Offers premium account and token purchase options.

#### Workflow Example

1. Start at "Homepage Unauthenticated."
2. Navigate to "Register" or "Login."
3. Move to "Homepage Authenticated" after successful login.
4. Explore options like "Movies," "See Details," and "Upgrades."
5. Execute actions such as "Purchase," "Watch," "Like," and "Rate."

### Execution of the Project

1. Load initial data from the JSON file containing user information and the movie list.
2. Receive sequential actions and execute, updating the platform's state.
3. Display results in the output JSON file after each action.

### User Actions

- **Change Page:** Navigate to a different page.
- **On Page Actions:** Execute specific actions on the current page.

## Stage 2 Enhancements

### Subscribe Feature

- Allow users to subscribe to film genres.
- Subscription notifications for new relevant movies.

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
