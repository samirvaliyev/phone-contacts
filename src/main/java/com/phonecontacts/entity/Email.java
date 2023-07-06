package com.phonecontacts.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/*eger ishlese contact ichindeki list'ler sil*/
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Email.TABLE_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Email {

    public static final String TABLE_NAME = "contact_emails";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email_name")
    String emailName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    Contact contact;

    //TODO: @ 1. relation'lar bax, entity'lere yaml create ele, check ele
    //TODO: @ 2. login yaz, registeri done ele, check ele
    //TODO: @ 3. contact service logic yazx, check ele
    //TODO: @ 4. swagger elave ele, check ele
}
