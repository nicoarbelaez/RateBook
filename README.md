# Movie, Series, and Book Ratings

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

## Description

This service allows users to rate movies, series, and books using star ratings, reviews, and comments. It is an interactive platform where users can share their opinions and discover new recommendations based on others' ratings.

## Features

### Item Ratings
- Users can rate movies, series, and books with star ratings.
- Each item (movie, series, or book) will display:
  - **Title**
  - **Image**
  - **Description**
  - **Tag (topic)**
  - **Average rating**

### User Reviews
- Users can write one review per item.
- Reviews cannot be commented on by other users.
- Reviews can receive “likes”❤️ or “dislikes”👎.
- The number of views for each review can be seen.

### Comments
- Items can have additional comments.
- Comments can be replied to by other users.
- Comments and replies can receive “likes”❤️ or “dislikes”👎.

## Restrictions
- Each user can write only one review per item.
- Reviews cannot be commented on, only receive “likes”❤️ or “dislikes”👎.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Database Diagram

For a better understanding of the database structure, you can check the following diagram:

[![Database Diagram](https://img.shields.io/badge/DB-Diagram-blue)](https://dbdiagram.io/d/RateBook-66a6c2088b4bb5230e921f66)
