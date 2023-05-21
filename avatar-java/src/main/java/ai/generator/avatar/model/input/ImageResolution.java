package ai.generator.avatar.model.input;

public enum ImageResolution {
    H_256_W_256("256x256"),
    H_512_W_512("512x512"),
    H_1024_W_1024("1024x1024");

    private String value;

    ImageResolution(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
