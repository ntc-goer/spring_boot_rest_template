package personal.spring_boot_rest_template.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "birthDate")
    private LocalDateTime birthDate;

    public UserEntity() {}

    public UserEntity(String userName, Integer id, LocalDateTime birthDate) {
        this.userName = userName;
        this.id = id;
        this.birthDate = birthDate;
    }

    public UserEntity(String userName, LocalDateTime birthDate) {
        this.userName = userName;
        this.birthDate = birthDate;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
