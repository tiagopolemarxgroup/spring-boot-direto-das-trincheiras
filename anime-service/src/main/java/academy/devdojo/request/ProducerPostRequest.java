package academy.devdojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducerPostRequest {
    @JsonProperty(value = "full_name")
    private String name;

}
