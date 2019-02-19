package com.lsc.component;

import com.lsc.entity.Contact;
import com.lsc.model.ContactModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("contactConverter")
public class ContactConverter {

    public Contact contactModelToEntity(ContactModel contactModel){
        Contact contact = new Contact();
        contact.setId(contactModel.getId());
        contact.setFirstName(contactModel.getFirstName());
        contact.setLastName(contactModel.getLastName());
        contact.setCity(contactModel.getCity());
        contact.setTelephone(contactModel.getTelephone());
        return contact;
    }

    public ContactModel contactEntityToModel(Contact contact){
        ContactModel contactModel = new ContactModel(contact.getId(),
                contact.getFirstName(), contact.getLastName(),
                contact.getTelephone(), contact.getCity());
        return contactModel;
    }

    public List<ContactModel> listContactEntityToModel(List<Contact> listContact){
        List<ContactModel> listContactModel = new ArrayList<ContactModel>();
        for(Contact contact : listContact){
            listContactModel.add(contactEntityToModel(contact));
        }
        return listContactModel;
    }

}
