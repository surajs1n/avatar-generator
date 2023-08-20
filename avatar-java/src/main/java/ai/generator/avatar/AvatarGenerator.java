package ai.generator.avatar;

import ai.generator.avatar.model.input.AvatarGeneratorInput;
import ai.generator.avatar.model.output.AvatarGeneratorOutput;
import ai.generator.avatar.processor.AvatarGeneratorProcessor;

/**
 * Entry-point of Avatar Generator library
 */
public class AvatarGenerator {
    private static AvatarGenerator AVATAR_GENERATOR_INSTANCE = null;

    private final AvatarGeneratorProcessor processor;

    private AvatarGenerator() {
        this.processor = AvatarGeneratorProcessor.getInstance();
    }

    public static AvatarGenerator getInstance() {
        if (AVATAR_GENERATOR_INSTANCE == null) {
            AVATAR_GENERATOR_INSTANCE = new AvatarGenerator();
        }

        return AVATAR_GENERATOR_INSTANCE;
    }

    /**
     * Main function to generate avatar for user inputs.
     * @param input - {@link AvatarGeneratorInput} is a user defined input.
     * @return {@link AvatarGeneratorOutput} generated images details
     */
    public AvatarGeneratorOutput generateImages(final AvatarGeneratorInput input) {
        return processor.generateImages(input);
    }
}
