package com.phonecontacts.dto.contact;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactUpdateReqDto {

    @NotNull
    @NotBlank(message = "The contact name is required.")
    String contactName;

    @NotNull
    @NotBlank(message = "The emails is required.")
    List<String> emails;

    @NotNull
    @NotBlank(message = "The phones is required.")
    List<String> phones;
}
