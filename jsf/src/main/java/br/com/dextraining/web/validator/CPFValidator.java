package br.com.dextraining.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cpfValidator")
public class CPFValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		System.out.println(value);
		if (((String)value).equals("asd")) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no valor", "Valor invalido");
			throw new ValidatorException(message);
		}
	}

}
