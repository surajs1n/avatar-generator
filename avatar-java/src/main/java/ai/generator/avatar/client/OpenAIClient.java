package ai.generator.avatar.client;

import ai.generator.avatar.pojo.DallE2Request;
import ai.generator.avatar.pojo.DallE2Response;

/**
 * OpenAI client contains all the contracts related to connecting with OpenAI servers.
 */
public interface OpenAIClient {

    /**
     * Function to generate runtime image based on user-description.
     *
     * @param dallE2Request - {@link DallE2Request} contains user inputs.
     * @param openAIToken - Auth token to use OpenAI APIs.
     * @return {@link DallE2Response} contains generated images details.
     */
    DallE2Response generateImage(final DallE2Request dallE2Request, final String openAIToken);
}
