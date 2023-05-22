package ai.generator.avatar.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dall-E2 Image Details POJO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDetails {
    private String url;
}
