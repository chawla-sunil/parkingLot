package request.operation;

public class FileBasedOperationRequest extends OperationRequest {

    private String filePath;

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
}

