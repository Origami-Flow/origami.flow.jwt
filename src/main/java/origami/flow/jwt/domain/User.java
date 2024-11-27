package origami.flow.jwt.domain;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User{

    private String email;

    private String password;
}
