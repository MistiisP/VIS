package com.example.visprojekteshop.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ObjednavkaDto {
    private Long id;
    private Long zakaznikId;
    private Long dopravaId;
    private Long platbaId;
    private Date datum;
    
    public ObjednavkaDto(Long zakaznikId, Long dopravaId, Long platbaId, Date datum) {
        this.zakaznikId = zakaznikId;
        this.dopravaId = dopravaId;
        this.platbaId = platbaId;
        this.datum = datum;
    }

    public ObjednavkaDto(Long id, Long zakaznikId, Long dopravaId, Long platbaId, Date datum) {
        this.id = id;
        this.zakaznikId = zakaznikId;
        this.dopravaId = dopravaId;
        this.platbaId = platbaId;
        this.datum = datum;
    }
}
