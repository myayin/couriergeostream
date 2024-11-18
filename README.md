docker-compose up --build komutu ile çalıştırılabilmektedir. 
çalıştırıldıktdan sonra http://localhost:9000/ url'inden distance_tracker topic'i oluşturulmalıdır.

MyStartupEventListener içinde store'lar ve 1 kurye objesi oluşturulmaktadır.

örnek postman collection aşağıdaki folderda bulunmaktadır.
[courierTracker.postman_collection.json](courierTracker.postman_collection.json)

http://localhost:8080/v0/courier/1 kurye sorgulama yapmaktadır
http://localhost:8080/v0/courierDistance kuryenin location'ını bildirmektedir.

