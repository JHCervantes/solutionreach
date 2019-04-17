# Solutionreach QA exam
#### Scenario:
1) Go to https://www.smilereminder.com/sr/login.jsp
2) Enter invalid credentials
3) Assert errors displayed

## Install
`mvn clean install -D skipTests=true`

## Running the tests
1) `mvn clean test` - (Defaults to Chrome browser)
2) `mvn clean test -D browser=chrome`
3) `mvn clean test -D browser=firefox`

## Built With
* Maven
* TestNG
* Java

## Authors
* [Jesus Cervantes](mailto:jhcervantesjr@gmail.com)