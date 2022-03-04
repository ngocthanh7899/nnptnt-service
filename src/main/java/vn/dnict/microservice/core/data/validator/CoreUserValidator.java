package vn.dnict.microservice.core.data.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vn.dnict.microservice.core.dao.model.CoreUser;
import vn.dnict.microservice.core.dao.service.CoreUserService;
import vn.dnict.microservice.core.data.CoreUserData;

@Component
public class CoreUserValidator implements Validator {
	@Autowired
	protected MessageSource messageSource;
	@Autowired
	protected CoreUserService coreUserService;

	@Override
	public boolean supports(Class<?> clazz) {
		return CoreUserData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CoreUserData object = (CoreUserData) target;
		if (checkMaExits(object.getId(), object.getEmail())) {
			errors.rejectValue("email", "error.email", new Object[] { "email" }, "Email đã tồn tại");
		}
	}

	public boolean checkMaExits(Long id, String email) {
		boolean check = false;
		List<CoreUser> listCoreUser = new ArrayList<>();
		if (Objects.nonNull(id) && id > 0) {
			listCoreUser = coreUserService.findByIdAndEmailIgnoreCaseAndDaXoa(id, email, false);
			if (Objects.nonNull(listCoreUser) && !listCoreUser.isEmpty()) {
				check = false;
			} else {
				listCoreUser = coreUserService.findByEmailIgnoreCaseAndDaXoa(email, false);
				if (Objects.nonNull(listCoreUser) && !listCoreUser.isEmpty()) {
					check = true;
				}
			}
		} else {
			listCoreUser = coreUserService.findByEmailIgnoreCaseAndDaXoa(email, false);
			if (Objects.nonNull(listCoreUser) && !listCoreUser.isEmpty()) {
				check = true;
			}
		}
		return check;
	}
}
