package com.lsc.service;

import com.lsc.model.ContactModel;

import java.util.List;

public interface ContactService {

    public abstract ContactModel addContact(ContactModel contactModel);
    public abstract List<ContactModel> listAllContacts();
    public abstract ContactModel findContactById(long id);
    public abstract void remove(ContactModel contactModel);
}
