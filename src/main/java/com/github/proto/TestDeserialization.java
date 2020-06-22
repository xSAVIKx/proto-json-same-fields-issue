package com.github.proto;

import com.google.pubsub.v1.PubsubPushNotification;
import io.spine.json.Json;

public final class TestDeserialization {

    public static void main(String[] args) {

        Json.fromJson(PUBSUB_JSON_PROTO, PubsubPushNotification.class);
    }

    private static final String PUBSUB_JSON_PROTO = "" +
            "{\n" +
            "  \"message\": {\n" +
            "    \"data\": \"eyJrZXkiOiJ2YWx1ZSJ9\",\n" +
            "    \"messageId\": \"450292511223766\",\n" +
            "    \"message_id\": \"450292511223766\",\n" +
            "    \"publishTime\": \"2020-06-21T20:48:25.908Z\",\n" +
            "    \"publish_time\": \"2020-06-21T20:48:25.908Z\"\n" +
            "  },\n" +
            "  \"subscription\": \"projects/test-project/subscriptions/test-subscription\"\n" +
            "}";
}
