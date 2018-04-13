/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.managedbean;


import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Locale;
import mazadna.dal.entities.*;
import mazadna.dao.ItiMazadnaUserFacade;

/**
 *
 * @author Eman-PC
 */
@Named(value = "user")
@SessionScoped
public class UserBean {

    @Inject
    private ItiMazadnaUserFacade itiMazadnaUserFacade;

    ItiMazadnaUser currentUser;
    private String locale = "ar";

    public UserBean() {
    }

    public String checkLogin() {
        return null;
//        String page;
//        currentUser = new ServiceHandler().checkLogin(email, password);
//        if (currentUser != null) {
//            page = "index";
//        } else {
//            page = "login";
//        }
//        return page;
    }

    public String register() {
        itiMazadnaUserFacade.create(currentUser);
        return "index";
    }

//    public void validateEmail(FacesContext context, UIComponent component, Object obj) {
//        String regexEmail
//                = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
//
//        String enteredEmail = (String) obj;
//        if (!enteredEmail.matches(regexEmail)) {
//            //if user email does not match the regex
//            FacesMessage message = new FacesMessage("Validation error", "Invalid Format of Email");
//            message.setSeverity(FacesMessage.SEVERITY_ERROR);
//            throw new ValidatorException(message);
//        }
//    }

    public String changeLocaleMethod() {
        if (locale.equals("ar")) {
            locale = "en_US";
        } else {
            locale = "ar";
        }
        Locale localeObj = new Locale(locale);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(localeObj);
        return null;
    }

    public ItiMazadnaUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(ItiMazadnaUser currentUser) {
        this.currentUser = currentUser;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

}
