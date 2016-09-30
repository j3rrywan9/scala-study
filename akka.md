# Akka

In the actor model, an actor is concurrency primitive;
more simply stated, an actor can be thought of as a worker like a process or thread that can do work and take action.

## Actors and Message passing

Actors diff from objects in that they cannot be directly read, changed, and invoked.
Instead, Actors can only communicate with the world outside of them through message passing.
Message passing simply means that an actor can be sent a message (object in our case) and can, itself, send messages or
reply with a message.
An actor begins processing a message, and replies to the message, on its own terms when it is ready.

The actor processes messages one at a time, synchronously.
The mailbox is essentially a queue of work outstanding for the worker to process.
When an actor processes a message, the actor can respond by changing its internal state, creating more actors, or
sending more messages to other actors.

The term *Actor System* is often used in implementations to describe a collection of actors and everything related to
them including addresses, mailboxes, and configuration.

To iterate these key concepts:
* Actor
* Message
* Message-passing
* Mailing address
* Mailbox
* Actor system

It might not be obvious yet, but the Actor Model is much easier to reason about than imperative object oriented
concurrent applications.

The next benefit to the Actor Model is elimination of shared state.
If you treat all messages as immutable, then you can effectively eliminate shared state in your actor system and build
safer applications.

Akka clusters was introduced recently which allows an actor system to span multiple machines transparently, and Akka IO
and Akka HTTP are now in the core libraries to help use interact with other systems more easily.
