package com.phonecontacts.service.contact;

import com.phonecontacts.dto.contact.ContactRequestDto;
import com.phonecontacts.dto.contact.ContactResponseDto;
import com.phonecontacts.dto.contact.ContactUpdateReqDto;
import com.phonecontacts.dto.contact.ContactUpdateResDto;

import java.util.List;

public interface ContactService {

    ContactResponseDto createContact(ContactRequestDto contactRequestDto);

    ContactUpdateResDto updateContact(Long id, ContactUpdateReqDto updateDto, String token);

    List<ContactResponseDto> getAllContact();

    void deleteContact(Long id);
}
