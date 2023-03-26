# КПО - Домашнее задание №3

## Агенты и мультиагентовая система.
## Авторы: 
- Демьяненко Виктор Николаевич (БПИ217)
- Зиганшин Шамиль Асхатович (БПИ217)

## Предисловие
ДЗ№3 мы выполняли вдвоем. Каждый выполнял работу в своей ветке, затем важные изминения были смерджены в основную ветку.
Изначально мы хранили config.txt, чтобы корректно запускать проблему, но из-за этого возникали сложности при запуске программы.
Было принятно решение запускать агентов в main().

## Глоссарий
Сейчас я покажу как отображается каждый из вид запроса и как удобно отслеживать систему.

- |------| - постеители ресторана.
- <------> - супервайзеры. 
- !---ORDER---! - заказы.
- [---MESSAGE--] - сообщение от агентов.

## Пример вывода

```
<---Supervisor--->
ID: Supervisor@192.168.56.1:1099/JADE
<------>

|---Visitor1---|
 Welcome!
 Start time: 2023-02-28T10:12:37 
 End time: 2023-02-28T10:13:05 
 Ord total: - 118
|------|

!--- ORDER ---!
From: Visitor1
Order: 625;28
!------!
```

