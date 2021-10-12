#language: ru

@all
Функционал: Ипотека

  @firstTest
  Сценарий: Ипотека на готовое жилье и проверка ошибок при незаполненных полях
    * Закрытия сообщения cookies
    * Выбираем "Ипотека" в главном меню и "Ипотека на вторичное жильё" в подменю
    * Проверяем что открылась страница 'Ипотека на готовые квартиры'
    * Заполняем поля формы:
      | Первоначальный взнос   | 3 058 000 |
      | Стоимость недвижимости | 5 180 000 |
    * Поставить галочку "Молодая семья"
    * Поставить галочку "Страхование жизни и здоровья"
    * Подождать загрузку данных
    * Проверить расчет рубли
      | Ежемесячный платеж | 16 922    |
      | Сумма кредита      | 2 122 000 |
      | Необходимый доход  | 21 784    |
    * Проверить расчет проценты
      | Процентная ставка  | 11        |