Json2Proto deserialization issue
----------

A companion repo for the issue https://github.com/protocolbuffers/protobuf/issues/7641.

The problem is that `JsonFormat.Parser` is not able to process
a JSON object when a particular field is present in both
`lowerCamelCase` and `snake_case` notations:

```json

{
  "message": {
    "data": "eyJrZXkiOiJ2YWx1ZSJ9",
    "messageId": "450292511223766",
    "message_id": "450292511223766",
    "publishTime": "2020-06-21T20:48:25.908Z",
    "publish_time": "2020-06-21T20:48:25.908Z"
  },
  "subscription": "projects/test-project/subscriptions/test-subscription"
}

```

The example above is a PubSub push notification that Google PubSub service sends 
using push subscriptions.

See more examples in [`ProtoDeserializationTest`](src/test/java/com/github/proto/ProtoDeserializationTest.java).

## How to build

1. Install JDK11.
2. Configure JDK11 as JVM for Gradle (add to Path, set JAVA_HOME, etc.).
3. Run `./gradlew`.
