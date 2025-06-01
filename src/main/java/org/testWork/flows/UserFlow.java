package org.testWork.flows;

import com.google.inject.Inject;
import org.testWork.pages.PageCart;
import org.testWork.pages.PageHome;
import org.testWork.pages.PageLogin;
import org.testWork.pages.PageRegister;

public class UserFlow {

    @Inject
    private PageRegister pageRegister;

    @Inject
    private PageLogin pageLogin;

    @Inject
    private PageHome pageHome;

    @Inject
    private PageCart pageCart;

    public String addToCart() {
        pageHome.openPage();
        pageHome.addGoodToCart();
        return pageHome.getTextNotification();
    }

    public void placeAnOrder(String firstName,
                             String lastName,
                             String street,
                             String postalCode,
                             String city,
                             String state) {
        String country = "US";
        pageCart.openPage();
        assert pageCart.checkTotalPrice() : "Total price is not correct";
        pageCart.goToNextStep(1);
        assert pageCart.checkHelLo(firstName, lastName);
        pageCart.goToNextStep(2);
        assert pageCart.checkBillingAddress(street, postalCode, city, state, country);
        pageCart.goToNextStep(3);
        pageCart.setPayment("Cash on Delivery");
        pageCart.submit();
        assert pageCart.Accept();
        pageCart.submit();


    }

    public void registerAndLogin(String firstName,
                                 String lastName,
                                 String dateOfBirth,
                                 String email,
                                 String telephone,
                                 String password,
                                 String street,
                                 String postalCode,
                                 String city,
                                 String state,
                                 String country) {
        pageRegister.openPage();
        pageRegister.fillRegisterForm(firstName, lastName, dateOfBirth, email,
                telephone, password, street, postalCode, city, state, country);
        pageRegister.submitRegister();
        pageLogin.openPage();
        pageLogin.fillLoginForm(email, password);
        pageLogin.submitLogin();

    }

}
