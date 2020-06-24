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
        String camelCasePubsubJsonProto = "" +
                "{\n" +
                "  \"message\": {\n" +
                "    \"data\": \"eyJrZXkiOiJ2YWx1ZSJ9\",\n" +
                "    \"messageId\": \"450292511223766\",\n" +
                "    \"publishTime\": \"2020-06-21T20:48:25.908Z\"\n" +
                "  },\n" +
                "  \"subscription\": \"projects/test-project/subscriptions/test-subscription\"\n" +
                "}";
        Assertions.assertDoesNotThrow(() -> {
            Json.fromJson(camelCasePubsubJsonProto, PubsubPushNotification.class);
        });
    }

    @Test
    @DisplayName("not throw exceptions if all field names are in `snake_case` style")
    void deserializeWithSnakeCase() {
        String snakeCasePubsubJsonProto = "" +
                "{\n" +
                "  \"message\": {\n" +
                "    \"data\": \"eyJrZXkiOiJ2YWx1ZSJ9\",\n" +
                "    \"message_id\": \"450292511223766\",\n" +
                "    \"publish_time\": \"2020-06-21T20:48:25.908Z\"\n" +
                "  },\n" +
                "  \"subscription\": \"projects/test-project/subscriptions/test-subscription\"\n" +
                "}";
        Assertions.assertDoesNotThrow(() -> {
            Json.fromJson(snakeCasePubsubJsonProto, PubsubPushNotification.class);
        });
    }

    @Test
    @DisplayName("throw exception if there is same field in `snake_case` and `lowerCamelCase`")
    void deserializeBothStyles() {
        String bothStylesPubsubJsonProto = "" +
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Json.fromJson(bothStylesPubsubJsonProto, PubsubPushNotification.class);
        });
    }
}
