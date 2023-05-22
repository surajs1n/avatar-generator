package ai.generator.avatar.model.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Avatar generator input class
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvatarGeneratorInput {
    private String openAIToken;
    private String description;
    @Builder.Default
    private int numberOfImages = 1;
    @Builder.Default
    private ImageResolution imageResolution = ImageResolution.H_1024_W_1024;
}
