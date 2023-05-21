package ai.generator.avatar.model.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Avatar generator output class
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvatarGeneratorOutput {
    private List<AvatarDetails> avatarList;

    private long createdAt;
}
