package utils;

public class DataRecord {
    private int id;
    private String tokenId;
    private String context;
    private String updatedAt;



    public DataRecord(int id, String token, String context, String updatedAt) {
        this.id = id;
        this.tokenId = String.valueOf(token);
        this.context = context;
        this.updatedAt = updatedAt;
    }

    // Геттеры и сеттеры (если нужны)
    public int getId() {
        return id;
    }

    public String getToken() {
        return tokenId;
    }

    public String getContext() {
        return context;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }


    @Override
    public String toString() {
        return "ID: " + id + ", UpdatedAt: " + updatedAt + ", Token: " + tokenId + ", Context: " + context;
    }
}