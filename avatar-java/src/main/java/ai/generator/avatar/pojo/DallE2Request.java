package ai.generator.avatar.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dall-E2 Request POJO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DallE2Request {
    private String prompt;
    private int n;
    private String size;
    private String response_format;
    private String user;

    @Override
    public String toString() {
        return "DallE2Request{" +
                "prompt='" + prompt + '\'' +
                ", n=" + n +
                ", size='" + size + '\'' +
                ", response_format='" + response_format + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
