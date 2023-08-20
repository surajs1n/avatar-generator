package ai.generator.avatar;

import ai.generator.avatar.model.input.AvatarGeneratorInput;
import ai.generator.avatar.model.input.ImageResolution;
import ai.generator.avatar.model.output.AvatarGeneratorOutput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AvatarGeneratorTest {

    private static AvatarGenerator avatarGenerator;

    @BeforeAll
    static void beforeAll() {
        avatarGenerator = AvatarGenerator.getInstance();
    }

    @Test
    void generateGenerateEmptyResponseWithInvalidToken() {
        AvatarGeneratorInput input = AvatarGeneratorInput.builder()
                .openAIToken("invalid token")
                .description("unicorn running on mars")
                .imageResolution(ImageResolution.H_256_W_256)
                .build();

        final AvatarGeneratorOutput output = avatarGenerator.generateImages(input);

        assertNotNull(output);
        assertEquals(0, output.getAvatarList().size());
    }
}