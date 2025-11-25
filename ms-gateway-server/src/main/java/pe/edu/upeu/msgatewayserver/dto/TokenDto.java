package pe.edu.upeu.msgatewayserver.dto;


import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonPOJOBuilder
@AllArgsConstructor
@Data
public class TokenDto {
    private String token;
}