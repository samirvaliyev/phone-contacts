package com.phonecontacts.dto.contact;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactUpdateResDto {

    Long id;
    String contactName;
    List<String> emails;
    List<String> phones;
}
