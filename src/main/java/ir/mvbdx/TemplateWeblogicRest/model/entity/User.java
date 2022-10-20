package ir.mvbdx.TemplateWeblogicRest.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data //@Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
    private Long id;
    @Column(name = "USER_NAME")
    private String username;
    private String password;
    private String nam;
    private String famil;
}