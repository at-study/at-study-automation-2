#language: ru

Функция: Вход администратором. Проверка элемента "Моя учётная запись"

  Предыстория:
    Пусть Имеется список E-Mail адресов "СПИСОК_EMAIL_АДРЕСОВ":
      | Адрес           | По умолчанию | Уведомления |
      | first@email.ru  | true         | true        |
      | second@email.ru | false        | true        |
      | third@email.ru  | false        | true        |
      | fourth@email.ru | false        | true        |
    Пусть В системе создан пользователь "ПОЛЬЗОВАТЕЛЬ" со следующими параметрами:
      | Администратор                | true                                  |
      | Статус                       | Активен                               |
      | Уведомления о новых событиях | О всех событиях во всех моих проектах |
      | E-Mail                       | СПИСОК_EMAIL_АДРЕСОВ                  |
    И Открыт браузер на главной странице

  @ui
  @blocked
  Сценарий: Вход администратором. Проверка элемента "Моя учётная запись"
    Если Нажать кнопку Войти
    И Войти в систему под пользователем "ПОЛЬЗОВАТЕЛЬ"
    Тогда Текст элемента моей учетной записи - "Моя учётная запись"