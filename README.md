![alt text](https://travis-ci.org/barteksiewniak/WebShop.svg?branch=master)

## WebShop

This is a simple online webshop project who will have in the nearest future all necessary functions of shop.

## Motivation

It's bringed up to life, because we want to get involved in webdev ( mainly backend site ), wanna preserve theory knowledge by practice.

## Installation

Project installation is very simple, all you have to do is to put in servlet container ( Tomcat for example ), no matter how you do it, by IDE or manually.<br>
Next step is to configure database on your side, same as in file database.properties.

jdbc.driverClassName=org.postgresql.Driver
jdbc.url=jdbc:postgresql://localhost:5432/your_schema
jdbc.username=login
jdbc.password=password

Build working on Postgres, so if you want to swap database to another - you also have to remember about change the sql connector in pom.xml and dialect in application.properties.

## Contributors

If you wanna participate in it, contact with us, still is huge amount of work to do, especially with front-end and testing.

## License

The MIT License (MIT)
Copyright (c) 2016 Bartosz Siewniak "barteksiewniak", Konrad "kkdrz"

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
