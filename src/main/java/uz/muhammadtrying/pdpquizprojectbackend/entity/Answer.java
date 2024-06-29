package uz.muhammadtrying.pdpquizprojectbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    private Option chosenOption;
    private Timestamp timeSpent;
    private Integer score;
}