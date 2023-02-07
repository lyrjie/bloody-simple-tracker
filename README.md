Начальное состояние android проекта, минимально готовое к разработке  
Склонировать, пройтись по всем TODO и пользоваться  
Что включено:  
* Firebase Crashlytics  
* Базовая Compose тема
* Опциональный Room ([переключатель тут](buildSrc/src/main/java/General.kt))  
* BuildSrc с прописанными самыми часто используемыми зависимостями  
* Основные используемые BuildTypes (debug/qa/demo/release) с фреймворком для прокидывания переменных окружения в BuildConfig
* Hilt и пара основных @Provides методов
* GitLab CI/CD
* Signing config
* Gradle скрипты мигрированы на .kts
* Основные базовые классы (Clean, Text и тд)
