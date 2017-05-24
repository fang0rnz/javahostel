package ninfa.javahostel.control;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import ninfa.javahostel.application.BedRegistrationService;
import ninfa.javahostel.domain.Bed;

@Named
@ApplicationScoped
public class BedConverter implements Converter {

	@EJB
	private BedRegistrationService bedRegistrationService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String bedNumber){
		if (bedNumber == null || bedNumber.isEmpty())
			return null;
		
		try {
			return bedRegistrationService.findByNumber(Integer.valueOf(bedNumber));
		}
		catch (Exception e) { //NumberFormatException?

			FacesMessage msg = new FacesMessage(String.format("%s is not a valid bed number", bedNumber));

			throw new ConverterException(msg, e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object bed) {
		if (bed == null)
			return "";
		if (bed instanceof Bed)
			return ((Bed) bed).getNumber().toString();
		return null;
	}
	
	
}
