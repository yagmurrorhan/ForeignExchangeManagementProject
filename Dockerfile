# Temel imaj: Java 17 ile OpenJDK
FROM eclipse-temurin:17-jdk-alpine

# Çalışma dizinini ayarla
WORKDIR /app

# Maven projesi için jar dosyasını kopyala
COPY target/foreignexchangemanagementproject-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]
