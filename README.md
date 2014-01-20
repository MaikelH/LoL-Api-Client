LoL-Api-Client
--------------

Scala client for the RIOT games API.

### Build status
[![Build Status](https://travis-ci.org/MaikelH/LoL-Api-Client.png?branch=master)](https://travis-ci.org/MaikelH/LoL-Api-Client)

### Dependencies

* spray-json 1.2.5,
* dispatch-core 0.11.0
* json-lenses 0.5.4

### Features

* All calls are async using futures
* No mutable state

### Usage

```scala
  // Define implicit apikey
  implicit object key extends ApiKey {
    def getKey(): String = "KEY-HERE"
  }
  // Do the call
  val result = StatsService.GetRankedStats(Region.euw, 27924423)

  // Handle future result
  sum.onComplete {
    case Success(resp) => println(resp)
    case Failure(t) => println(t.getMessage)
  }
```

