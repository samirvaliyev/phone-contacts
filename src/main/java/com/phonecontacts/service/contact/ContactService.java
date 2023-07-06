package com.phonecontacts.service.contact;

import com.phonecontacts.dto.contact.ContactRequestDto;
import com.phonecontacts.dto.contact.ContactResponseDto;
import com.phonecontacts.dto.contact.ContactUpdateReqDto;
import com.phonecontacts.dto.contact.ContactUpdateResDto;

public interface ContactService {
    /*Buradaki api logic'ler token ile idare olunacaq.
     * Jwt ichine "roleId" elave etmishik. Ilk once her bir istifadechi USER rolu ile create edilir.
     * Bir SUPER_ADMIN artiq DB-de movcud olacaq ve istediyi user'i ADMIN ede bilecek
     * Bunun uchun gedib sadece spesific roleId'li userin role'na ADMIN yazmaq kifayet edir.*/

    ContactResponseDto createContact(ContactRequestDto contactRequestDto);

    ContactUpdateResDto updateContact(Long id, ContactUpdateReqDto updateDto);
}
