package vn.dnict.microservice.uaa.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ChangePasswordInput {
	@NotBlank(message = "{validation.NotBlank}")
	private String email;
	@NotNull(message = "{validation.NotNull}")
	private String newPass;

}
