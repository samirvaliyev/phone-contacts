package com.phonecontacts.service.contact;

import com.phonecontacts.dto.contact.ContactRequestDto;
import com.phonecontacts.dto.contact.ContactResponseDto;
import com.phonecontacts.dto.contact.ContactUpdateReqDto;
import com.phonecontacts.dto.contact.ContactUpdateResDto;
import com.phonecontacts.entity.Contact;
import com.phonecontacts.exception.ContactNotFoundException;
import com.phonecontacts.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    @Override
    public ContactResponseDto createContact(ContactRequestDto contactRequestDto) {
        final Contact contactBuilder = Contact.builder()
                .contactName(contactRequestDto.getContactName())
                .emails(contactRequestDto.getEmails())
                .phones(contactRequestDto.getPhones())
                .build();
        final Contact contact = contactRepository.save(contactBuilder);
        return modelMapper.map(contact, ContactResponseDto.class);
    }

    @Override
    public ContactUpdateResDto updateContact(Long id, ContactUpdateReqDto updateDto) {
        Contact contactOld = contactRepository
                .findById(id).orElseThrow(ContactNotFoundException::new);
        contactOld.setContactName(updateDto.getContactName());
        contactOld.setEmails(updateDto.getEmails());
        contactOld.setPhones(updateDto.getPhones());
        final Contact contact = contactRepository.save(contactOld);
        return modelMapper.map(contact, ContactUpdateResDto.class);
    }
}
