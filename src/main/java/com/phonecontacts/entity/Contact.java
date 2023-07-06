package com.phonecontacts.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Contact.TABLE_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contact {

    public static final String TABLE_NAME = "contacts";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "contact_name")
    String contactName;

    @ElementCollection(targetClass = String.class)
    @JoinTable(name = "emails")
    List<String> emails;

    @ElementCollection(targetClass = String.class)
    @JoinTable(name = "phones")
    List<String> phones;
}