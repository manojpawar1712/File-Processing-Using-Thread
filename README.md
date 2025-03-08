# File Processing System

## 📌 Project Description
This project continuously monitors a specific folder for new files, stores metadata (e.g., filename) in a database, and sends email notifications whenever a new file is found. The background task is efficiently scheduled using **ScheduledExecutorService** to check the folder at a fixed interval of **3 seconds**.

## 🚀 Features
- ✅ **Folder Monitoring**: Automatically detects new files in a specific folder.
- ✅ **Database Integration**: Stores file metadata (filename, timestamp, etc.).
- ✅ **Scheduled Execution**: Uses `ScheduledExecutorService` to run every **3 seconds**.
- ✅ **Email Notifications**: Sends an email alert whenever a new file is found.
- ✅ **Efficient Resource Management**: Optimized multithreading using scheduled tasks.

## 🛠 Technologies Used
| Technology  | Description |
|-------------|------------|
| **Java** | Core programming language |
| **ScheduledExecutorService** | Threading for periodic task execution |
| **PostgreSQL** | Database for storing file details |
| **JavaMail / SMTP** | Sending email notifications |

## 📂 Project Structure



## ⚡ Setup Instructions
1. **Clone the repository**
   ```sh
   git clone https://github.com/manojpawar1712/File-Processing-Using-Thread.git
   cd File-Processing-Using-Thread

2. **Configure Database Connection**
Update the database properties in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=root
spring.datasource.password=your_password

3. **Configure Email Credentials**
mail.smtp.host=smtp.example.com
mail.smtp.port=587
mail.smtp.username=your_email@example.com
mail.smtp.password=your_password

4. **Run the Application**
   mvn spring-boot:run

