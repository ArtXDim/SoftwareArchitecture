Архитектура ПО (семинары)
Урок 8. Типы архитектур прикладных приложений (мобильные): MVC, MVP, MVVM.
Разработать полную ERD:

Необходимо спроектировать сервис бронирования столика в ресторане. C полями ввода данных о пользователе и заказе, возможностью выбора столика и с кнопкой подтверждения заказа.

Model

Работа с данными: запрос, сохранение или изменение данных в БД или файлах.

Реализовать три метода, которые вызываются презентером:loadTabels - получение списка всех столиков со статусом (свободно, забронировано);bookTable – бронирование столика;changeTable – поменять бронь столика.

Presenter вызывает эти методы и он не знает как эти методы реализованы в Model

View

Отвечает за отображение данных на экране и за обработку действий пользователя.

Здесь резализованы методы, вызываемые Presenter:showTables - отображение списка столиков;getUserInfo – сбор данных о пользователе (имя, номер телефона, время, количество персон)

Во View не должно быть никакой логики. View это способ вывода данных (UI) и взаимодействия (UX) с пользователем.

Действия пользователя передаются в Presenter. По нажатию кнопки  «подтверждения заказа», View сразу сообщает об этом Presenter. Presenter принимает это к и действует по своему алгоритму.

Presenter

Является связующим звеном между View и Model, которые не должны общаться напрямую.

От View Presenter получает данные о том, какие кнопки были нажаты пользователем, и решает, как отреагировать на эти нажатия. Если надо что-то отобразить, то Presenter сообщает об этом View. А если нужно сохранить/получить данные, Presenter использует Model.

Шаги взаимодействия View, Presenter и Model:

Presenter просит Model дать ему данные из БД о занятости столиков.
Presenter просит View показать данные о столиках.
Пользователь выбирает подходящий столик и вводит свои данные в поля ввода. Это не обрабатывается и ничего не происходит.
Пользователь жмет кнопку «подтверждения заказа».
View сообщает Presenter о том, что была нажата кнопка «подтверждения заказа».
Presenter просит View дать ему данные, которые были введены пользователем в поля ввода.
Presenter проверяет эти данные на корректность.
Если они некорректны, то Presenter просит представление показать сообщение об этом.
Если данные корректны, то Presenter просит представление показать прогресс-бар и просит Model добавить данные в базу данных.
Model выполняет вставку данных и сообщает Presenter, что вставка завершена.
Presenter просит представление убрать прогресс-бар.
Presenter запрашивает данные о подтверждении бронирования у Model.
Model возвращает данные Presenter.
Presenter просит View показать новые данные.
Presenter управляет всем происходящим. Он указыват View и Model что делать и как реагировать на действия пользователя.