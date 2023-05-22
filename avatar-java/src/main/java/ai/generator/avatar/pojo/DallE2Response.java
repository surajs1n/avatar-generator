package ai.generator.avatar.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Dall-E2 Response POJO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DallE2Response {
    private long created;

    private List<ImageDetails> data;
}
