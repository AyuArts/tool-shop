# BR_PROFILE_01 — Помилка оновлення профайлу з авторизацією клієнта OAuth 

ID: BR_PROFILE_01
siverity: 🟥 CRITICAL

> [!preconditions] 
>  - Користувач виконує TC_LOGIN_03


| Step | Action                            | Expected Result                                                 | Actual result                       |
| ---- | --------------------------------- | --------------------------------------------------------------- | ----------------------------------- |
| 1    | Користувач виконує TC_PROFILE_002 | ✅ Дані зберігаються, з’являється повідомлення `Profile updated` | ❌ помилка 422 данні не зберігаються |

## Attachments

- videos: [Jam_video](https://jam.dev/c/d872337f-12b7-4d58-9b7b-d46f70765b04)
- screenshots: [Jam_screenshots](https://jam.dev/c/636a568d-4cb5-46c0-8df4-d507cd51e1e6)

<span style="background:#ff4d4f">waiting for fix</span> 

# BR_PROFILE_02 — Помилка оновлення профайлу з (через стандартну реєстрацію)

ID: BR_PROFILE_02
siverity: 🟨 Middle

> [!preconditions] 
>  - Користувач виконує реєстрацію кабінету та вхід через https://practicesoftwaretesting.com/auth/login


| Step | Action                                   | Expected Result            | Actual result                   |
| ---- | ---------------------------------------- | -------------------------- | ------------------------------- |
| 1    | Користувач виконує крок 1 TC_PROFILE_001 | ✅ Всі поля відображаються` | ❌ відсутнє поле дати народження |

## Attachments

- screenshots: [Jam_screenshots](https://jam.dev/c/8bfcfad1-aef3-422e-8e14-3fc3671ac4cf)

<span style="background:#ff4d4f">waiting for fix</span> 


# BR_PROFILE_03 — Зміна пароля (через Google OAuth)

ID: BR_PROFILE_03
siverity: 🟨 Middle

> [!preconditions] 
>  - Користувач виконує TC_LOGIN_03 

| Step | Action                            | Expected Result                  | Actual result        |
| ---- | --------------------------------- | -------------------------------- | -------------------- |
| 1    | Користувач виконує TC_PROFILE_004 | ❌ Секція прихована або неактивна | ❌ Секція є і активна |

## Attachments

- videos: [Jam_video](https://jam.dev/c/7adcf78a-1790-4675-88c3-05a4e7440ef4)

<span style="background:#ff4d4f">waiting for fix</span> 

---

# BR_PROFILE_04 — Зміна пароля (реєстрація через сайт)

ID: BR_PROFILE_04
siverity: 🟨 Middle

> [!preconditions] 
>  - Користувач виконує реєстрацію через форму https://practicesoftwaretesting.com/auth/register
>  - та користувач виконує логін на сайті з цими данами https://practicesoftwaretesting.com/auth/login

| Step | Action                                   | Expected Result                     | Actual result                         |
| ---- | ---------------------------------------- | ----------------------------------- | ------------------------------------- |
| 1    | Користувач виконує TC_PROFILE_003 крок 5 | ✅ Повідомлення про помилки зникають | ❌ Система не скидує попередню помилку |

## Attachments

- videos: [Jam_video](https://jam.dev/c/f0a4219e-43c4-48ee-bd46-cf00c90a5f78)

<span style="background:#ff4d4f">waiting for fix</span> 

---

# BR_PROFILE_05 — Помилка налаштування 2FA (двофакторна автентифікація)

ID: BR_PROFILE_05
siverity: 🟥 CRITICAL

> [!preconditions] 
>  - Користувач виконує TC_REG_01
>  - Користувач виконує TC_LOGIN_01 крок 4

| Step | Action                                   | Expected Result                                                | Actual result       |
| ---- | ---------------------------------------- | -------------------------------------------------------------- | ------------------- |
| 1    | Користувач виконує TC_PROFILE_006 крок 4 | ✅ З’являється повідомлення `Two-Factor Authentication enabled` | ❌ invalid TOTP code |

## Attachments

- videos: [Jam_video](https://jam.dev/c/8b1e12b2-17a8-430e-a299-8a6734603c14)

<span style="background:#ff4d4f">waiting for fix</span> 




## **BR_CONTACT_001 — Розтягування полів введення в Contact формі**

**ID:** BR_CONTACT_001  
**Severity:** 🟩 Low  


> [!preconditions]  
> – Користувач знаходиться на сторінці Contact

|Step|Action|Expected Result|Actual Result|
|---|---|---|---|
|1|Навести курсор на textarea `Message`|✅ Поле не має resize-функціоналу|❌ Можна розтягнути вниз або в сторони|
|2|Спробувати розтягнути мишею|✅ Неможливо|❌ Поле розтягується, ламає візуал форму|

### Description:

Textarea для повідомлення на сторінці Contact має можливість вільного масштабування користувачем. Це може порушити загальний вигляд верстки.

> ✅ Expected behavior:  
> Поле має бути з `resize: none` у CSS.


## Attachments

- videos: [Jam_video](https://jam.dev/c/f6c43d11-f3e8-4d39-9fe7-7b7d6026612f)


<span style="background:#ff4d4f">waiting for fix</span> 

