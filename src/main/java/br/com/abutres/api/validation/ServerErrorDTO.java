package br.com.abutres.api.validation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class ServerErrorDTO {

    @JsonIgnore
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private HttpStatus httpStatus;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("description")
    private String description;

    public ServerErrorDTO(
            @JsonProperty("code") String code,
            @JsonProperty("message") String message,
            @JsonProperty("description") String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public ServerErrorDTO() {
        code = "503";
        message = "Something bad happened :(";
        description = "More details about the error here";
    }

}
