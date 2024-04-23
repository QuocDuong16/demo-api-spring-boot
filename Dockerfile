# Sử dụng một image cơ sở với Java đã cài đặt
FROM openjdk:11-jdk

# Sao chép các tệp JAR từ máy tính cục bộ vào image
COPY target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Định nghĩa thư mục làm việc mặc định cho ứng dụng
WORKDIR /app

# Cổng mà ứng dụng Spring Boot chạy trên
EXPOSE 8080

# Lệnh để chạy ứng dụng Spring Boot khi container được khởi chạy
CMD ["java", "-jar", "app.jar"]
