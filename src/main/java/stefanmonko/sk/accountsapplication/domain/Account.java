package stefanmonko.sk.accountsapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Account {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    
}
