# Training Management System

## Overview
The **Training Management System (TMS)** is a prototype for managing training programs efficiently. It enables trainers to set availability, trainees to enroll in batches and mark attendance, and provides graphical reports for insights. Built with **Java (Spring Boot)** for the backend and **Vue.js** for the frontend, the system implements **JWT-based authentication** and **role-based access control (RBAC)** for secure access. It is packaged in Docker for easy deployment and includes a demo video showcasing its features.

### Core Features
1. **Trainer Management**
    - Trainers can set availability for the upcoming month (dates and time slots).
    - Trainers are assigned to batches based on location.
    - Trainers can view batch progress and session details (attendance summaries, enrolled trainees).
2. **Trainee Management**
    - Trainees can enroll in available batches.
    - Trainees can mark attendance for sessions.
3. **Batch Management**
    - Batches are linked to a course and a trainer (matched by location).
    - Each batch supports multiple enrolled trainees.
4. **Reports**
    - **Trainer Availability vs. Occupancy**: Bar chart showing days available vs. days assigned to batches.
    - **Batch Enrollments**: Pie chart displaying trainee count per batch.
    - **Attendance Trends**: Line chart tracking attendance per session over time.

## Tech Stack
- **Backend**: Java (Spring Boot) for RESTful APIs, JWT authentication, and RBAC.
- **Frontend**: Vue.js for a responsive user interface.
- **Database**: MariaDB for relational data storage.
- **Authentication**: JSON Web Tokens (JWT) for secure user authentication.
- **Authorization**: Role-Based Access Control (RBAC) with roles: Trainer, Trainee, Admin.
- **Visualization**: Vue Chart.js for graphical reports.
- **Containerization**: Docker for deployment.
- **Version Control**: Git (hosted on GitHub).

## Prerequisites
To run the TMS locally, ensure you have:
- [Docker](https://www.docker.com/get-started) (for containerized deployment)
- [Git](https://git-scm.com/downloads) (to clone the repository)
- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) (optional, for local backend development)

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/harshchoudhary56/Training_Management_System.git
   cd Training_Management_System
   ```
   Or use SSH to avoid token prompts:
   ```bash
   git clone git@github.com:harshchoudhary56/Training_Management_System.git
   ```

2. **Configure Git Identity** (if using a shared laptop):
   Ensure commits reflect your identity:
   ```bash
   git config user.name "Harsh Choudhary"
   git config user.email "harsh.choudhary.developer@gmail.com"
   ```

3. **Run with Docker**:
    - Ensure Docker is running.
    - Build and start services using Docker Compose:
      ```bash
      docker-compose up --build
      ```
    - Access the application:
        - Frontend: `http://localhost:8080`
        - Backend APIs: `http://localhost:8000`

4. **Set Environment Variables**:
    - Copy the example environment file:
      ```bash
      copy .env.example .env
      ```
    - Update `.env` with your configuration, e.g.:
      ```plaintext
      SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/tms_db
      SPRING_DATASOURCE_USERNAME=postgres
      SPRING_DATASOURCE_PASSWORD=your_password
      JWT_SECRET=your_jwt_secret_key
      ```

5. **(Optional) Run Locally Without Docker**:
    - **Backend (Spring Boot)**:
      ```bash
      cd backend
      mvn clean install
      mvn spring-boot:run
      ```
    - **Frontend (Vue.js)**:
      ```bash
      cd frontend
      npm install
      npm run serve
      ```

## Usage
1. **Authentication**:
    - Log in at `/login` to obtain a JWT token.
    - Roles (Trainer, Trainee, Admin) determine access via RBAC.
    - Include the JWT in the `Authorization` header (`Bearer <token>`) for protected endpoints.

2. **Trainer Features**:
    - **Set Availability**: Go to `/trainer/availability` to add dates and time slots.
    - **View Batch Progress**: Access `/trainer/batches` for attendance and trainee details.
    - **Assignment**: Trainers are assigned to batches based on location during batch creation.

3. **Trainee Features**:
    - **Enroll in Batches**: Visit `/trainee/batches` to join available batches.
    - **Mark Attendance**: Go to `/trainee/sessions` to mark session attendance.

4. **Batch Management**:
    - Admins can create batches at `/admin/batches`, linking courses and trainers.
    - View batch details at `/batches/<batch_id>`.

5. **Reports**:
    - Access reports at `/reports`:
        - **Trainer Availability vs. Occupancy**: Bar chart comparing available vs. assigned days.
        - **Batch Enrollments**: Pie chart showing trainee distribution.
        - **Attendance Trends**: Line chart tracking session attendance.

## API Documentation
Key API endpoints (base URL: `http://localhost:8000`):
- `POST /auth/login`: Authenticate and receive a JWT token.
- `POST /api/trainers/availability`: Add trainer availability (Trainer role).
- `POST /api/trainees/enroll`: Enroll in a batch (Trainee role).
- `POST /api/sessions/attendance`: Mark session attendance (Trainee role).
- `GET /api/reports/availability`: Fetch availability vs. occupancy data (Admin role).
- `GET /api/reports/enrollments`: Fetch batch enrollment data (Admin role).
- `GET /api/reports/attendance`: Fetch attendance trend data (Admin role).

See `/docs/api_spec.md` for detailed API specifications.

## Role-Based Access Control (RBAC)
- **Roles**:
    - **Trainer**: Manage availability, view batch progress.
    - **Trainee**: Enroll in batches, mark attendance.
    - **Admin**: Manage batches, courses, and view reports.
- **Implementation**: Spring Security enforces RBAC, validating JWT roles per endpoint.

## Demo Video
A demo video is available at `/docs/demo_video.mp4`, showcasing:
- User login with JWT authentication.
- Trainer availability setup and batch assignment.
- Trainee enrollment and attendance marking.
- Graphical reports (bar, pie, line charts).



## Contact
Contact Harsh Choudhary at [harsh.chaudhary.developer@gmail.com](mailto:harsh.chaudhary.developer@gmail.com) or via [LinkedIn](https://www.linkedin.com/in/harsh-choudhary-229b85228/).