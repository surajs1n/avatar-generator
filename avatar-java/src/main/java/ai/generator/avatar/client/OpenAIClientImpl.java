package ai.generator.avatar.client;

import ai.generator.avatar.pojo.DallE2Request;
import ai.generator.avatar.pojo.DallE2Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class OpenAIClientImpl implements OpenAIClient {
    private static final String OPEN_AI_URL = "https://api.openai.com";
    private static final String CREATE_IMAGE = "/v1/images/generations";
    private static final MediaType JSON = MediaType.parse("application/json");
    private static final DallE2Response DEFAULT_DALL_E2_RESPONSE = DallE2Response.builder().build();
    private static final String DEFAULT_JSON_OBJECT = "{}";

    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public OpenAIClientImpl() {
        this.httpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public DallE2Response generateImage(final DallE2Request dallE2Request, final String openAIToken) {
        final String createImageURL = OPEN_AI_URL + CREATE_IMAGE;
        final String bearerToken = "Bearer " + openAIToken;

        String jsonString = DEFAULT_JSON_OBJECT;
        try {
            jsonString = objectMapper.writeValueAsString(dallE2Request);
        } catch (JsonProcessingException e) {
            System.err.println("[OpenAIClientImpl] Error parsing dallE2Request");
        }

        final RequestBody body = RequestBody.create(JSON, jsonString);
        final Request request = new Request.Builder()
                .url(createImageURL)
                .method("POST", body)
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", bearerToken)
                .build();

        try (final Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                final String jsonResponse = response.body().string();
                return objectMapper.readValue(jsonResponse, DallE2Response.class);
            } else {
                System.err.println("[OpenAIClientImpl] "+ response.body().string());
            }
        } catch (IOException e) {
            System.err.println("[OpenAIClientImpl] Error receiving dallE2Response");
        }

        return DEFAULT_DALL_E2_RESPONSE;
    }
}
