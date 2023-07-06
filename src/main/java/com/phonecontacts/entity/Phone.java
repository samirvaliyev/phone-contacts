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
@Table(name = Phone.TABLE_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Phone {

    public static final String TABLE_NAME = "contact_phones";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "phone_number")
    String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    Contact contact;
}
