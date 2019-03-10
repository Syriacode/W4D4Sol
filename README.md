# W4D4Sol
*******************  Homework Week 4 Day 4 ******************

Part One:
      Research and answer the following questions:
      1.  How to implement the 4 observables.
      2.  The difference in the 4 observables.
Different Types of Observables:
Standard
Standard is an Observable that always emit any value or throws an error. A typical use case of Standard observable would be when we make a network call in Android and receive a response.
Sample Implementation: We use a Standard Observable and a Single Observer. The Single Observer always emits only once so there is no onNext() .
Maybe
Maybe is an Observable that may or may not emit a value. For example, we would like to know if a particular user exists in our db. The user may or may not exist.
Completable
Completable does not emit any data, but rather is focused on the status of execution — whether successful or failure.
Sample Implementation: Since no data is emitted in Completable, there is no onNext() or onSuccess() . This scenario can be used in cases where PUT api is called and we need to update an existing object to the backend.
Flowable
Flowable is typically used when an Observable is emitting huge amounts of data but the Observer is not able to handle this data emission. This is known as Back Pressure.


       3.  How to implement the rxjava map and flatmap.
Map
Map transforms the items emitted by an Observable by applying a function to each item.
To implement Map: the observable gives us ApiUser object which we are converting into User object by using the map operator.
FlatMap
FlatMap transforms the items emitted by an Observable into Observables.
To implement FlatMap: we are getting the ApiUser and then we are making a network call to get the UserDetail for that apiUser by using the getUserDetailObservable(apiUser). The flatMap returns an observable itself. The getUserDetailObservable is an asynchronous operation.

       4.  The difference in map vs flatmap.
the main difference between Map and FlatMap that FlatMap returns an observable itself, so it is used to map over asynchronous operations.

       5.  What are hot and cold observables.
Cold observables are observables where the data producer is created by the observable itself. For example, observables created using the of, from, range, interval and timer operators will be cold. The data is created from within the observable itself, and there truly is not data being produced until the observable is subscribed to.
Hot observables, on other hand, have their data producer outside the observable itself. These observables are closing over external data producers. For example, observables created with the fromEvent operator for either user events (clicks, mouse moves,…) or WebSocket events are hot observables.

Part 2:
      Complete the flicker challenge.  Use RxJava and retrofit
