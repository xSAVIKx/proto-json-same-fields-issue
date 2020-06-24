package com.github.proto;

import com.google.pubsub.v1.PubsubPushNotification;
import io.spine.json.Json;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Protobuf Deserialization should")
final class ProtoDeserializationTest {

    @Test
    @DisplayName("not throw exceptions if all field names are in `lowerCamelCase` style")
    void deserializeWithLowerCamelCase() {
        Assertions.assertDoesNotThrow(() -> {
            Json.fromJson(CAMEL_CASE_PUBSUB_JSON_PROTO, PubsubPushNotification.class);
        });
    }

    @Test
    @DisplayName("not throw exceptions if all field names are in `snake_case` style")
    void deserializeWithSnakeCase() {
        Assertions.assertDoesNotThrow(() -> {
            Json.fromJson(SNAKE_CASE_PUBSUB_JSON_PROTO, PubsubPushNotification.class);
        });
    }

    @Test
    @DisplayName("throw exception if there is same field in `snake_case` and `lowerCamelCase`")
    void deserializeBothStyles() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Json.fromJson(BOTH_STYLES_PUBSUB_JSON_PROTO, PubsubPushNotification.class);
        });
    }

    private static final String BOTH_STYLES_PUBSUB_JSON_PROTO = "" +
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
    private static final String CAMEL_CASE_PUBSUB_JSON_PROTO = "" +
            "{\n" +
            "  \"message\": {\n" +
            "    \"data\": \"eyJrZXkiOiJ2YWx1ZSJ9\",\n" +
            "    \"messageId\": \"450292511223766\",\n" +
            "    \"publishTime\": \"2020-06-21T20:48:25.908Z\"\n" +
            "  },\n" +
            "  \"subscription\": \"projects/test-project/subscriptions/test-subscription\"\n" +
            "}";

    private static final String SNAKE_CASE_PUBSUB_JSON_PROTO = "" +
            "{\n" +
            "  \"message\": {\n" +
            "    \"data\": \"eyJrZXkiOiJ2YWx1ZSJ9\",\n" +
            "    \"message_id\": \"450292511223766\",\n" +
            "    \"publish_time\": \"2020-06-21T20:48:25.908Z\"\n" +
            "  },\n" +
            "  \"subscription\": \"projects/test-project/subscriptions/test-subscription\"\n" +
            "}";
}
