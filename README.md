# standard-Android-app
standard Android app it's an Android application that gather a bunch of useful library together into a standard application , in witch helps you be more productive and fast coder , it contains the best ranking library like Retrofit for http client networking and Dagger v2 for dependencies injection and so on, read all the article for the details and to get start using the app .

## Top libraries :
Standard Android app uses these library for it's architect:

### 1) Multidex support
Multi dex support is used to avoid the 64K reference limit problem , read this for more details https://developer.android.com/studio/build/multidex

### 1) Dagger 2
dagger is a library for instantiating classes and provide theme as a singeltone object , check this link for more info about this library 
https://dagger.dev/android.html

### 2) Retrofit
Retrofit is a REST Client for Java and Android it provides an easy way to retrieve and upload JSON (or other structured data) via a REST based webservice, check the documentation of retrofit for more details
https://square.github.io/retrofit/

### 3) ButterKnife
ButterKnif is an android library provides an easy way to bind views with java/kotlin properties , official doc https://jakewharton.github.io/butterknife/

### 4) Anko library 
Anko is a Kotlin library which makes Android application development faster and easier , check this for more details https://www.kotlindevelopment.com/why-should-use-anko/

## Application architecture
the architecture of Standard android app is very sipmle , 
1) dagger produce a singletone objects and injects theme as modules to it's componentes
2) SuperActivity and SuperFramgent are tow app componentes that host the dagger dependency injection
3) make SuperActivity the super class of all the activities so all the activities can acess these modules and the same with    SuperFragment


![alt text](https://github.com/ayoubElhoucine/standard-Android-app/blob/master/Standard_Android_App.png)
