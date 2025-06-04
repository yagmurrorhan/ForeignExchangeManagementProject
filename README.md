# 💱 Foreign Exchange Management API

Bu proje, döviz kurları üzerinden para birimi dönüşümleri yapan, REST tabanlı bir microservice mimarisiyle geliştirilmiş bir Java Spring Boot uygulamasıdır.

---

## 🚀 Özellikler

* Canlı döviz kuru alma (fixer.io entegrasyonu)
* Para birimi dönüştürme (tekli işlem)
* Geçmiş işlem sorgulama (tarih veya işlem ID ile)
* CSV dosyasıyla toplu dönüşüm (bulk upload)
* Swagger UI üzerinden API test desteği
* Docker ile container ortamında çalıştırılabilir

---

## ⚙️ Teknolojiler

* Java 17
* Spring Boot
* Spring Data JPA (H2 in-memory DB)
* Spring Validation
* Swagger / OpenAPI (springdoc-openapi)
* Docker
* Maven

---

## 📦 Build & Çalıştırma

### 1. Maven ile `.jar` üret

```bash
mvn clean package
```

### 2. Docker imajı oluştur

```bash
docker build -t fx-app .
```

### 3. Docker container başlat

```bash
docker run -p 8080:8080 -e FIXER_ACCESS_KEY=your_api_key fx-app
```

> 🔑 **FIXER\_ACCESS\_KEY** ortam değişkeni gereklidir. [https://fixer.io](https://fixer.io) üzerinden API key alın.

---

## 📚 API Endpoint'leri

### 🔹 `GET /api/rates?from=USD&to=TRY`

* Canlı döviz kuru getirir

### 🔹 `POST /api/convert`

```json
{
  "amount": 100,
  "sourceCurrency": "USD",
  "targetCurrency": "TRY"
}
```

→ Dönüştürülmüş tutar ve işlem kimliği döner

### 🔹 `GET /api/history?transactionId=<uuid>`

veya
🔹 `GET /api/history?date=2025-05-31`

### 🔹 `POST /api/convert/bulk`

* CSV dosyası yüklenir (multipart/form-data)
* `amount,sourceCurrency,targetCurrency` formatında satırlar içerir

---

## 🌐 Swagger UI

> Uygulama çalıştıktan sonra şu adresten API’yi test edebilirsin:

```
http://localhost:8080/swagger-ui.html
```

---

## 🧰 Örnek CSV Formatı

```csv
amount,sourceCurrency,targetCurrency
100,USD,TRY
200,EUR,USD
300,GBP,JPY
```

---

## 🗂 Önerilen Proje Yapısı

```
src/
├── controller/
├── dto/
├── service/
├── model/
├── repository/
├── exception/
└── config/
```

---

## ✍️ Geliştiren


Yağmur ORHAN AKSOY

📧 \ mailto:yagmurrorhan@gmail.com
🌍 
