package ai.generator.avatar.processor;

import ai.generator.avatar.client.OpenAIClient;
import ai.generator.avatar.client.OpenAIClientImpl;
import ai.generator.avatar.model.input.AvatarGeneratorInput;
import ai.generator.avatar.model.output.AvatarDetails;
import ai.generator.avatar.model.output.AvatarGeneratorOutput;
import ai.generator.avatar.pojo.DallE2Request;
import ai.generator.avatar.pojo.DallE2Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvatarGeneratorProcessor {

    private static AvatarGeneratorProcessor AVATAR_GENERATOR_PROCESSOR_INSTANCE = null;

    private final OpenAIClient openAIClient;

    private AvatarGeneratorProcessor() {
        this.openAIClient = new OpenAIClientImpl();
    }

    public static AvatarGeneratorProcessor getInstance() {
        if (AVATAR_GENERATOR_PROCESSOR_INSTANCE == null) {
            AVATAR_GENERATOR_PROCESSOR_INSTANCE = new AvatarGeneratorProcessor();
        }

        return AVATAR_GENERATOR_PROCESSOR_INSTANCE;
    }

    public AvatarGeneratorOutput generateImages(final AvatarGeneratorInput input) {
        final DallE2Request dallE2Request = DallE2Request.builder()
                .prompt(input.getDescription())
                .n(input.getNumberOfImages())
                .size(input.getImageResolution().getValue())
                .build();
        
        final DallE2Response response = openAIClient.generateImage(dallE2Request, input.getOpenAIToken());

        List<AvatarDetails> avatarList = new ArrayList<>();
        if (response != null && response.getData() != null) {
            avatarList = response.getData()
                    .stream()
                    .map(imageDetails -> AvatarDetails.builder().avatarUrl(imageDetails.getUrl()).build())
                    .collect(Collectors.toList());
        }
        
        return AvatarGeneratorOutput.builder()
                .createdAt(response != null ? response.getCreated() : 0)
                .avatarList(avatarList)
                .build();
    }
}
