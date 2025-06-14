# TC_PRODUCT_CARD_001 — Перевірка картки товару

**Мета:** Перевірити, що сторінка картки товару відображає всі необхідні дані, включаючи назву, опис, фото, доступність, та дозволяє додати товар у кошик.

ID: TC_CART_001
priority: 🟥 CRITICAL

> [!preconditions]
>- Користувач має доступ до будь-якого товару через категорії або пошук

| Крок | Дія                                                       | Очікуваний результат                                                    |
| ---- | --------------------------------------------------------- | ----------------------------------------------------------------------- |
| 1    | Відкрити картку товару з каталогу/категорії               | ✅ Назва товару відображається та відповідає категорії                   |
| 2    | Перевірити блок із зображенням                            | ✅ Фото завантажується, є можливість перегляду галереї (якщо є декілька) |
| 3    | Перевірити опис, ціну, технічні характеристики            | ✅ Дані коректні, опис не обрізаний, валюта відображається правильно     |
| 4    | Перевірити кнопку `Add to Cart`                           | ✅ Кнопка присутня, натискання додає товар у кошик                       |
| 5    | Перевірити індикатор наявності (Available / Out of stock) | ✅ Відображається актуальний статус наявності товару                     |
| 6    | Додати товар у кошик та перевірити повідомлення           | ✅ З’являється повідомлення `Товар додано`, лічильник кошика оновлюється |

**Статус:**  
✅ Passed 