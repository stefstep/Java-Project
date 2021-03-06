package blog.models;

import javax.persistence.*;

@Entity
@Table(name = "status_users")
public class Status_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatus;

    @Column(nullable = false, length = 50, unique = true)
    private String statususer;

    @Lob
    @Column()
    private String statusRights;
}
