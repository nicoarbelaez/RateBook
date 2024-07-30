package com.nicoarbelaez.ratebook.user;

import java.time.LocalDate;
import java.util.List;

import com.nicoarbelaez.ratebook.auth.Auth;
import com.nicoarbelaez.ratebook.rating.Rating;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Column(name = "reviews_count")
    private int reviewsCount;

    @Column(name = "items_evaluated_count")
    private int itemsEvaluatedCount;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Auth auth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Rating> ratings;
}
