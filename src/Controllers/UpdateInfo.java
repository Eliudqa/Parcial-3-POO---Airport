/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.Interfaces.ISearchStorage;
import Controllers.Interfaces.IUpdateInfo;
import Controllers.Validators.IValidatorPassenger;
import Controllers.Validators.IValidatorPassengerUpdate;
import Models.Passenger;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.LocalDate;

/**
 *
 * @author HOLA
 */
public class UpdateInfo implements IUpdateInfo {

    private final IValidatorPassengerUpdate vp;
    private final ISearchStorage searchStorage;

    // Inyección por constructor
    public UpdateInfo(IValidatorPassengerUpdate vp, ISearchStorage searchStorage) {
        this.vp = vp;
        this.searchStorage = searchStorage;

    }

    @Override
    public Response updatePassenger(String id, String firstName, String lastName,
            String year, String month, String day,
            String phoneCode, String phone, String country) {

        Response response = vp.validatePassenger(id, firstName, lastName, year, month, day, phoneCode, phone, country);

        if (response.getStatus() != Status.OK) {
            return response;
        }

        Passenger p = searchStorage.getPassenger(Long.parseLong(id));
        LocalDate BD = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        
        p.setFirstname(firstName);
        p.setLastname(lastName);
        p.setPhone(Long.parseLong(phone));
        p.setCountry(country);
        p.setCountryPhoneCode(Integer.parseInt(phoneCode));
        p.setBirthDate(BD);
        
        return response;

    }
}
