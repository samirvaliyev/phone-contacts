package com.phonecontacts.service.contact;

import com.phonecontacts.dto.contact.ContactRequestDto;
import com.phonecontacts.dto.contact.ContactResponseDto;
import com.phonecontacts.dto.contact.ContactUpdateReqDto;
import com.phonecontacts.dto.contact.ContactUpdateResDto;
import com.phonecontacts.entity.Contact;
import com.phonecontacts.entity.UserRole;
import com.phonecontacts.exception.AccessDeniedContactUpdateException;
import com.phonecontacts.exception.ContactNotFoundException;
import com.phonecontacts.repository.ContactRepository;
import com.phonecontacts.repository.RoleRepository;
import com.phonecontacts.security.JwtService;
import com.phonecontacts.security.role.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;

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
    public ContactUpdateResDto updateContact(Long id, ContactUpdateReqDto updateDto, String token) {
        Integer roleId = getFreshRoleId(token);
        UserRole role = getRole(roleId);
        checkPermissionUser(role);
        Contact contactOld = contactRepository
                .findById(id).orElseThrow(ContactNotFoundException::new);
        contactOld.setContactName(updateDto.getContactName());
        contactOld.setEmails(updateDto.getEmails());
        contactOld.setPhones(updateDto.getPhones());
        final Contact contact = contactRepository.save(contactOld);
        return modelMapper.map(contact, ContactUpdateResDto.class);
    }

    @Override
    public List<ContactResponseDto> getAllContact() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contact -> modelMapper.map(contact, ContactResponseDto.class))
                .toList();
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    private void checkPermissionUser(final UserRole role) {
        if (!Objects.equals(role.getName(), RoleEnum.ADMIN.name())) {
            throw new AccessDeniedContactUpdateException();
        }
    }

    private UserRole getRole(final Integer roleId) {
        return roleRepository.findOneById(roleId);
    }

    private Integer getFreshRoleId(final String token) {
        return jwtService.prepareTokenWithRole(token);
    }
}
