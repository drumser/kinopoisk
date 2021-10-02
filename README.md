# Описание
Приложение на Spring Boot. Желательно Kotlin. Но можно и Java.

1) делаем проект (тут поможет https://start.spring.io/)
2) делаем там rest-controller у которого есть метод get
3) при вызове его надо сделать гет запрос на внешний урл
   https://api.ott.kinopoisk.ru/v12/selections?itemsLimit=10&pageId=subscriptions&selectionWindowId=ya_plus&selectionsLimit=10&selectionsOffset=0&serviceId=25

4) там в ответе надо найти collections (это list). В нем найти  объект с
   title: "Топ-10 за месяц"
   type: "OTT_TOP"

5) отдать "наружу" топ 10 фильмов

# Дополнение
Добавить стратегии получения топ фильмов
