# Staz_Application
Android application build for Azimo Internship Task.

It is a simple Android application that uses Github REST API in order to get some basic data from Github and display it in application for user to see.

My solution uses popular Android API  - Retrofit that is used as a type-safe HTTP client. I've decided to use it because I thought that there is no need to reinvent the wheel and I can focus of different aspects of this application when using already working API for networking.

In this project I also used Parcel that creates Paracetables that are send between Activities. I used it because Paracetables are the fastest way of transfering data between activities and Parcel already provides a way to create Paracetables in no time.

Data is shown using RecyclerView, which is more advenced version of ListView and in my opinion one of the best ways of managing data in Android. 
