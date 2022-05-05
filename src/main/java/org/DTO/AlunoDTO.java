package org.DTO;

import javax.persistence.*;
import org.model.*;

import lombok.*;

@Getter
@Setter
public class AlunoDTO {
        
    private String matricula;

    private String nome;

    private String dt_nascimento;

}