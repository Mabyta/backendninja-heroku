package com.lsc.service.impl;

import com.lsc.component.ContactConverter;
import com.lsc.entity.Contact;
import com.lsc.model.ContactModel;
import com.lsc.repository.ContactRepository;
import com.lsc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.contactModelToEntity(contactModel));
        return contactConverter.contactEntityToModel(contact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        return contactConverter.listContactEntityToModel(contactRepository.findAll());
    }

    @Override
    public ContactModel findContactById(long id) {
        Contact contact = contactRepository.findById(id);
        return contactConverter.contactEntityToModel(contact);
    }

    @Override
    public void remove(ContactModel contactModel) {
        contactRepository.delete(contactConverter.contactModelToEntity(contactModel));
    }
}
