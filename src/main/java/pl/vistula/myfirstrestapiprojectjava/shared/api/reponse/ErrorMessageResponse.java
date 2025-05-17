package pl.vistula.myfirstrestapiprojectjava.shared.api.reponse;

public class ErrorMessageResponse {
    private final String message;

    public ErrorMessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
